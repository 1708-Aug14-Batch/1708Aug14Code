package com.revature.andy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/loadSubmitReim")
@WebServlet(name="loadSubmitReim", urlPatterns="/loadSubmitReim", loadOnStartup=8)
public class SubmitReimServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println();
		req.getRequestDispatcher("submitReim.html").forward(req, resp);
	}
}
