package com.student.Service;

import java.util.List;

import com.student.Model.StudentRegistration;

public interface StudentRegistrationService {

	public boolean createStudentReg(StudentRegistration studentRegistration);
	public List<StudentRegistration> viewStudentData() ;
	
	public String deleteStudentData(int sid);
	
	public StudentRegistration showStudentData(int sid);
	
	public String updateStudentData(StudentRegistration studentRegistration);

}
