package com.tamdai.model.robomind.controller;

import com.tamdai.model.robomind.entity.*;
import com.tamdai.model.robomind.repository.ContentImgRepository;
import com.tamdai.model.robomind.repository.RoboImageRepository;
import com.tamdai.model.robomind.repository.RobomindRepository;
import com.tamdai.model.robomind.service.RobomindService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Film on 2/12/2560.
 */

@CrossOrigin
@RestController
@RequestMapping("/")
public class RobomindController {

    @Autowired
    RobomindService robomindService;

    @Autowired
    RoboImageRepository roboImageRepository;

    @RequestMapping(value = "createProfile", method = RequestMethod.POST)
    public StudentProfile createProfile(@RequestBody StudentProfile stProfile, BindingResult bindingResult) {
        return robomindService.createProfile(stProfile);
    }

    @RequestMapping(value = "createRoboticName", method = RequestMethod.POST)
    public Robotic createRoboticName(@RequestBody Robotic robotic, BindingResult bindingResult) {
        return robomindService.createRoboticName(robotic);
    }

    @RequestMapping(value = "RoboticNameList", method = RequestMethod.GET)
    public List<Robotic> RoboticNameList() {
        return robomindService.RoboticNameList();
    }

    @RequestMapping(value = "createComment/{id}", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment,
                                 @PathVariable("id") Long id, BindingResult bindingResult) {
        StudentProfile studentProfile = robomindService.getStudentId(id);

        //Date
        String Date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        comment.setCreateDate(Date);

        return robomindService.createComment(comment, studentProfile);
    }

    @RequestMapping(value = "getStudentList", method = RequestMethod.GET)
    public List<StudentProfile> getStudentList() {
        return robomindService.getStudentList();
    }

    @RequestMapping(value = "getStudent/{id}", method = RequestMethod.GET)
    public StudentProfile getStudentId(@PathVariable("id") Long id) {
        return robomindService.getStudentId(id);
    }


    @RequestMapping(value = "getRoboticId/{id}", method = RequestMethod.GET)
    public Robotic getRoboticId(@PathVariable("id") Long id) {
        return robomindService.getRoboticId(id);
    }

    @RequestMapping(value = "getStudentStId", method = RequestMethod.GET)
    public StudentProfile getStudentStId(@RequestParam("stStudentId") String stStudentId) {
        return robomindService.getStudentStid(stStudentId);
    }

    @RequestMapping(value = "editProfile/{id}", method = RequestMethod.PUT)
    public StudentProfile editProfile(@PathVariable("id") Long id,
                                      @RequestParam("stId") String stId,
                                      @RequestParam("stNickname") String stNickname,
                                      @RequestParam("stFirstname") String stFirstname,
                                      @RequestParam("stLastname") String stLastname,
                                      @RequestParam("stSchool") String stSchool,
                                      @RequestParam("stDate") String stDate,
                                      @RequestParam("stAge") String stAge,
                                      @RequestParam("stParent") String stParent,
                                      @RequestParam("stEmail") String stEmail,
                                      @RequestParam("stMobile") String stMobile,
                                      @RequestParam("stStart") String stStart) {

        StudentProfile student = robomindService.getStudentId(id);

        student.setStId(stId);
        student.setStNickname(stNickname);
        student.setStFirstname(stFirstname);
        student.setStLastname(stLastname);
        student.setStSchool(stSchool);
        student.setStDate(stDate);
        student.setStAge(stAge);
        student.setStParent(stParent);
        student.setStEmail(stEmail);
        student.setStMobile(stMobile);
        student.setStStart(stStart);
        return robomindService.editProfile(student);
    }

    @RequestMapping(value = "editContent/{id}", method = RequestMethod.PUT)
    public Content editContent(@PathVariable("id") Long id,
                               @RequestParam("stStudentId") String stStudentId,
                               @RequestParam("stTeacher") String stTeacher,
                               @RequestParam("stTime") String stTime,
                               @RequestParam("stContent") String stContent,
                               @RequestParam("contentDate") String contentDate,
                               @RequestParam("rbName") String rbName,
                               @RequestParam("rbGroup") String rbGroup) {

        Content content = robomindService.getContent(id);
        content.setStStudentId(stStudentId);
        content.setStTime(stTime);
        content.setStTeacher(stTeacher);
        content.setStContent(stContent);
        content.setContentDate(contentDate);
        content.setRbName(rbName);
        content.setRbGroup(rbGroup);

        return robomindService.editContent(content);
    }

    @RequestMapping(value = "addStudentImage/{id}", method = RequestMethod.POST)
    @ResponseBody
    public StudentProfile addStudentImage(HttpServletRequest request,
                                          @RequestParam("file") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        MultipartHttpServletRequest mRequest;
        StudentProfile studentProfile = robomindService.getStudentId(id);

        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());

                RoboImage roboImage = new RoboImage();
                roboImage.setFileName(multipartFile.getOriginalFilename());
                roboImage.setContentType(multipartFile.getContentType());
                robomindService.saveStudentImage(studentProfile, roboImage);

                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\roboImg\\" + multipartFile.getOriginalFilename())));
//       /opt/resource/roboImg/
//       C:\Users\Film\Documents\Tamdai\td002\src\main\resources\roboImg\
                stream.write(bytes);
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentProfile;
    }

    @RequestMapping(value = "displayImageStudent/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void image(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {

        RoboImage image = roboImageRepository.findOne(id);

        String filePath = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\roboImg\\" + image.getFileName();
//        C:\Users\Film\Documents\Tamdai\td002\src\main\resources\roboImg\
//        /opt/resource/roboImg

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

    @RequestMapping(value = "delete/ImageStudent", method = RequestMethod.DELETE)
    @ResponseBody
    public StudentProfile deleteImageStudent(@RequestParam("imageId") Long imageId, @RequestParam("stId") String stId) {
        StudentProfile student = robomindService.getStudentStid(stId);
        return robomindService.deleteImageStudent(student, imageId);
    }

    @RequestMapping(value = "delete/roboticDelete", method = RequestMethod.DELETE)
    @ResponseBody
    public Robotic roboticDelete(@RequestParam("roboticId") Long id) {
        Robotic robotic = robomindService.getRoboticId(id);
        return robomindService.roboticDelete(robotic);
    }

    @RequestMapping(value = "addContent", method = RequestMethod.POST)
    public StudentProfile addContent(@RequestBody Content content,
                                     @RequestParam("stIdPath") String stIdPath, BindingResult bindingResult) {
        StudentProfile student = robomindService.getStudentStid(stIdPath);
        return robomindService.addContent(student, content);
    }

    @RequestMapping(value = "getContent/{id}", method = RequestMethod.GET)
    public Content getContent(@PathVariable("id") Long id) {
        return robomindService.getContent(id);
    }

    @RequestMapping(value = "deleteContent", method = RequestMethod.DELETE)
    @ResponseBody
    public StudentProfile deleteContent(@RequestParam("id") Long id,
                                        @RequestParam("stStudentId") String stStudentId) {
        StudentProfile studentProfile = robomindService.getStudentStid(stStudentId);
        return robomindService.deleteContent(id, studentProfile);
    }

    @RequestMapping(value = "addContentImage/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Content addImageContent(HttpServletRequest request,
                                   @RequestParam("file") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        MultipartHttpServletRequest mRequest;
        Content content = robomindService.getContent(id);
        try {
            mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());

                ContentImg contentImg = new ContentImg();
                contentImg.setFileName(multipartFile.getOriginalFilename());
                contentImg.setContentType(multipartFile.getContentType());
                robomindService.addImageContent(content, contentImg);

                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\contentimg\\" + multipartFile.getOriginalFilename())));
//              /opt/resource/contentimg/
//              C:\Users\Film\Documents\Tamdai\td002\src\main\resources\contentimg\
                stream.write(bytes);
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }

    @RequestMapping(value = "getContentList", method = RequestMethod.GET)
    public List<Content> getContentList() {
        return robomindService.getContentList();
    }

    @RequestMapping(value = "displayContent/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void imageContent(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {

        ContentImg contentImg = robomindService.getImageContent(id);

        String filePath = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\contentimg\\" + contentImg.getFileName();
//        C:\Users\Film\Documents\Tamdai\td002\src\main\resources\contentimg\
//        /opt/resource/contentimg/

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

    @RequestMapping(value = "deleteImageContent", method = RequestMethod.DELETE)
    @ResponseBody
    public Content deleteImageContent(@RequestParam("imageId") Long imageId, @RequestParam("ctId") Long ctId) {
        Content content = robomindService.getContent(ctId);
        return robomindService.deleteImageContent(content, imageId);
    }

    @RequestMapping(value = "deleteProfile", method = RequestMethod.DELETE)
    @ResponseBody
    public StudentProfile deleteProfile(@RequestParam("studentId") Long studentId) {
        return robomindService.deleteProfile(studentId);
    }

    @RequestMapping(value = "getStudentBySearch", method = RequestMethod.GET)
    public StudentProfile getStudentBySearch(@RequestParam("username") String username,
                                             @RequestParam("date") String date) {
        return robomindService.getStudentBySearch(username, date);
    }

    @RequestMapping(value = "getSearchGroup", method = RequestMethod.GET)
    public List<Robotic> getSearchGroup(@RequestParam("name") String name) {
        return robomindService.getSearchGroup(name);
    }

}
