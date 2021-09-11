package com.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.person.model.Person;
import com.person.util.ConnectionUtil;

public class PersonDao {
	public void save(Person person) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("insert into person(name,email) values(?,?)");
			prepareStatement.setString(1, person.getName());
			prepareStatement.setString(2, person.getEmail());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Person person) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("update person set name = ?,email = ?  where id = ?");
			prepareStatement.setString(1, person.getName());
			prepareStatement.setString(2, person.getEmail());
			prepareStatement.setInt(3, person.getId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(Person person) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("delete from person where id=?");
			prepareStatement.setInt(1, person.id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Person findPersonById(int id) {
		Connection connection = ConnectionUtil.getConnection();
		Person person = new Person();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from person where id=?");
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				person.setId(resultSet.getInt(1));
				person.setName(resultSet.getString(2));
				person.setEmail(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
}
