package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {
	@Transactional
	public ArrayList<Employee> getAllEmployees() {
		return new EmployeeDao().getAllEmployees();
	}
}
