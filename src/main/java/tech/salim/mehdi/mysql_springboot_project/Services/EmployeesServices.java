package tech.salim.mehdi.mysql_springboot_project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.salim.mehdi.mysql_springboot_project.Model.Employees;
import tech.salim.mehdi.mysql_springboot_project.Repository.EmployeesRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServices{



    @Autowired
    private EmployeesRepo employeesRepo;

    public List<Employees> getAllEmployees() {
        return employeesRepo.findAll();
    }

    public List<Employees> findEmployeesByFirstNameAndLastName(String firstname,String lastname){
        return employeesRepo.findAllByFirstNameAndLastName(firstname,lastname);
    }

    public List<Employees> findEmployeesByFirstName(String name){
        return employeesRepo.findAllByFirstName(name);
    }

    public List<Employees> findEmployeesByLastName(String name){
        return employeesRepo.findAllByLastName(name);
    }

    public List<Employees> findEmployeesByJobTitle(String job){
        return employeesRepo.findAllByJobTitle(job);
    }

    public Optional<Employees> findById(long id){
        return employeesRepo.findById(id);
    }

    public Employees addEmployee(Employees employees){
        return employeesRepo.save(employees);
    }

    public Iterable<Employees> addAllEmployees(Iterable<Employees> employees){
        return employeesRepo.saveAll(employees);
    }

    public void deleteEmployee(Employees employees){
        employeesRepo.delete(employees);
    }

    public void deleteEmployeeById(Long employeeId){
        employeesRepo.deleteById(employeeId);
    }

    public void deleteAllEmployees(){
        employeesRepo.deleteAll();
    }

    public Employees updateEmployee(Long id,Employees employees){
        Employees employee=new Employees();
        employee.setID(id);
        employee.setFirstName(employees.getFirstName());
        employee.setLastName(employees.getLastName());
        employee.setJobTitle(employees.getJobTitle());
        employee.setSalary(employees.getSalary());

        return employeesRepo.saveAndFlush(employee);
    }

}
