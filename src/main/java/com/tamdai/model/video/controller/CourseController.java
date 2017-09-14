package com.tamdai.model.video.controller;

import com.tamdai.model.video.entity.Course;
import com.tamdai.model.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

@CrossOrigin
@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "add/courseDetail", method = RequestMethod.POST)
    public Course addVideoDetail(@RequestBody Course course, BindingResult bindingResult) {
        return courseService.addVideo(course);
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

}
