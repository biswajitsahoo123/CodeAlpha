package com.student_attendance.attendance.attendancesheet;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("branch")
public class AttendanceControllerJpa {

	public AttendanceControllerJpa(AttendanceRepository attendanceRepository) {
		super();
		//this.attendanceService = attendanceService;
		this.attendanceRepository=attendanceRepository;
	}

	//private AttendanceService attendanceService;
	private AttendanceRepository attendanceRepository;
	
	
	@RequestMapping("list-attendances")
	public String ListallStudents(ModelMap model) {
		String branch=getLoggedinBranch(model);
		List <Attendance> attedances=attendanceRepository.findByBranch(branch);
		model.addAttribute("attedances", attedances);
		return "studentlist";
	}

	
	@RequestMapping(value = "add-student",method = RequestMethod.GET)
	public String showNewStudents(ModelMap model) {
		String branch=getLoggedinBranch(model);
		Attendance attendance=new Attendance(branch, 0,"", LocalDate.now().plusYears(0), true);
		model.put("attendance", attendance);
		return "newstudents";
	}
	
	@RequestMapping(value = "add-student",method = RequestMethod.POST)
	public String AddNewStudents(ModelMap model,@Valid Attendance attendance,BindingResult result) {
		if(result.hasErrors()) {
			return "newstudents";	
		}
		String branch=getLoggedinBranch(model);
		attendance.setBranch(branch);
		attendanceRepository.save(attendance);
		//attendanceService.addstudents(attendance.getName(), branch,attendance.getDate(), attendance.isPresent());
		return "redirect:list-attendances";
	}

	
	@RequestMapping("absent-student")
	public String AbsentStudents(@RequestParam int rollno) {
		attendanceRepository.deleteById(rollno);
		//attendanceService.absentByrollno(rollno);
		return "redirect:list-attendances";
		}
	
	@RequestMapping(value = "update-student",method = RequestMethod.GET)
	public String ShowUpdateStudents(@RequestParam int rollno,ModelMap model) {
		Attendance attendance=attendanceRepository.findById(rollno).get();
		model.addAttribute("attendance",attendance);
		return "newstudents";
		}
	
	@RequestMapping(value = "update-student",method = RequestMethod.POST)
	public String UpdateStudents(ModelMap model,@Valid Attendance attendance,BindingResult result) {
		if(result.hasErrors()) {
			return "newstudents";	
		}
		String branch=getLoggedinBranch(model);
		 attendance.setBranch(branch);
		 attendanceRepository.save(attendance);
		//attendanceService.updatestudents(attendance);
		return "redirect:list-attendances";
	}
private String getLoggedinBranch(ModelMap model) {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
	}
}
