package com.student_attendance.attendance.attendancesheet;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

//@Controller

public class AttendanceController {

	public AttendanceController(AttendanceService attendanceService) {
		super();
		this.attendanceService = attendanceService;
	}

	private AttendanceService attendanceService;
	
	
	@RequestMapping("list-attendances")
	public String ListallStudents(ModelMap model) {
		String branch=(String)model.get("branch");
		List <Attendance> attedances=attendanceService.findByBranch(branch);
		model.addAttribute("attedances", attedances);
		return "studentlist";
	}
	
	@RequestMapping(value = "add-student",method = RequestMethod.GET)
	public String showNewStudents(ModelMap model) {
		String branch=(String)model.get("branch");
		Attendance attendance=new Attendance(branch, 0,"", LocalDate.now().plusYears(0), true);
		model.put("attendance", attendance);
		return "newstudents";
	}
	
	@RequestMapping(value = "add-student",method = RequestMethod.POST)
	public String AddNewStudents(ModelMap model,@Valid Attendance attendance,BindingResult result) {
		if(result.hasErrors()) {
			return "newstudents";	
		}
		String branch=(String)model.get("branch");
		attendanceService.addstudents(attendance.getName(), branch,LocalDate.now().plusYears(0), true);
		return "redirect:list-attendances";
	}

	
	@RequestMapping("absent-student")
	public String AbsentStudents(@RequestParam int rollno) {
		attendanceService.absentByrollno(rollno);
		return "redirect:list-attendances";
		}
	
	@RequestMapping(value = "update-student",method = RequestMethod.GET)
	public String ShowUpdateStudents(@RequestParam int rollno,ModelMap model) {
		Attendance attendance=attendanceService.findByrollno(rollno);
		model.addAttribute("attendance",attendance);
		return "newstudents";
		}
	
	@RequestMapping(value = "update-student",method = RequestMethod.POST)
	public String UpdateStudents(ModelMap model,@Valid Attendance attendance,BindingResult result) {
		if(result.hasErrors()) {
			return "newstudents";	
		}
		String branch=(String)model.get("branch");
		 attendance.setBranch(branch);
		attendanceService.updatestudents(attendance);
		return "redirect:list-attendances";
	}
	
}
