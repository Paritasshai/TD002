package com.tamdai.model.course.controller;

import com.tamdai.model.course.entity.ImageCourse;
import com.tamdai.model.course.repository.ImageCourseRepository;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.service.UserService;
import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.entity.VideoClip;
import com.tamdai.model.course.repository.VideoClipRepository;
import com.tamdai.model.course.service.CourseService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Film on 24/9/2559.
 */

@CrossOrigin
@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @Autowired
    VideoClipRepository videoClipRepository;

    @Autowired
    ImageCourseRepository imageCourseRepository;

    @RequestMapping(value = "add/courseDetail", method = RequestMethod.POST)
    public Course addCourseDetail(@RequestBody Course course, @RequestParam("userId") Long id, BindingResult bindingResult) {
        UserEntity user = userService.getUserId(id);
        return courseService.addCourseDetail(user, course);
    }

    @RequestMapping(value = "course/{id}", method = RequestMethod.GET)
    public Course getCourseId(@PathVariable("id") Long id) {
        return courseService.getCourseId(id);
    }

    @RequestMapping(value = "get/courseDetail", method = RequestMethod.GET)
    public List<Course> list(HttpServletRequest request) throws IOException {
        return courseService.getvideos();
    }

    @RequestMapping(value = "update/course/{id}", method = RequestMethod.PUT)
    public Course updateCourse(@PathVariable("id") Long id,
                               @RequestParam("name") String name,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price) {
        Course course = courseService.getCourseId(id);
        course.setName(name);
        course.setDescription(description);
        course.setPrice(price);
        return courseService.updateCourse(course);
    }

    @RequestMapping(value = "add/video", method = RequestMethod.POST)

    public @ResponseBody
    String handleFileUpload(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam("id") Long id,
                            @RequestParam("file") MultipartFile file) throws IOException {
        MultipartHttpServletRequest mRequest;
        Course course = courseService.getCourseId(id);

        if (!file.isEmpty()) {
            try {
                mRequest = (MultipartHttpServletRequest) request;
                Iterator<String> itr = mRequest.getFileNames();
                while (itr.hasNext()) {
                    MultipartFile multipartFile = mRequest.getFile(itr.next());

                    String destination = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\video\\" + multipartFile.getOriginalFilename();
                    course.setPath(destination);
                    courseService.updateCourse(course);

                    VideoClip video = new VideoClip();
                    video.setFileName(multipartFile.getOriginalFilename());
                    video.setContentType(multipartFile.getContentType());

                    //setDate
                    String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                    video.setCreateDate(date);
                    video.setPath(destination);
                    courseService.saveVideo(video, course);

                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\video\\" + multipartFile.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                }
                return "You successfully uploaded ";
            } catch (Exception e) {
                return "You failed to upload " + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + " because the file was empty.";
        }
    }

    @RequestMapping(value = "get/videoList", method = RequestMethod.GET)
    public List<VideoClip> getvideoList(HttpServletRequest request) throws IOException {
        return courseService.getVideoList();
    }

    @RequestMapping(value = "playVideo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void home(@PathVariable("id") Long id, Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        /// logger.info("Welcome home! The client locale is {}.", locale);

        VideoClip videoClip = videoClipRepository.findOne(id);

        String filePath = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\video\\" + videoClip.getFileName();

        int fileSize = (int) new File(filePath).length();
        response.setContentLength(fileSize);
        response.setContentType("video");

        FileInputStream inputStream = new FileInputStream(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        int value = IOUtils.copy(inputStream, outputStream);
        System.out.println("File Size :: " + fileSize);
        System.out.println("Copied Bytes :: " + value);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }

    @RequestMapping(value = "get/imageCurseList", method = RequestMethod.GET)
    public List<ImageCourse> getImageCurseList(HttpServletRequest request) throws IOException {
        return courseService.getImageCurseList();
    }

    @RequestMapping(value = "add/ImageCourse", method = RequestMethod.POST)
    @ResponseBody
    public Course addImageUser(HttpServletRequest request,
                               @RequestParam("file") MultipartFile file, @RequestParam("id") Long id) throws IOException {
        MultipartHttpServletRequest mRequest;
        Course course = courseService.getCourseId(id);

        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());

                ImageCourse imageCourse = new ImageCourse();
                imageCourse.setImageName(multipartFile.getOriginalFilename());
                imageCourse.setImagecontentType(multipartFile.getContentType());

                //setDate
                String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                imageCourse.setCreateDate(date);
                courseService.saveImage(course, imageCourse);

                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\image\\" + multipartFile.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }

    @RequestMapping(value = "displayImage/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void image(@PathVariable("id") Long id, Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        ImageCourse imageCourse = imageCourseRepository.findOne(id);

        String filePath = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\image\\" + imageCourse.getImageName();

        int fileSize = (int) new File(filePath).length();
        response.setContentLength(fileSize);
        response.setContentType("image");

        FileInputStream inputStream = new FileInputStream(filePath);
        ServletOutputStream outputStream = response.getOutputStream();
        int value = IOUtils.copy(inputStream, outputStream);
        System.out.println("File Size :: " + fileSize);
        System.out.println("Copied Bytes :: " + value);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
    }

    @RequestMapping(value = "delete/Image", method = RequestMethod.DELETE)
    @ResponseBody
    public Course deleteImageCourse(@RequestParam("imageId") Long imageId, @RequestParam("courseId") Long courseId) {
        Course course = courseService.getCourseId(courseId);
        return courseService.deleteImageCourse(course, imageId);
    }

    @RequestMapping(value = "delete/Video", method = RequestMethod.DELETE)
    @ResponseBody
    public Course deleteVideoCourse(@RequestParam("videoId") Long videoId, @RequestParam("courseId") Long courseId) {
        Course course = courseService.getCourseId(courseId);
        return courseService.deleteVideoCourse(course, videoId);
    }

}
