	package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public void saveEmployee(Employee employee) {
    employeeRepository.save(employee);
  }
  @Override
  public Employee getEmployeeById(long id) {
    Optional<Employee> optional = employeeRepository.findById(id);
    return optional.orElseThrow(() -> new RuntimeException("Employee not found for id :: " + id));
  }

  @Override
  public void deleteEmployeeById(long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
    Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) 
                ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
    return employeeRepository.findAll(pageable);
  }
}