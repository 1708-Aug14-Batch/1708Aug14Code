package com.main;

import java.io.File;
import java.util.Random;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.beans.Image;
import com.dao.DaoImpl;

public class MainTest {

	private static String bucketName = "project2bucketforrevatureportfoliostuff";
	
	public static void main(String[] args) {
		
		Random r = new Random();
		String key = r.nextInt(1000000)+1+"";
		AmazonS3 s3 = new AmazonS3Client(new ProfileCredentialsProvider());
		try {
			File f = new File("src/main/webapp/image.jpg");
			s3.putObject(new PutObjectRequest(bucketName, key, f));
		}
		catch(AmazonServiceException ase) {
			ase.printStackTrace();
		}
		catch(AmazonClientException ace) {
			ace.printStackTrace();
		}
		
		DaoImpl dao = new DaoImpl();
		Image img = new Image();
		img.setFilePath("https://s3.us-east-2.amazonaws.com/"+bucketName+"/"+key);
		dao.addImage(img);
		
	}

}
