//package com.tamdai.model.video.controller;
//
//import com.tamdai.model.course.entity.Course;
//import com.tamdai.model.course.entity.VideoClip;
//import com.tamdai.model.course.repository.VideoClipRepository;
//import com.tamdai.model.course.service.CourseService;
//import org.apache.commons.io.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.util.Locale;
//
///**
// * Created by Film on 25/9/2559.
// */
//
//@CrossOrigin
//@Controller
//@RequestMapping("/")
//public class VideoClipController {
//
//    @Autowired
//    CourseService courseService;
//
//
//    @Autowired
//    VideoClipRepository videoClipRepository;
//
//    @RequestMapping(value = "add/course", method = RequestMethod.POST)
//
//    public @ResponseBody
//    String handleFileUpload(HttpServletRequest request,
//                            HttpServletResponse response,
//                            @RequestParam("id") Long id,
//                            @RequestParam("file") MultipartFile file) throws IOException {
//        MultipartHttpServletRequest mRequest;
//        Course course = courseService.getCourseId(id);
//
//        if (!file.isEmpty()) {
//            try {
//                mRequest = (MultipartHttpServletRequest) request;
//                Iterator<String> itr = mRequest.getFileNames();
//                while (itr.hasNext()) {
//                    MultipartFile multipartFile = mRequest.getFile(itr.next());
//
//                    String destination = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\course\\" + multipartFile.getOriginalFilename();
//                    course.setPath(destination);
//                    courseService.updateCourse(course);
//
//                    VideoClip course = new VideoClip();
//                    course.setFileName(multipartFile.getOriginalFilename());
//                    course.setContentType(multipartFile.getContentType());
//                    course.setCreated(Calendar.getInstance().getTime());
//                    course.setPath(destination);
//                    courseService.saveVideo(course, course);
//
//                    //Course course = new Course();
//                    //course.setName(multipartFile.getOriginalFilename());
//                    //course.setDescription(multipartFile.getContentType());
//                    //course.setPath(multipartFile.getOriginalFilename());
//                    //courseService.addVideo(course);
//
////                    ServletContext context = request.getServletContext();
////                    String path = context.getRealPath("Save file in folder");
////                    System.out.println(path);
//
//                    byte[] bytes = file.getBytes();
//                    BufferedOutputStream stream =
//                            new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\course\\" + multipartFile.getOriginalFilename())));
//                    stream.write(bytes);
//                    stream.close();
//                }
//                return "You successfully uploaded ";
//            } catch (Exception e) {
//                return "You failed to upload " + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + " because the file was empty.";
//        }
//    }
//
//    @RequestMapping(value = "/playVideo/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public void home(@PathVariable("id") Long id, Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        /// logger.info("Welcome home! The client locale is {}.", locale);
//
//        VideoClip videoClip = videoClipRepository.findOne(id);
//
//        String filePath = "C:\\Users\\Film\\Documents\\Tamdai\\td002\\src\\main\\resources\\course\\" + videoClip.getFileName();
//
//        int fileSize = (int) new File(filePath).length();
//        response.setContentLength(fileSize);
//        response.setContentType("course");
//
//        FileInputStream inputStream = new FileInputStream(filePath);
//        ServletOutputStream outputStream = response.getOutputStream();
//        int value = IOUtils.copy(inputStream, outputStream);
//        System.out.println("File Size :: " + fileSize);
//        System.out.println("Copied Bytes :: " + value);
//        IOUtils.closeQuietly(inputStream);
//        IOUtils.closeQuietly(outputStream);
//    }
//
//}