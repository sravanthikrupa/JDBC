package com.capg.app.ui;


import java.util.List;
import java.util.Scanner;

import com.capg.app.beans.Instructor;
import com.capg.app.dto.InstructorsLocationCountDTO;
import com.capg.app.service.InstructorService;
import com.capg.app.service.InstructorSreviceImpl;
public class MainClass {

	InstructorService service;

	public MainClass() {
		service = new InstructorSreviceImpl();
	}

	public static void main(String[] args) {

		MainClass obj = new MainClass();

		while (true) {

			System.out.println("1. Insert");
			System.out.println("2. Show All");
			System.out.println("3. Show by code");
			System.out.println("4.Show by location");
			System.out.println("5. Show counts by location");			
			System.out.println("0. EXIT");
			int opt = new Scanner(System.in).nextInt();

			switch (opt) {
			case 0:
				System.exit(0);
				break;
				
			case 1:
				obj.insertInstructorDetailsFromUser();
				break;

			case 2:
				obj.readInstructorDetails();
				break;
				
			case 3:
				obj.readInstructorDetailsByCode();
				break;

			case 4:
				obj.readInstructorDetailsByLocation();
				break;

			case 5:
				obj.readInstructorCountByLocation();
				break;
			default:
				break;
			}

		}

	}// end main

	private void readInstructorCountByLocation() {
		// TODO Auto-generated method stub
		try {
			List<InstructorsLocationCountDTO> list = service.getInstructorsCountByLocation("B");
			list.stream().forEach(instructor -> displayInstructor(instructor));
		} 
		catch (Exception e) {
			// TODO: handle exception
			showErr(e);
		}

		
	}

	private void  displayInstructor(InstructorsLocationCountDTO instructor) {
		// TODO Auto-generated method stub
		System.out.println(instructor);
		System.out.println("-------------------------------------------------------");
	}

	public void insertInstructorDetailsFromUser() {

		// ... write code to read data hope
		Instructor instructor = new Instructor(110, "u", 7000, 2000, "xw@x.com", "B");
		try {
			boolean result = service.insertInstructor(instructor);

			if (result)
				System.out.println(" Instructor Added");
			else
				System.out.println("Contact Admin ...");
		} catch (Exception e) {
			showErr(e);
		}

	}

	public void readInstructorDetails() {

		try {
			List<Instructor> list = service.getInstructors();

			list.stream().forEach(instructor -> displayInstructor(instructor));
		} catch (Exception e) {
			showErr(e);
		}

	}

	public void readInstructorDetailsByCode() {
		// TODO Auto-generated method stub
		try {
			List<Instructor> list = service.getInstructorByCode(731);
			list.stream().forEach(instructor -> displayInstructor(instructor));
		} catch (Exception e) {
			// TODO: handle exception
			showErr(e);
		}

	}

	

	public void readInstructorDetailsByLocation() {
		// TODO Auto-generated method stub
		try {
			List<Instructor> list = service.getInstructorsByLocation("B");
			list.stream().forEach(instructor -> displayInstructor(instructor));
		} 
		catch (Exception e) {
			// TODO: handle exception
			showErr(e);
		}

	}

	public void displayInstructor(Instructor instructor) {

		System.out.println(instructor);
		System.out.println("-------------------------------------------------------");
	}

	public void showErr(Exception e) {
		System.out.println("====>> " + e);
	}
}
