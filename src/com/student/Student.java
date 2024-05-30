package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Student {
	private int id;
	private String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//======insert data============================
	public void insertDataIntoDatabase() {
		String host="jdbc:mysql://localhost/my_db_test";
		String user="root";
		String password="";
		String sql= "INSERT INTO test(id,name) VALUES (?,?)";
		try(
				Connection con=DriverManager.getConnection(host,user,password);
				PreparedStatement stm=con.prepareStatement(sql);
				)
		{	
			stm.setInt(1, this.id);
			stm.setString(2, this.name);
			int rowsAffected=stm.executeUpdate();
			if(rowsAffected> 0) {
				System.out.println("Data inserted successiflly!");
				JOptionPane.showMessageDialog(null, 
						"Data inserted successiflly!","After insert",
						JOptionPane.INFORMATION_MESSAGE);
			}else {
				System.out.println("Failed to insert data!");
				JOptionPane.showMessageDialog(null, 
						"Failed to insert data.!","After insert",
						JOptionPane.ERROR_MESSAGE);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//==================View/display================
	public void readwithID(int inputid) {
		// JDBC URL, username, and password of MySQL server
		String host="jdbc:mysql://localhost/my_db_test";
		String user="root";
		String password="";

		// SQL query to select all columns from student where id = ?
		String sql = "SELECT * FROM test WHERE id = ?";

		try (
				// Establish the connection
				Connection connection = DriverManager.getConnection(host, user, password);

				// Create a prepared statement
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				) {
			
			preparedStatement.setInt(1, inputid);

			// Execute the query and get the result set
			ResultSet resultSet = preparedStatement.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				this.setId(resultSet.getInt("id"));
				this.setName(resultSet.getString("name"));
				System.out.println("Your data are,"+this.getId()+" "+this.getName());
				JOptionPane.showMessageDialog(null,"Your data are,"+this.getId()+" "+this.getName(),"Display", JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//==================update==============================
	public void update(int inputid) {
		// JDBC URL, username, and password of MySQL server
		String host="jdbc:mysql://localhost/my_db_test";
		String user="root";
		String password="";

		// SQL query to update data
		String sql = "UPDATE test SET name = ? WHERE id = ?";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(host, user, password);

				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);
				) {
			// Set the new values for the update
			stm.setString(1, this.getName());
			
			stm.setInt(2, inputid);
			// Execute the update
			int rowsAffected = stm.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data updated successfully!");
				JOptionPane.showMessageDialog(null,"Data updated successfully!","After update", JOptionPane.INFORMATION_MESSAGE);

				
			} else {
				System.out.println("Failed to update data. No matching record found.");
				JOptionPane.showMessageDialog(null,"Failed to update data. No matching record found.","After update", JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}   
	}
	public void delete(int inputid) {
		// JDBC URL, username, and password of MySQL server
		String host="jdbc:mysql://localhost/my_db_test";
		String user="root";
		String password="";

	    // SQL query to delete data
	    String sql = "DELETE FROM test WHERE id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        stm.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
				JOptionPane.showMessageDialog(null,"Data deleted successfully!","After delete", JOptionPane.INFORMATION_MESSAGE);

	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
				JOptionPane.showMessageDialog(null,"Failed to delete data. No matching record found","After delete", JOptionPane.INFORMATION_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}



