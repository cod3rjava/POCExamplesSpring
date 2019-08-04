package com.student.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "STUDENT_REGISTRATION_FORM")

@Data
public class StudentRegiEntity {

	@Id
	@SequenceGenerator(sequenceName = "student_reg_seq", initialValue = 1, allocationSize = 1, name = "student_reg_seq_gen")
	@GeneratedValue(generator = "student_reg_seq_gen")

	@Column(name = "STUDENT_REG_ID")
	private Integer studentregId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "USER_DOB")
	private String dob;

	@Column(name = "USER_GENDER")
	private String gender;
	@Column(name = "ADDRESS")
	private String address;
}
