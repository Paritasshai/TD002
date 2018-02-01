package com.tamdai.model.course.controller;

import com.tamdai.model.config.DateTimeUtil;
import com.tamdai.model.course.entity.Course;
//import com.tamdai.model.course.entity.ImageCourse;
import com.tamdai.model.course.entity.ImageCourse;
import com.tamdai.model.course.repository.CourseRepository;
//import com.tamdai.model.course.repository.ImageCourseRepository;
//import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.course.repository.ImageCourseRepository;
import com.tamdai.model.security.service.UserService;
import com.tamdai.model.course.repository.VideoClipRepository;
import com.tamdai.model.course.service.CourseService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;

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
            System.out.println("User ID: " + userId);
            System.out.println("ShowLock: " + course.showLock);
            System.out.println("User Course: " + userCourse);
            course.showLock = (userCourse == null ? 1 : 0);
        }
        return course;
    }

    @RequestMapping(value = "courseItemByPublic", method = RequestMethod.GET)
    public List<Course> courseItemByPublic(@RequestParam("textPublic") String textPublic) {
        return courseService.courseItemByPublic(textPublic);
    }

    @RequestMapping(value = "getCourseByUserId/{id}", method = RequestMethod.GET)
    public List<Course> getCourseByUserId(@PathVariable("id") Long id,
                                          @RequestParam("textPublic") String textPublic) {
        return courseService.getCourseByUserId(textPublic, id);
    }

    @RequestMapping(value = "getCoursenewType", method = RequestMethod.GET)
    public List<Course> getCoursenewType(@RequestParam("textPublic") String textPublic,
                                         @RequestParam("newType") String newType) {
        return courseService.getCoursenewType(textPublic, newType);
    }

    @RequestMapping(value = "getSearchObject", method = RequestMethod.GET)
    public List<Course> getSearchObject(@RequestParam("Pname") String Pname,
                                        @RequestParam("textPublic") String textPublic,
                                        @RequestParam("textNull") String textNull,
                                        @RequestParam("rbGroup") String rbGroup) {
        return courseService.getSearchObject(Pname, textPublic, textNull, rbGroup);
    }

//    @RequestMapping(value = "getSearchObjectCon", method = RequestMethod.GET)
//    public List<Course> getSearchObjectCon(@RequestParam("Pname") String Pname,
//                                           @RequestParam("textPublic") String textPublic,
//                                           @RequestParam("day") String day,
//                                           @RequestParam("textNull") String textNull,
//                                           @RequestParam("rbGroup") String rbGroup) {
//        return courseService.getSearchObjectCon(Pname, day, textPublic, textNull, rbGroup);
//    }

//    @RequestMapping(value = "getSearchObjectCon", method = RequestMethod.GET)
//    public List<Course> getSearchObjectCon(String firstName, String surName, Integer countryid, Integer companyId) {
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Contacts> query = cb.createQuery(Contacts.class);
//        Root<Contacts> cont = query.from(Contacts.class);
//        query.select(cont);
//
//        // Join<Contacts, Country> country = cont.join("country", JoinType.LEFT);
//        List<Predicate> predicateList = new ArrayList<Predicate>();
//
//        if ((firstName != null) && (!(firstName.isEmpty()))) {
//            ParameterExpression<String> p
//                    = cb.parameter(String.class, "firstName");
//            predicateList.add(cb.like(cb.upper(cont.<String>get("firstName")), "%" + firstName.toUpperCase() + "%"));
//
//        }
//
//        if ((surName != null) && (!(surName.isEmpty()))) {
//            ParameterExpression<String> p
//                    = cb.parameter(String.class, "surName");
//            predicateList.add(cb.like(cb.upper(cont.<String>get("surName")), "%" + surName.toUpperCase() + "%"));
//
//        }
//
//        if ((countryid != null) && (countryid != 0)) {
//            Join<Contacts, Country> country = cont.join("country");
//            ParameterExpression<Integer> ci
//                    = cb.parameter(Integer.class, "countryid");
//            predicateList.add(cb.equal(country.get("countryid"), ci));
//        }
//
//        if ((companyId != null) && (companyId != 0)) {
//            Join<Contacts, Company> company = cont.join("company");
//            ParameterExpression<Integer> co
//                    = cb.parameter(Integer.class, "companyId");
//            predicateList.add(cb.equal(company.get("companyId"), co));
//        }
//
//        if (predicateList.size() == 0) {
//            query.select(cont);
//        } else {
//            if (predicateList.size() == 1) {
//                query.where(predicateList.get(0));
//            } else {
//                query.where(cb.and(predicateList.toArray(new Predicate[0])));
//            }
//        }
//
//        TypedQuery<Contacts> tq = em.createQuery(query);
//        if (firstName != null) {
//            tq.setParameter("firstName", firstName);
//        }
//        if (surName != null) {
//            tq.setParameter("surName", surName);
//        }
//
//        if ((countryid != null) && (countryid != 0)) {
//            tq.setParameter("countryid", countryid);
//        }
//
//        if ((companyId != null) && (companyId != 0)) {
//            tq.setParameter("companyId", companyId);
//        }
//
//        ListDataModel<Contacts> contactsResultList = new ListDataModel<Contacts>(tq.getResultList());
//        return contactsResultList;
//
//    }

    @RequestMapping(value = "getSearchObjectPay", method = RequestMethod.GET)
    public List<Course> getSearchObjectPay(@RequestParam("Pname") String Pname,
                                           @RequestParam("textPublic") String textPublic,
                                           @RequestParam("textNull") String textNull,
                                           @RequestParam("rbGroup") String rbGroup) {

        return courseService.getSearchObjectPay(Pname, textPublic, textNull, rbGroup);
    }

//    @RequestMapping(value = "getSearchByDate", method = RequestMethod.GET)
//    public List<Course> getSearchByDate(@RequestParam("Date") String day,
//                                        @RequestParam("textPublic") String textPublic) {
//
//        return courseService.getSearchByDate(day, textPublic);
//    }

    @RequestMapping(value = "getSearchObjectFreePname", method = RequestMethod.GET)
    public List<Course> getSearchObjectFreePname(@RequestParam("Pname") String Pname,
                                                 @RequestParam("textPublic") String textPublic,
                                                 @RequestParam("textNull") String textNull) {

        return courseService.getSearchObjectFreePname(Pname, textPublic, textNull);
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

    @RequestMapping(value = "getCourseLego", method = RequestMethod.GET)
    public List<Course> getCourseLego(@RequestParam("textPublic") String textPublic,
                                      @RequestParam("LegoText") String LegoText) {
        return courseService.getCourseLego(textPublic, LegoText);
    }

    @RequestMapping(value = "getCourseHousehold", method = RequestMethod.GET)
    public List<Course> getCourseHousehold(@RequestParam("textPublic") String textPublic,
                                           @RequestParam("HouseholdText") String HouseholdText) {
        return courseService.getCourseHousehold(textPublic, HouseholdText);
    }

    @RequestMapping(value = "getCourseToy", method = RequestMethod.GET)
    public List<Course> getCourseToy(@RequestParam("textPublic") String textPublic,
                                     @RequestParam("ToyText") String ToyText) {
        return courseService.getCourseToy(textPublic, ToyText);
    }

    @RequestMapping(value = "getSearchByName", method = RequestMethod.GET)
    public List<Course> getSearchByName(@RequestParam("textPublic") String textPublic,
                                        @RequestParam("querySearch") String querySearch) {
        return courseService.getSearchByName(textPublic, querySearch);
    }

    @RequestMapping(value = "getSearchByFree", method = RequestMethod.GET)
    public List<Course> getSearchByFree(@RequestParam("textPublic") String textPublic,
                                        @RequestParam("empty") String empty) {
        return courseService.getSearchByFree(textPublic, empty);
    }

    @RequestMapping(value = "getsearchAdvance", method = RequestMethod.GET)
    public List<Course> getsearchAdvance(@RequestParam("textPublic") String textPublic,
                                         @RequestParam("Pname") String Pname) {

        return courseService.getsearchAdvance(textPublic, Pname);
    }

    @RequestMapping(value = "getCourseGarden", method = RequestMethod.GET)
    public List<Course> getCourseGarden(@RequestParam("textPublic") String textPublic,
                                        @RequestParam("GardenText") String GardenText) {
        return courseService.getCourseGarden(textPublic, GardenText);
    }

    @RequestMapping(value = "getCourseIoT", method = RequestMethod.GET)
    public List<Course> getCourseIoT(@RequestParam("textPublic") String textPublic,
                                     @RequestParam("IoTText") String IoTText) {
        return courseService.getCourseIoT(textPublic, IoTText);
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
                               @RequestParam("publicCourse") String publicCourse,
                               @RequestParam("courseType") String courseType,
                               @RequestParam("catagory") String catagory,
                               @RequestParam("dateCreateCourse") String dateCreateCourse) {
        Course course = courseService.getCourseId(id);
        course.setName(name);
        course.setDescription(description);
        course.setPrice(price);
        course.setPublicCourse(publicCourse);
        course.setLinkCourse(linkCourse);
        course.setCourseType(courseType);
        course.setCatagory(catagory);
        course.setDateCreateCourse(dateCreateCourse);
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
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\imagecourse\\" + multipartFile.getOriginalFilename())));
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
    public void image(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {

        ImageCourse imageCourse = imageCourseRepository.findOne(id);

        String filePath = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\imagecourse\\" + imageCourse.getImageName();

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

    // Search Day
    @RequestMapping(value = "getSearchByDate", method = RequestMethod.GET)
    public List<Course> getSearchByDate(@RequestParam("Date") String day,
                                        @RequestParam("textPublic") String textPublic) {
        // public List<Course> searchByNumDay ( int day){
        Date currDate = DateTimeUtil.getCurrentDate();
        int date = Integer.parseInt(day);
        Date searchDate = DateTimeUtil.minus(currDate, date);

        System.out.println("Current Date: " + currDate);
        System.out.println("search Date: " + searchDate);
        System.out.println("===========================================================");

        String startDate = DateTimeUtil.date2str(searchDate);
        String endDate = DateTimeUtil.date2str(currDate);

        System.out.println("start Date: " + startDate);
        System.out.println("end Date: " + endDate);
        System.out.println("===========================================================");

        return courseService.getSearchByDate(startDate,endDate, textPublic);
    }

}
