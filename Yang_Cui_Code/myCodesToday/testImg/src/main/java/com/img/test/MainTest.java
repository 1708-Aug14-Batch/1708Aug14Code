package com.img.test;

import com.img.bean.Img;
import com.img.dao.ImgDAO;

public class MainTest {
	public static void main(String[] args){
		ImgDAO imgdao=new ImgDAO();
		//Img img=new Img("C:/Users/1Z4XS/Desktop/htai/junkj","This is a test image");
		Img img=new Img();
		img.setDescription("this is a test image");
		img.setLink("C:/Users/1Z4XS/Desktop/htai/junkj/vmat0");
		imgdao.addImg(img);
	}
}
