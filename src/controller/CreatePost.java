package controller;

/**
 * @file SimpleFormInsert.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import util.UtilDB;

@WebServlet("/createpost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreatePost() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		UtilDB.createPost(title, body);
		PrintWriter out = response.getWriter();
		response.sendRedirect("../personalproj/viewposts");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
