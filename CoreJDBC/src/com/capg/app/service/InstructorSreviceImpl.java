package com.capg.app.service;

import java.sql.SQLException;
import java.util.List;

import com.capg.app.beans.Instructor;
import com.capg.app.dao.InstructorDao;
import com.capg.app.dao.InstructorDaoImply;
import com.capg.app.dto.InstructorsLocationCountDTO;
import com.capg.app.exception.InstructorNotFoundException;

public class InstructorSreviceImpl implements InstructorService {

	InstructorDao dao;
	
	public InstructorSreviceImpl() {
		dao = new InstructorDaoImply();
	}

	@Override
	public boolean insertInstructor(Instructor instructor)throws SQLException {
		
		boolean isQueryExecuted = false;
		
		// --- call business Server side validations
		
		// call Security layer 
		
		isQueryExecuted = dao.insertInstructor(instructor);
		
		// call Logger task
		
		return isQueryExecuted;
	}

	@Override
	public  List<Instructor> getInstructorByCode(int code) throws InstructorNotFoundException,SQLException {
		// TODO Auto-generated method stub
		return dao.getInstructorByCode(code);
	}

	@Override
	public List<Instructor> getInstructors() throws SQLException{
		
		return dao.getInstructors();
	}

	@Override
	public List<Instructor> getInstructorsByLocation(String Location) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getInstructorsByLocation(Location);
	}

	@Override
	public List<InstructorsLocationCountDTO> getInstructorsCountByLocation(String Location) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getInstructorsCountByLocation(Location);
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

}
