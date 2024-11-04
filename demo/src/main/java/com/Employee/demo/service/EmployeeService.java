package com.Employee.demo.service;


import com.Employee.demo.model.Employee;
import com.Employee.demo.repoistory.EmployeeRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepoistory employeeRepoistory;

    public Employee addEmployee(Employee employee){
        return employeeRepoistory.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepoistory.findAll().stream()
                .sorted((e1, e2)->{
                    int compareSalary =
                            Integer.compare(e1.getSalary(),
                                    e2.getSalary());
                    if(compareSalary == 0){
                        return e2.getLastName().compareTo(e1.getLastName());
                    }
                    return compareSalary;
                }).toList();
    }

    public void deleteEmployeeById(Long id){
         employeeRepoistory.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employee){
        employee.setId(id);
        return employeeRepoistory.save(employee);
    }

}
