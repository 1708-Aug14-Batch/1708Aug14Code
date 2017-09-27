package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.beans.Image;
import com.dao.DaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/UploadImage")
public class UploadFileServlet extends HttpServlet{
	
	//private static String bucketName = "project2bucketforrevatureportfoliostuff";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> myMap = request.getParameterMap();
		Set<String> txObject = myMap.keySet();
		ObjectMapper jackson = new ObjectMapper();
		Object obj = txObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
		//System.out.println(tx.get(0));
		
		Random r = new Random();
		String key = r.nextInt(1000000)+1+"";
		AmazonS3 s3 = new AmazonS3Client(new ProfileCredentialsProvider());
		try {
			//ServletContext context = getServletContext();
			//File f = new File(context.getRealPath("image.jpg")); //get file object here
			File f = new File("Put stuff here");
			String bucketName = "project2bucketforrevatureportfoliostuff";
			s3.putObject(new PutObjectRequest(bucketName, key, f));
		}
		catch(AmazonServiceException ase) {
			ase.printStackTrace();
		}
		catch(AmazonClientException ace) {
			ace.printStackTrace();
		}
//		
		DaoImpl dao = new DaoImpl();
		Image img = new Image();
		img.setFilePath(tx.get(0));
		dao.addImage(img);
		
		PrintWriter p = response.getWriter();
		p.write(img.getFilePath());
	}
	
}