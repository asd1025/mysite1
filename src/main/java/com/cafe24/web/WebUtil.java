package com.cafe24.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String location) {
		try {
			response.sendRedirect(location);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static void forward(HttpServletRequest request,HttpServletResponse response,String location ) {
		  RequestDispatcher rd= request.getRequestDispatcher(location);
		  try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
}
