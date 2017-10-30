package com.tamdai.model.course.controller;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.entity.CourseImage;
import com.tamdai.model.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

@CrossOrigin
@Controller
@RequestMapping("/")
public class CourseImageController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "add/ImageCourse", method = RequestMethod.POST)
    @ResponseBody
    public Course addImageCourse(HttpServletRequest request,
                                 HttpServletResponse response, @RequestParam("id") Long id) {
        MultipartHttpServletRequest mRequest;
        Course course = courseService.getCourseId(id);

        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                CourseImage courseImage = new CourseImage();
                courseImage.setFileName(multipartFile.getOriginalFilename());
                courseImage.setContentType(multipartFile.getContentType());
                courseImage.setContent(multipartFile.getBytes());
                courseService.addImageCourse(course, courseImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }

    @RequestMapping(value = "delete/Image", method = RequestMethod.DELETE)
    @ResponseBody
    public Course deleteImage(@RequestParam("imageId") Long imageId, @RequestParam("courseId") Long courseId) {
        Course course = courseService.getCourseId(courseId);
        return courseService.deleteImage(course, imageId);
    }
}
