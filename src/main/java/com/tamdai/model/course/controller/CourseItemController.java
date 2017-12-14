package com.tamdai.model.course.controller;

import com.tamdai.model.course.entity.*;
//import com.tamdai.model.course.repository.ImageCourseRepository;
import com.tamdai.model.course.repository.ImageItemRepository;
import com.tamdai.model.course.repository.VideoClipRepository;
import com.tamdai.model.course.service.CourseService;
import com.tamdai.model.security.service.UserService;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Created by Film on 21/9/2560.
 */

@CrossOrigin
@RestController
@RequestMapping("/")
public class CourseItemController {

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @Autowired
    VideoClipRepository videoClipRepository;

//    @Autowired
//    ImageCourseRepository imageCourseRepository;

    @Autowired
    ImageItemRepository imageItemRepository;

    @RequestMapping(value = "update/ItemDetails/{id}", method = RequestMethod.PUT)
    public CourseItem updateCourseItem(@PathVariable("id") Long id,
                                       @RequestParam("name") String name,
                                       @RequestParam("description") String description,
                                       @RequestParam("videoPath") String videoPath,
                                       @RequestParam("courseText") String courseText,
                                       @RequestParam("videoTime") String videoTime,
                                       @RequestParam("canPreview") String canPreview) {
        CourseItem courseItem = courseService.courseItemId(id);
        courseItem.setName(name);
        courseItem.setDescription(description);
        courseItem.setCanPreview(canPreview);
        courseItem.setVideoPath(videoPath);
        courseItem.setCourseText(courseText);
        courseItem.setVideoTime(videoTime);
        return courseService.updateCourseItem(courseItem);
    }

    @RequestMapping(value = "create/courseVideoItem", method = RequestMethod.POST)
    public CourseItem createCourseVideoItem(@RequestBody CourseItem courseItem, @RequestParam("courseId") Long id, BindingResult bindingResult) {
        Course course = courseService.getCourseId(id);
        return courseService.createCourseVideoItem(courseItem, course);
    }

    @RequestMapping(value = "create/courseImageItem", method = RequestMethod.POST)
    public CourseItem createCourseImageItem(@RequestBody CourseItem courseItem, @RequestParam("courseId") Long id, BindingResult bindingResult) {
        Course course = courseService.getCourseId(id);
        return courseService.createCourseImageItem(courseItem, course);
    }

    @RequestMapping(value = "create/courseTextItem", method = RequestMethod.POST)
    public CourseItem createCourseTextItem(@RequestBody CourseItem courseItem, @RequestParam("courseId") Long id, BindingResult bindingResult) {
        Course course = courseService.getCourseId(id);
        return courseService.createCourseTextItem(courseItem, course);
    }

    @RequestMapping(value = "get/courseItems", method = RequestMethod.GET)
    public List<CourseItem> list(HttpServletRequest request) throws IOException {
        return courseService.getCourseItemList();
    }

    @RequestMapping(value = "getCourseItemById/{id}", method = RequestMethod.GET)
    public CourseItem getCourseItemById(@PathVariable("id") Long id) {
        return courseService.getCourseItemById(id);
    }

    @RequestMapping(value = "courseItem/{id}", method = RequestMethod.GET)
    public CourseItem courseItemId(@PathVariable("id") Long id) {
        return courseService.courseItemId(id);
    }

    @RequestMapping(value = "add/videoItem", method = RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam("id") Long id,
                            @RequestParam("file") MultipartFile file) throws IOException {
        MultipartHttpServletRequest mRequest;
        CourseItem courseItem = courseService.courseItemId(id);

        if (!file.isEmpty()) {
            try {
                mRequest = (MultipartHttpServletRequest) request;
                Iterator<String> itr = mRequest.getFileNames();
                while (itr.hasNext()) {
                    MultipartFile multipartFile = mRequest.getFile(itr.next());

                    String destination = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\video\\" + multipartFile.getOriginalFilename();

                    VideoClip video = new VideoClip();
                    video.setFileName(multipartFile.getOriginalFilename());
                    video.setLessonName(multipartFile.getOriginalFilename());
                    video.setContentType(multipartFile.getContentType());

                    //setDate
                    String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                    video.setCreateDate(date);
                    video.setPath(destination);
                    courseService.saveVideo(video, courseItem);

                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\video\\" + multipartFile.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                }
                return "You successfully uploaded ";
            } catch (Exception e) {
                return "Failed to upload " + " => " + e.getMessage();
            }
        } else {
            return "Failed to upload " + " because the file was empty.";
        }
    }

    @RequestMapping(value = "get/videoList", method = RequestMethod.GET)
    public List<VideoClip> getvideoList(HttpServletRequest request) throws IOException {
        return courseService.getVideoList();
    }

    @RequestMapping(value = "playVideo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void home(@PathVariable("id") Long id, Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
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

//    @RequestMapping(value = "delete/Video", method = RequestMethod.DELETE)
//    @ResponseBody
//    public CourseItem deleteVideoCourse(@RequestParam("videoId") Long videoId, @RequestParam("courseId") Long courseId) {
//        CourseItem courseItem = courseService.getCourseId(courseId);
//        return courseService.deleteVideoCourse(courseItem, videoId);
//    }

    @RequestMapping(value = "get/videoCourseList", method = RequestMethod.GET)
    public List<VideoClip> getVideoCourseList(HttpServletRequest request) throws IOException {
        return courseService.getVideoCourseList();
    }

//    @RequestMapping(value = "edit/videoFileName/{id}", method = RequestMethod.PUT)
//    public VideoClip editVideoFileName(@PathVariable("id") Long id,
//                                       @RequestParam("lessonName") String lessonName) {
//        VideoClip videoClip = courseService.getVideoClipsById(id);
//        videoClip.setLessonName(lessonName);
//        return courseService.updateVideoClips(videoClip);
//    }

    @RequestMapping(value = "videoClips/{id}", method = RequestMethod.GET)
    public VideoClip getVideoClipsById(@PathVariable("id") Long id) {
        return courseService.getVideoClipsById(id);
    }

    @RequestMapping(value = "add/imageItem", method = RequestMethod.POST)
    @ResponseBody
    public CourseItem addImageItem(HttpServletRequest request,
                                   @RequestParam("file") MultipartFile file, @RequestParam("id") Long id) throws IOException {
        MultipartHttpServletRequest mRequest;
        CourseItem courseItem = courseService.getCourseItemById(id);

        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());

                String destination = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\imageitem\\" + multipartFile.getOriginalFilename();

                ImageItem imageItem = new ImageItem();
                imageItem.setImageName(multipartFile.getOriginalFilename());
                imageItem.setImageContentType(multipartFile.getContentType());
                imageItem.setPath(destination);
                courseService.saveCourseImageItem(courseItem, imageItem);

                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\imageitem\\" + multipartFile.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return courseItem;
    }

    @RequestMapping(value = "displayImageItem/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void image(@PathVariable("id") Long id, Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        ImageItem imageItem = imageItemRepository.findOne(id);

        String filePath = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\imageitem\\" + imageItem.getImageName();

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

    @RequestMapping(value = "get/imageItemCourseList", method = RequestMethod.GET)
    public List<ImageItem> getImageItemCourseList(HttpServletRequest request) throws IOException {
        return courseService.getImageItemCourseList();
    }

    @RequestMapping(value = "deleteItem", method = RequestMethod.DELETE)
    @ResponseBody
    public Course deleteItem(@RequestParam("courseItem") Long courseItem, @RequestParam("courseId") Long courseId) {
        Course course = courseService.getCourseId(courseId);
        return courseService.deleteItem(course, courseItem);
    }

}
