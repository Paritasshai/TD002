package com.tamdai.model.course.service;

import com.tamdai.model.course.entity.CourseImage;
import com.tamdai.model.security.entity.UserImage;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;

/**
 * Created by Dto on 4/23/2015.
 */
public class CourseImageUtil {
    static CourseImageUtil courseImageUtil = null;
    public static CourseImageUtil getInstance(){
        if (courseImageUtil == null){
            courseImageUtil = new CourseImageUtil();
        }
        return courseImageUtil;
    }
    public static CourseImage courseImage(String resourcePath){
        CourseImage courseImage = new CourseImage();
        ClassLoader classLoader = CourseImageUtil.getInstance().getClass().getClassLoader();

        File file = new File(classLoader.getResource(resourcePath).getFile());

        try {

            courseImage.setFileName(file.getName());
            courseImage.setContentType(Files.probeContentType(file.toPath()));
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;){
                bos.write(buf,0,readNum);
            }
            courseImage.setContent(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseImage;

    }

    public static CourseImage resizeImage(CourseImage image,int width){
        // resize image

        InputStream imageStream = new ByteArrayInputStream(image.getContent());
        try {
            // change the image byte array to Buffer Image
            BufferedImage bufferedImage = ImageIO.read(imageStream);
            //Scale the image using the default api
            BufferedImage scaledImage = Scalr.resize(bufferedImage,300);

            //Convert BufferedImage to byte
            // convert BufferedImage to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(scaledImage, getFileExtension(image.getFileName()), baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            image.setContent(imageInByte);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private static String getFileExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

        if (i > p) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
}
