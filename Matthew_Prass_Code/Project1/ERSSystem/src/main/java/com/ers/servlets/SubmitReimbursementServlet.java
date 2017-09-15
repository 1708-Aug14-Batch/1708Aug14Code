package com.ers.servlets;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

@WebServlet("/SubmitReimbursement")
public class SubmitReimbursementServlet extends HttpServlet{
	private static String bucketName = "warwarneverchanges";
	private static String key = "2";
	private static String uploadFileName;
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	
		Map<String,String[]> myMap = req.getParameterMap();
		Set<String> keys = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];
		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		HttpSession session = req.getSession();
		
		for(String str: list) {
			System.out.println(str);
		}

		Employee seshuser = (Employee)session.getAttribute("employee");
		
		
		String descript = list.get(0);
		double amount = Double.parseDouble(list.get(1));
		String file = list.get(2);
		uploadFileName = file;
		AmazonS3 s3 = new AmazonS3Client(new ProfileCredentialsProvider());
		try {
            System.out.println("Uploading a new object to S3 from a file\n");
            File f = new File(uploadFileName);
            s3.putObject(new PutObjectRequest(
            		                 bucketName, key, f));

           
         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
		
		Service s= new Service();
		s.submitReimbursement(seshuser, descript, amount, "https://s3.amazonaws.com/"+bucketName+"/"+key);
		
	}



}
