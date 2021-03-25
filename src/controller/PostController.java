package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;

import util.UtilDB;

/**
 * Servlet implementation class bloggy
 */
@WebServlet("/viewposts")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Bloggy!";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
				"transitional//en\">\n"; //
		out.println(docType + //
				"<html>\n" + //
				"<head><title>" + title + "</title> <head>" + 
						"<link rel=\"stylesheet\" href=\"global.css\">" + 
						"</head>" + //
				"<body>" + //
				"<header><h1>Welcome to Bloggy!</h1></header>");
		out.println("<nav>");
		out.println("<a href=\"/personalproj/search_posts.html\">Search</a> <br>");
		out.println("<a href=/personalproj/create_post.html>Create Post</a> <br>");
		out.println("<a href=/personalproj/viewposts>View Posts</a> <br></nav>\n");
		out.println("<section>");
		for (Post post : UtilDB.listPosts()) {
			out.println("<p> Title: " + post.getTitle() + "<br>");
			out.println("Created At: " + post.getPostCreatedAt() + "<br>");
			out.println("Body: " + post.getPostBody());
			out.println("</p>");
		}
		out.println("</section>");
		out.println("<footer> Copyright @Bloggy! </footer>");
		out.println("</body></html>");
		out.println("	</nav>");

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
