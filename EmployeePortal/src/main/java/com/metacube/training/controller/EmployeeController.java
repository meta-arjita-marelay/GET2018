package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeServiceImplement;
import com.metacube.training.service.ServiceInterface;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	ServiceInterface<Employee> employeeService;

	/**
	 * method to redirect to dashboard
	 * 
	 * @return destination path
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(@ModelAttribute("email") String email) {
		return "employee/dashboard?email=" + email;
	}

	/**
	 * method to move to login page
	 * 
	 * @return destination path
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "employee/login";
	}

	/**
	 * method for validating login by email
	 * 
	 * @param email
	 *            entered by user
	 * @param password
	 *            entered by user
	 * @param model
	 * @return destination path
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, Model model) {
		String view;
		if (((EmployeeServiceImplement) employeeService).validateLogin(email,
				password)) {
			view = "employee/dashboard";
			model.addAttribute("email", email);
		} else {
			view = "employee/login";
			model.addAttribute("error", "error");
		}
		return view;
	}

	/**
	 * method for redirecting dashboard to show profile page
	 * 
	 * @param model
	 * @param email
	 *            of employee whose profile is to be shown
	 * @return destination path
	 */
	@RequestMapping(value = "/showProfile", method = RequestMethod.GET)
	public String showProfile(Model model, @RequestParam("email") String email) {
		model.addAttribute("employee",
				((EmployeeServiceImplement) employeeService)
						.getInfoByEmail(email));
		return "employee/profile";
	}

	/**
	 * method to update the profile
	 * 
	 * @param employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String showProfile(@ModelAttribute("employee") Employee employee,
			Model model) {
		employeeService.updateInfo(employee);
		model.addAttribute("email", employee.getEmailId());
		return "employee/dashboard";
	}
}
