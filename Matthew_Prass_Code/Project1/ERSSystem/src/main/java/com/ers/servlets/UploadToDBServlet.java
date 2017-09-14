package com.ers.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ers.dao.DaoImpl;
import com.ers.util.ConnectionFactory;

@WebServlet("/uploadToDB")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/uploadToDB.jsp");
	 
	        dispatcher.forward(request, response);
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	       
	            DaoImpl dao = new DaoImpl();
	            InputStream is = request.getInputStream();
	            try {
					dao.writeToDB(is);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	            response.sendRedirect(request.getContextPath() + "/uploadToDBResults");
	    }
	 
	 
	 
	 
	    private void closeQuietly(Connection conn) {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	        }
	    }
}