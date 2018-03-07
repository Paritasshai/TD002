package com.tamdai.model.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.jni.Socket;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Film on 24/9/2559.
 */

@CrossOrigin
@RestController
@RequestMapping("/")

public class TestPerformance {

	   @RequestMapping(value = "testPerformance", method = RequestMethod.GET)
	    public String testPerformance(byte[] requestData, Socket connection) throws IOException {
	        System.out.println("============= Check Performance =============");
//	        System.out.println("I do what I do best, i.e sleep.");
//            try {
//                    Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                    System.out.println("How dare you to wake me up?");
//            }
//            System.out.println("Done with sleeping.");
	        
	        // =================================================================
//	        long startTime = System.nanoTime();
//	        //  ... methodToTime();
//	        long endTime = System.nanoTime();
//	        long duration = (endTime - startTime);
//	        long seconds = (duration / 1000) % 60;
//	        // formatedSeconds = (0.xy seconds)
//	        String formatedSeconds = String.format("(0.%d seconds)", seconds);
//	        System.out.println("formatedSeconds = "+ formatedSeconds);
	        // i.e actual formatedSeconds = (0.52 seconds)
	        
	        long startTime = System.currentTimeMillis();
	
	        String url = "http://www.tamdai.net/tamdaiapi/getCourseList";
	        
	        HttpURLConnection con = null;
			try {
	            URL myurl = new URL(url);
	            con = (HttpURLConnection) myurl.openConnection();

	            con.setRequestMethod("GET");

	            StringBuilder content;

	            try (BufferedReader in = new BufferedReader(
	                    new InputStreamReader(con.getInputStream()))) {

	                String line;
	                content = new StringBuilder();

	                while ((line = in.readLine()) != null) {
	                    content.append(line);
	                    content.append(System.lineSeparator());
	                }
	            }

	            // System.out.println(content.toString());

	        } finally {
	            con.disconnect();
	        }
	        
	        long elapsedTime = System.currentTimeMillis() - startTime;
	        
	        double seconds =  elapsedTime / 1000.0;
	        
	        System.out.println("Total elapsed http request/response time in seconds: " + seconds);
	        
	        return "Total elapsed http request/response url 'http://www.tamdai.net/tamdaiapi/getCourseList' time in seconds: " + seconds ;
	        //===================================================================
//	     // open your connection
//	        long start = System.currentTimeMillis();
//	        // send request, wait for response (the simple socket calls are all blocking)
//	        long end = System.currentTimeMillis();
//	        System.out.println("Round trip response time = " + (end-start) + " millis");
	}

}