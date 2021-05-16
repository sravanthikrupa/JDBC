package com.capg.app.service;

import java.sql.SQLException;
import java.util.List;

import com.capg.app.beans.Instructor;
import com.capg.app.dto.InstructorsLocationCountDTO;
import com.capg.app.exception.InstructorNotFoundException;

public interface InstructorService {

	public boolean insertInstructor(Instructor instructor)throws SQLException;
	public List<Instructor> getInstructorByCode(int code)throws InstructorNotFoundException, SQLException;  // 1
	public List<Instructor> getInstructors()throws SQLException;
	
	
	public List<Instructor> getInstructorsByLocation(String location) throws SQLException;   // 2
	public List<InstructorsLocationCountDTO> getInstructorsCountByLocation(String Location) throws SQLException; // group by
	public List<Instructor> getInstructorsBySalary(); // order by ASC 
	
	
	public boolean delteInstructorByCode(int code)throws InstructorNotFoundException; // 3
	public Instructor updateInstructor(Instructor oldInfoInstructor);
	
	
}