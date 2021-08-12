package com.edutecno.servlet.sesion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("enlaces.html").include(request, response);

		if (password.equals("admin123")) {
			out.print("Login exitoso !");
			out.print("<br>Bienvenido, " + name);

			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("nombre", name);
		} else {
			out.print("Username o password incorrecto !");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();  
	}

}
