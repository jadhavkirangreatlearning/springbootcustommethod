package com.csi.repository;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom methods goes here


    public List<Employee> findByEmpName(String empName);

    public Employee findByEmpEmailIdAndEmpPassword(String empEmailId, String empPassword);
}
