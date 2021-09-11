package com.person.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.person.dao.PersonDao;
import com.person.model.Person;

/**
 * Servlet implementation class PersonController
 */
@WebServlet("/PersonController")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonDao dao = new PersonDao();

	public PersonController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("create")) {
			createPerson(request, response);
		} else if (action.equals("update")) {
			updatePerson(request, response);
		} else if (action.equals("read")) {
			readPerson(request, response);
		} else if (action.equals("delete")) {
			deletePerson(request, response);
		}

	}

	private void createPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		Cookie personCookie = new Cookie("personNameCookieCreate",name);
		response.addCookie(personCookie);
		
		String email = request.getParameter("email");

		Person person = new Person();
		person.setName(name);
		person.setEmail(email);

		dao.save(person);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Person Created</h1>");
		out.print("<br/><a href='/Person'>Home</a>");
	}

	public void updatePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cookie personCookie = new Cookie("personIdCookieUpdate",String.valueOf(id));
		response.addCookie(personCookie);
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setEmail(email);

		dao.update(person);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Person Updated</h1>");
		out.print("<br/><a href='/Person'>Home</a>");
	}

	public void readPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cookie personCookie = new Cookie("personIdCookieRead",String.valueOf(id));
		response.addCookie(personCookie);
		Person person = dao.findPersonById(id);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(person);
		out.print("<h1>Person Details</h1>");
		out.print("<br/><a href='/Person'>Home</a>");
	}

	public void deletePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cookie personCookie = new Cookie("personIdCookieDelete",String.valueOf(id));
		response.addCookie(personCookie);
		
		Person person = new Person();
		person.setId(id);
		
		dao.delete(person);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Person Deleted</h1>");
		out.print("<br/><a href='/Person'>Home</a>");
	}
}
