package com.student.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Entity.StudentRegiEntity;
import com.student.Model.StudentRegistration;
import com.student.Repository.StudentRegistrationRepository;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
	@Autowired
	private StudentRegistrationRepository studentRegistrationRepo;
	
	@Override
	public boolean createStudentReg(StudentRegistration studentRegistration) {
		
		boolean isSaved =false;
		
		//Copying Properties
		StudentRegiEntity entity = new StudentRegiEntity();
		BeanUtils.copyProperties(studentRegistration, entity);
		
		//calling persistence layer method
		entity=studentRegistrationRepo.save(entity);
		
		if(entity.getStudentregId()>0) {
			isSaved = true;
		}
		return isSaved;
	}
	

	/**
	 * This method is used to return the users DEtails
	 */
	@Override
	public List<StudentRegistration> viewStudentData() {
		List<StudentRegiEntity> entities = studentRegistrationRepo.findAll();
		List<StudentRegistration> models = new ArrayList<StudentRegistration>();
		
		entities.forEach(entity -> {
			StudentRegistration model = new StudentRegistration();
			BeanUtils.copyProperties(entity, model);
			models.add(model);
		});
		return models;
	}


	@Override
	public String deleteStudentData(int sid) {
		try {
			studentRegistrationRepo.deleteById(sid);
			return "Delete Succesfully";
		}catch(Exception e) {
			return "Some Problem Occured";
		}
	}


	@Override
	public StudentRegistration showStudentData(int sid) {
		StudentRegiEntity entity = studentRegistrationRepo.findById(sid).get();
		StudentRegistration model = new StudentRegistration();
		BeanUtils.copyProperties(entity, model);
		return model;
	}


	@Override
	public String updateStudentData(StudentRegistration studentRegistration) {
		StudentRegiEntity entity = studentRegistrationRepo.findById(studentRegistration.getStudentregId()).get();
		
		BeanUtils.copyProperties(studentRegistration, entity);
		
		entity = studentRegistrationRepo.save(entity);
		if(entity != null)
			return "Student Updated Succesfully";
		return "Some Poblem Occured";
	}

}
