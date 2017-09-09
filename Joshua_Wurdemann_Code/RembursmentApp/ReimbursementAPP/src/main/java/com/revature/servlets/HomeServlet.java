package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dto.DTO;
//import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("AjaxBankInfoServlet -GET");
    Service service = new Service();
    HttpSession session = request.getSession();

    User sessionUser = (User) session.getAttribute("u");

    if(sessionUser != null){

      
        System.out.println("---------------JSON Mapping DTO------------------");
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(sessionUser);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        out.write(json);
      }else{
        response.setStatus(418);
      }
    
  }


}