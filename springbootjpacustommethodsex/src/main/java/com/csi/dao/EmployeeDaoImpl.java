package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    public Employee signUp(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public List<Employee> getDataByName(String empName) {
        return employeeRepositoryImpl.findByEmpName(empName);
    }

    public Optional<Employee> getDataById(long empId) {
        return employeeRepositoryImpl.findById(empId);
    }

    public List<Employee> getAllData() {
        return employeeRepositoryImpl.findAll();
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;
        Employee employee = employeeRepositoryImpl.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);

        if (employee != null && employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
            flag = true;
        }
        return flag;
    }

    public Employee updateData(Employee employee){
        return employeeRepositoryImpl.save(employee);
    }

    public void deleteDataById(long empId){
        employeeRepositoryImpl.deleteById(empId);
    }
}
