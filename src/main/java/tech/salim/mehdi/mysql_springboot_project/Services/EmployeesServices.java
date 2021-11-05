package tech.salim.mehdi.mysql_springboot_project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.salim.mehdi.mysql_springboot_project.Model.Employees;
import tech.salim.mehdi.mysql_springboot_project.Repository.EmployeesRepo;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class EmployeesServices {


    @Autowired
    private EmployeesRepo employeesRepo;

    public final Supplier<List<Employees>> getAllEmployees = () -> employeesRepo.findAll();

    public final BiFunction<String, String, List<Employees>> findEmployeesByFirstNameAndLastName =
            (firstName, lastName) -> employeesRepo.findAllByFirstNameAndLastName(firstName, lastName);

    public final Function<String, List<Employees>> findEmployeesByFirstName =
            firstName -> employeesRepo.findAllByFirstName(firstName);

    public final Function<String, List<Employees>> findEmployeesByLastName =
            lastName -> employeesRepo.findAllByLastName(lastName);

    public final Function<String, List<Employees>> findEmployeesByJobTitle =
            job -> employeesRepo.findAllByJobTitle(job);

    public final Function<Long, Optional<Employees>> findById =
            id -> employeesRepo.findById(id);

    public final Consumer<Employees> addEmployee =
            employees -> employeesRepo.save(employees);

    public final Consumer<Iterable<Employees>> addAllEmployees =
            employees -> employeesRepo.saveAll(employees);

    public final Consumer<Employees> deleteEmployee =
            employees -> employeesRepo.delete(employees);

    public final Consumer<Long> deleteEmployeeById =
            employeeId -> employeesRepo.deleteById(employeeId);

    public final Supplier<String> deleteAllEmployees =
            () -> {
                employeesRepo.deleteAll();
                return null;
            };

    public final BiFunction<Long, Employees, Employees> updateEmployee =
            (aLong, employees) -> {
                Employees employee = new Employees();
                employee.setID(aLong);
                employee.setFirstName(employees.getFirstName());
                employee.setLastName(employees.getLastName());
                employee.setJobTitle(employees.getJobTitle());
                employee.setSalary(employees.getSalary());

                return employeesRepo.saveAndFlush(employee);
            };

}
