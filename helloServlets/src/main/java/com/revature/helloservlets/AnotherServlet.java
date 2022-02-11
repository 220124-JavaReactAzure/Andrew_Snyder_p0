package com.revature.helloservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
value ="/anotherOne",
initParams = {@WebInitParam(name = "anotherParam", value = "just to show its different")}
)

public class AnotherServlet extends HttpServlet {
	

 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 resp.getWriter().write("<h1>" + this.getServletConfig().getInitParameter("anotherParam") + "</h1>");
	resp.getWriter().write("<h1>another one</h1>");
	req.getRequestDispatcher("/test").forward(req,  resp);
}

}
