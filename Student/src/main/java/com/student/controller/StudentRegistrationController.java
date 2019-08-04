package com.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.Config.AppConstants;
import com.student.Config.StudentAppProperties;
import com.student.Model.StudentRegistration;
import com.student.Service.StudentRegistrationService;

@Controller
public class StudentRegistrationController {
	
	//2 method required
	//1 method is load form
	//2 method to submit from handling
	
	@Autowired
	private StudentRegistrationService studentRegService;
	
	@Autowired
	private StudentAppProperties studentProps;
	
	@RequestMapping(value = {"/","studentRegistrationCreate"},method = RequestMethod.GET)
	public String loadStudentRegistration(Model model) {
		StudentRegistration reg = new StudentRegistration();
		model.addAttribute(AppConstants.STUDENT_REG_MODEL, reg);
		return AppConstants.STUDENT_REG_CREATION_VIEW; //logical view name
	}

	// This method is used account for user
	@RequestMapping(value = "/studentRegistrationCreate", method = RequestMethod.POST)
	public String createStudentRegistration(@ModelAttribute("studentRegistrationModel") StudentRegistration studentRegistration,Model model) {
		
	boolean isSaved = studentRegService.createStudentReg(studentRegistration);
	if(isSaved) {
		//sucess msg
	}else {
		//failure msg
	}
		return AppConstants.STUDENT_REG_CREATION_VIEW; //logical view name	
	}
	
	// This method is used to show the Student Data
	@RequestMapping(value = {"viewStudentData"}, method = RequestMethod.GET)
	public String viewUsersAccount(Model model) {
		List<StudentRegistration> listStudents = studentRegService.viewStudentData();
		
		/*listModels.forEach(entity -> {
			System.out.println(entity);
		});*/
		//listModels.forEach(System.out::println);
		
		model.addAttribute("StudentRegistrationModel", listStudents);
		return "ViewDetails";
	}
	
	
	@RequestMapping(value = "/deleteAccount")
	public String deleteStudentData(@RequestParam("id") String sid) {
		String result = studentRegService.deleteStudentData(Integer.parseInt(sid));
		return "redirect:/viewStudentData";
	}
	
	@RequestMapping(value = "/editAccount")
	public String showStudentData(@RequestParam("id") String sid, Model model) {
		StudentRegistration stuModel = studentRegService.showStudentData(Integer.parseInt(sid));
		model.addAttribute("studentRegistrationModel", stuModel);
		return "UpdateStudentData";
	}
	
	@RequestMapping(value = "/updateStudent")
	public String showStudentData(@ModelAttribute("studentRegistrationModel") StudentRegistration studentRegistration) {
		String result = studentRegService.updateStudentData(studentRegistration);
		
		return "redirect:/viewStudentData";
	}
	
	
	
	
	
	
	

	

}
