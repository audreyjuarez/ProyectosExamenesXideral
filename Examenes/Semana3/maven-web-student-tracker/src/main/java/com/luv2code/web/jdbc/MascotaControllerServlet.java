package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class MascotaControllerServlet
 */
@WebServlet("/MascotaControllerServlet")
public class MascotaControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MascotaDbUtil mascotaDbUtil;
	
	//@Resource(name="jdbc/web_student_tracker") //SE COMENTO PARA HACER USO DE JNDI
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		// create our mascota db util ... and pass in the conn pool / datasource
		try {
			//https://www.digitalocean.com/community/tutorials/tomcat-datasource-jndi-example-java
			//Context ctx = new InitialContext(); //USO DE JNDI
			//dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/javatechie"); //USO DE JNDI
			//System.out.println("Demo con JNDI, Datasource: "+dataSource);
			mascotaDbUtil = new MascotaDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
						
			// if the command is missing, then default to listing mascotas
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listMascotas(request, response);
				break;
				
			case "ADD":
				addMascota(request, response);
				break;
				
			case "LOAD":
				loadMascota(request, response);
				break;
				
			case "UPDATE":
				updateMascota(request, response);
				break;
			
			case "DELETE":
				deleteMascota(request, response);
				break;
				
			default:
				listMascotas(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteMascota(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read Mascota id from form data
		String theMascotaId = request.getParameter("mascotaId");
		
		// delete student from database
		mascotaDbUtil.deleteMascota(theMascotaId);
		
		// send them back to "list mascotas" page
		listMascotas(request, response);
	}

	private void updateMascota(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read mascota info from form data
		int id = Integer.parseInt(request.getParameter("mascotaId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create a new mascota object
		Mascota theMascota = new Mascota(id, firstName, lastName, email);
		
		// perform update on database
		mascotaDbUtil.updateMascota(theMascota);
		
		// send them back to the "list mascotas" page
		listMascotas(request, response);
		
	}

	private void loadMascota(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read mascota id from form data
		String theMascotaId = request.getParameter("mascotaId");
		
		// get student from database (db util)
		Mascota theMascota = mascotaDbUtil.getMascota(theMascotaId);
		
		// place student in the request attribute
		request.setAttribute("THE_MASCOTA", theMascota);
		
		// send to jsp page: update-mascota-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-mascota-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addMascota(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read mascota info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");		
		
		// create a new mascota object
		Mascota theMascota = new Mascota(firstName, lastName, email);
		
		// add the mascota to the database
		mascotaDbUtil.addMascota(theMascota);
				
		// send back to main page (the mascota list)
		listMascotas(request, response);
	}

	private void listMascotas(
			HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get mascotas from db util
		List<Mascota> mascotas = mascotaDbUtil.getMascotas();
		
		for (Mascota s:mascotas) {
			System.out.println(s);
		}
		
		mascotas.add(new Mascota(999, "FirstName","lastName", "email@gmail"));
		// add students to the request
		request.setAttribute("LISTA_MASCOTAS", mascotas);
		
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-mascotas.jsp");
		dispatcher.forward(request, response);
	}

}













