/**
 * 
 */
package com.bridgelabz.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.login.model.User;

/**
 * purpose
 * @author Chaithra-Shenoy
 * Date
 * 
 */
public class UserDAOImpl implements UserDAO{
	/* (non-Javadoc)
	 * @see com.bridgelabz.login.dao.UserDAO#getConnection()
	 */
	@Override
	public Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo?useSSL=false", "root",
					"admin");
		} catch (SQLException e) {
			System.out.println("Error in establishing connection");
			e.printStackTrace();
		}
		return connection;
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.login.dao.UserDAO#closeConnection(java.sql.ResultSet, java.sql.PreparedStatement, java.sql.Connection)
	 */
	@Override
	public void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public User getUserByUserName(String uname) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		String query = "select * from login where userName=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, uname);
		ResultSet resultSet = preparedStatement.executeQuery();
		User user = null;
		if (resultSet.next()) {
			user = new User();
			user.setUserName(resultSet.getString(2));
			user.setPassword(resultSet.getString(3));
		}
		closeConnection(resultSet, preparedStatement, connection);
		return user;
	}

	@Override
	public boolean saveUser(User user) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		ResultSet resultSet = null;
		String query = "insert into login values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, 0);
		preparedStatement.setString(2, user.getUserName());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(5, user.getFirstName());
		preparedStatement.setString(6, user.getLastName());
		preparedStatement.setString(7, user.getMobNumber());
		preparedStatement.setString(4, user.getEmail());
		int count = preparedStatement.executeUpdate();
		closeConnection(resultSet, preparedStatement, connection);
		if (count == 7) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getUserByUserEmail(String email) throws SQLException, ClassNotFoundException {
		System.out.println(email);
		Connection connection = getConnection();
		boolean found = false;
		String query = "select * from login where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			found = true;
		}
		closeConnection(resultSet, preparedStatement, connection);
		System.out.println(found);
		return found;
	}

}
