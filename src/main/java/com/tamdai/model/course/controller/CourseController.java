package com.tamdai.model.course.controller;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.entity.ImageCourse;
import com.tamdai.model.course.repository.CourseRepository;
import com.tamdai.model.course.repository.ImageCourseRepository;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.service.UserService;
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

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping(value = "create/course", method = RequestMethod.POST)
    public Course createCourse(@RequestBody Course course, @RequestParam("userId") Long userId, BindingResult bindingResult) {
        return courseService.createCourse(userId, course);
    }

    @RequestMapping(value = "course/{id}", method = RequestMethod.GET)
    public Course getCourseId(@PathVariable("id") Long id) {
        return courseService.getCourseId(id);
    }

    @RequestMapping(value = "coursePurchased", method = RequestMethod.GET)
    public Course getCourseId(@RequestParam("courseId") Long courseId,
                              @RequestParam("userId") Long userId) {

        Course course = courseService.getCourseId(courseId);
        course.showLock = 1;
        if (userId != null) {
            Course userCourse = courseService.getCourseByUser(courseId, userId);
            System.out.println("===================================== Print =====================================");
            System.out.println("User ID: " +userId);
            System.out.println("ShowLock: "+ course.showLock);
            System.out.println("User Course: "+ userCourse);
            course.showLock = (userCourse == null ? 1 : 0);
        }
        return course;
    }

    @RequestMapping(value = "courseItemByPublic", method = RequestMethod.GET)
    public List<Course> courseItemByPublic(@RequestParam("textPublic") String textPublic) {
        return courseService.courseItemByPublic(textPublic);
    }

    @RequestMapping(value = "getCoursenewType", method = RequestMethod.GET)
    public List<Course> getCoursenewType(@RequestParam("textPublic") String textPublic,
                                         @RequestParam("newType") String newType) {
        return courseService.getCoursenewType(textPublic, newType);
    }

    @RequestMapping(value = "getCourserecommendType", method = RequestMethod.GET)
    public List<Course> getCourserecommendType(@RequestParam("textPublic") String textPublic,
                                               @RequestParam("recommendType") String recommendType) {
        return courseService.getCourserecommendType(textPublic, recommendType);
    }

    @RequestMapping(value = "getCourseHotType", method = RequestMethod.GET)
    public List<Course> getCourseHotType(@RequestParam("textPublic") String textPublic,
                                         @RequestParam("hotType") String hotType) {
        return courseService.getCourseHotType(textPublic, hotType);
    }

    @RequestMapping(value = "getCourseList", method = RequestMethod.GET)
    public List<Course> getCourseList() {
        return courseService.getCourseList();
    }

    @RequestMapping(value = "update/course/{id}", method = RequestMethod.PUT)
    public Course updateCourse(@PathVariable("id") Long id,
                               @RequestParam("name") String name,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price,
                               @RequestParam("linkCourse") String linkCourse,
                               @RequestParam("publicCourse") String publicCourse) {
        Course course = courseService.getCourseId(id);
        course.setName(name);
        course.setDescription(description);
        course.setPrice(price);
        course.setPublicCourse(publicCourse);
        course.setLinkCourse(linkCourse);
        return courseService.updateCourse(course);
    }

    @RequestMapping(value = "get/imageCourseList", method = RequestMethod.GET)
    public List<ImageCourse> getImageCourseList(HttpServletRequest request) throws IOException {
        return courseService.getImageCourseList();
    }

    @RequestMapping(value = "add/ImageCourse", method = RequestMethod.POST)
    @ResponseBody
    public Course addImageCourse(HttpServletRequest request,
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
                imageCourse.setImageContentType(multipartFile.getContentType());
                courseService.saveCourseImage(course, imageCourse);

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

    @RequestMapping(value = "deleteCourse/{id}", method = RequestMethod.DELETE)
    public Course deleteCourse(@PathVariable("id") Long id) {
        return courseService.deleteCourse(id);
    }

    @RequestMapping(value = "delete/Image", method = RequestMethod.DELETE)
    @ResponseBody
    public Course deleteImageCourse(@RequestParam("imageId") Long imageId, @RequestParam("courseId") Long courseId) {
        Course course = courseService.getCourseId(courseId);
        return courseService.deleteImageCourse(course, imageId);
    }


//    @RequestMapping("/addCourseInSystem")
//    public String process() {
//        courseRepository.save(new Course(1L, 2L, "Course 1", "Technology for life 1."));
//        courseRepository.save(new Course(2L, 2L, "Course 2", "Technology for life 2."));
//        courseRepository.save(new Course(3L, 2L, "Course 3", "Technology for life 3."));
//        return "Create Course Done!!";
//    }

}
