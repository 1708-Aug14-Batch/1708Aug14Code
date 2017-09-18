package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.Service;
@WebServlet("/editUser")
public class EditUserInfoServlet extends HttpServlet{


  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{

    System.out.println("posting updated user info to db");

    HttpSession session = req.getSession(false);
    if(session != null){
      System.out.println("session is valid");

      Service userService = new Service();

      User user = (User) session.getAttribute("user");

      User someUser = new User();
      someUser.setUserId(user.getUserId());
      someUser.setFirstName(req.getParameter("firstname"));
      String fn =   someUser.getFirstName();//test

      someUser.setLastNAme(req.getParameter("lastname"));
      String l =  someUser.getLastNAme();//test
     
      someUser.setEmail(req.getParameter("email"));
      String em =   someUser.getEmail();//test
      
      someUser.setPassword(req.getParameter("password"));
      String pass =   someUser.getPassword();//test
      
      System.out.println(fn +"" + l + " " + em + "" + pass);
      
      userService.editUser(someUser);
      session.setAttribute("user", userService);

      req.getRequestDispatcher("app.html").forward(req, res);
    }
  }
}