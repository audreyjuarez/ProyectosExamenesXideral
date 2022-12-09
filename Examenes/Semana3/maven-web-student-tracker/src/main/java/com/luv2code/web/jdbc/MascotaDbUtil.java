package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class MascotaDbUtil {

	private DataSource dataSource;

	public MascotaDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Mascota> getMascotas() throws Exception {
		
		List<Mascota> mascotas = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from mascota order by last_name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// create new mascota object
				Mascota tempMascota = new Mascota(id, firstName, lastName, email);
				
				// add it to the list of mascotas
				mascotas.add(tempMascota);				
			}
			
			return mascotas;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addMascota(Mascota theMascota) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into mascota "
					   + "(first_name, last_name, email) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the mascota
			myStmt.setString(1, theMascota.getFirstName());
			myStmt.setString(2, theMascota.getLastName());
			myStmt.setString(3, theMascota.getEmail());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Mascota getMascota(String theMascotaId) throws Exception {

		Mascota theMascota = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int mascotaId;
		
		try {
			// convert mascota id to int
			mascotaId = Integer.parseInt(theMascotaId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected mascota
			String sql = "select * from mascota where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, mascotaId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// use the mascotaId during construction
				theMascota = new Mascota(mascotaId, firstName, lastName, email);
			}
			else {
				throw new Exception("Could not find mascota id: " + mascotaId);
			}				
			
			return theMascota;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateMascota(Mascota theMascota) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update mascota "
						+ "set first_name=?, last_name=?, email=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theMascota.getFirstName());
			myStmt.setString(2, theMascota.getLastName());
			myStmt.setString(3, theMascota.getEmail());
			myStmt.setInt(4, theMascota.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteMascota(String theMascotaId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert mascota id to int
			int mascotaId = Integer.parseInt(theMascotaId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete mascota
			String sql = "delete from mascota where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, mascotaId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















