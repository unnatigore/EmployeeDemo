package com.cg.app.employee.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.cg.app.employee.pojo.Employee;
import com.cg.app.employee.service.EmployeeService;
import com.cg.app.employee.service.EmployeeServiceImpl;
import com.cg.app.employee.validator.EmployeeValidator;

@Controller
@RequestMapping("/employee")
@SessionAttributes("employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;
	
	@Autowired
	private EmployeeValidator validator;
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)	
	public String askDetails(Map map) {
		map.put("employee", new Employee());
		return "input";

	}

	/*
	 * @RequestMapping("/save") public String saveDetails(@RequestParam("empId") int empId, 
	 * @RequestParam("empName") String empName, @RequestParam("salary") double salary, Model model) { Employee employee = new
	 * Employee(empId, empName, salary); model.addAttribute("employee", employee);
	 * return "display"; }
	 */

	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * save(@ModelAttribute("employee") Employee employee, BindingResult result) {
	 * if (result.hasErrors()) { return "input"; } return "display"; }
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employee") Employee employee,
			BindingResult result/* ,HTTPServletRequest request */) {
		validator.validate(employee, result);
		if (result.hasErrors()) {
			return "input";
		}

		service.addNewEmployee(employee);
		/*
		 * HttpSession session = request.getSession();
		 * session.setAttribute("employee",employee);
		 */
		return "redirect: afterSave";
	}

	@RequestMapping(value = "/afterSave", method = RequestMethod.GET)
	public String save(SessionStatus status) {
		status.setComplete();
		return "display";

	}

}
