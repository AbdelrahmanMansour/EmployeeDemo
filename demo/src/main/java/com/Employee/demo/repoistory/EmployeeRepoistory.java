package com.Employee.demo.repoistory;


import com.Employee.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepoistory extends JpaRepository<Employee, Long> {
}
