package com.capg.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capg.app.beans.Instructor;
import com.capg.app.dto.InstructorsLocationCountDTO;
import com.capg.app.exception.InstructorNotFoundException;

public class InstructorDaoImply implements InstructorDao {

	Connection con;
	PreparedStatement ps;

	public InstructorDaoImply() {
		con = DatabaseUtil.con; // no need to create Util Class for all users/ one shared class
	}

	@Override
	public boolean insertInstructor(Instructor instructor) throws SQLException {

		boolean isInserted = false;

		int code = instructor.getInstructorCode();
		String name = instructor.getName();
		String email = instructor.getEmail();
		String location = instructor.getTrainerLocation();
		int salary = instructor.getSalary();
		int jobStartYear = instructor.getJobStartYear();

		String query = "insert into Instructor values(?,?,?,?,?,?)";

		ps = con.prepareStatement(query);
		ps.setInt(1, code);
		ps.setString(2, name);
		ps.setInt(3, salary);
		ps.setInt(4, jobStartYear);
		ps.setString(5, email);
		ps.setString(6, location);

		int i = ps.executeUpdate();

		if (i == 1)
			isInserted = true;

		return isInserted;
	}

	@Override
	public List<Instructor> getInstructorByCode(int code) throws InstructorNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sqlQuery = "select * from instructor where instructorcode=?";
		ps = con.prepareStatement(sqlQuery);
		ps.setInt(1, code);
		ResultSet rs = ps.executeQuery();
		List<Instructor> list = new ArrayList<>();
		while (rs.next()) {
			int instructorcode = rs.getInt("instructorcode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String location = rs.getString("trainerlocation");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");

			list.add(new Instructor(instructorcode, name, salary, jobStartYear, email, location));

		}

		return list;
	}

	@Override
	public List<Instructor> getInstructors() throws SQLException {

		String sqlQuery = "select * from instructor";
		ps = con.prepareStatement(sqlQuery);

		ResultSet rs = ps.executeQuery();
		List<Instructor> list = new ArrayList<>();

		while (rs.next()) {
			int code = rs.getInt("instructorCode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String location = rs.getString("location");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");

			list.add(new Instructor(code, name, salary, jobStartYear, email, location));

		}

		return list;
	}

	@Override
	public List<Instructor> getInstructorsByLocation(String location) throws SQLException {
		// TODO Auto-generated method stub
		String sqlQuery = "select * from instructor where trainerlocation=?";
		ps = con.prepareStatement(sqlQuery);
		ps.setString(1, location);
		ResultSet rs = ps.executeQuery();
		List<Instructor> list = new ArrayList<>();
		while (rs.next()) {
			int code = rs.getInt("instructorcode");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String instructorlocation = rs.getString("trainerlocation");
			int salary = rs.getInt("salary");
			int jobStartYear = rs.getInt("jobStartYear");

			list.add(new Instructor(code, name, salary, jobStartYear, email, instructorlocation));

		}

		return list;

	}

	

	@Override
	public List<Instructor> getInstructorsBySalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delteInstructorByCode(int code) throws InstructorNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Instructor updateInstructor(Instructor oldInfoInstructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InstructorsLocationCountDTO> getInstructorsCountByLocation(String Location) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}