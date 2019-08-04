package com.student.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.student.Entity.StudentRegiEntity;

//This interface is used to perform CURD operations on STUDENT_REGISTRATION table

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegiEntity, Serializable>{

	
}
