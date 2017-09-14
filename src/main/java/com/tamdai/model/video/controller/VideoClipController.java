package com.tamdai.model.video.controller;

import com.tamdai.model.video.entity.Course;
import com.tamdai.model.video.entity.VideoClip;
import com.tamdai.model.video.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Film on 25/9/2559.
 */

@CrossOrigin
@Controller
@RequestMapping("/")
public class VideoClipController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "add/video", method = RequestMethod.POST)

    public @ResponseBody
    String handleFileUpload(HttpServletRequest request,
                            HttpServletResponse response,
                            @RequestParam("file") MultipartFile file) throws IOException {
        MultipartHttpServletRequest mRequest;

        if (!file.isEmpty()) {
            try {
                mRequest = (MultipartHttpServletRequest) request;
                Iterator<String> itr = mRequest.getFileNames();
                while (itr.hasNext()) {
                    MultipartFile multipartFile = mRequest.getFile(itr.next());

//                    VideoClip video = new VideoClip();
//                    video.setFileName(multipartFile.getOriginalFilename());
//                    video.setContentType(multipartFile.getContentType());
//                    video.setCreated(Calendar.getInstance().getTime());

                    Course video = new Course();
                    video.setName(multipartFile.getOriginalFilename());
                    video.setDescription(multipartFile.getContentType());
                    video.setPath(multipartFile.getOriginalFilename());
                    courseService.addVideo(video);

//                    ServletContext context = request.getServletContext();
//                    String path = context.getRealPath("Save file in folder");
//                    System.out.println(path);

                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Film\\Documents\\video\\" + multipartFile.getOriginalFilename())));
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

    @RequestMapping(value = "add/videoClipObject", method = RequestMethod.POST)
    public VideoClip addVideoClipObject(@RequestBody VideoClip videoClip, BindingResult bindingResult) {
        return courseService.addVideoClipObject(videoClip);
    }

    @RequestMapping(value = "get/listVideo", method = RequestMethod.GET)
    public List<VideoClip> getVideoClipList() {
        return courseService.getVideoClipList();
    }

//    @RequestMapping(value = "add/video", method = RequestMethod.POST)
//    @ResponseBody
//    public Course addVideoClip(HttpServletRequest request,
//                              HttpServletResponse response, @RequestParam("videoId") Long videoId) throws IOException {
//        MultipartHttpServletRequest mRequest;
//        Course video = courseService.getVideo(videoId);
//
//        try {
//            mRequest = (MultipartHttpServletRequest) request;
//            Iterator<String> itr = mRequest.getFileNames();
//            while (itr.hasNext()) {
//                MultipartFile multipartFile = mRequest.getFile(itr.next());
//
//                VideoClip videoClip = new VideoClip();
//                videoClip.setFileName(multipartFile.getOriginalFilename());
//                videoClip.setContentType(multipartFile.getContentType());
//                videoClip.setCreated(Calendar.getInstance().getTime());
//                Course video1 = courseService.addVideoClip(video, videoClip);
//                for (VideoClip v : video1.getVideoClips()) {
//
//
//                    File outputFile = new File("C:\\Users\\Film\\Documents\\video\\" + multipartFile.getOriginalFilename());
//                    FileOutputStream outputStream = new FileOutputStream(outputFile);
//                    outputStream.write(multipartFile.getBytes());
//                }
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return video;
//    }
}