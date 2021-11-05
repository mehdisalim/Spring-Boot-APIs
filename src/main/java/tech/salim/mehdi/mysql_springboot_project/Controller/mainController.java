package tech.salim.mehdi.mysql_springboot_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.salim.mehdi.mysql_springboot_project.Model.Employees;
import tech.salim.mehdi.mysql_springboot_project.Services.EmployeesServices;

import java.util.List;
import java.util.Optional;

@RequestMapping("employees")
@RestController
public class mainController {

    @Autowired
    EmployeesServices employeesServices;

    @GetMapping("/")
    public String index(Model model){
        String username= (String) model.getAttribute("username");
        model.addAttribute("usernametext",username);
        return "index";
    }

    @GetMapping("/all")
    public List<Employees> getAllEmployees(){
        return employeesServices.getAllEmployees();
    }

    @GetMapping("/fullname/{firstname}&{lastname}")
    public List<Employees> getEmployeesByFullName(
                                                    @PathVariable(value = "firstname") String firstname,
                                                    @PathVariable(value = "lastname") String lastname   ){

        return employeesServices.findEmployeesByFirstNameAndLastName(firstname,lastname);

    }

    @GetMapping("/firstname/{name}")
    public List<Employees> getEmployeesByFirstName(@PathVariable String name){
        return employeesServices.findEmployeesByFirstName(name);
    }

    @GetMapping("/lastname/{name}")
    public List<Employees> getEmployeesByLastName(@PathVariable String name){
        return employeesServices.findEmployeesByLastName(name);
    }

    @GetMapping("/jobtitle/{job}")
    public List<Employees> getEmployeesByName(@PathVariable String job){
        return employeesServices.findEmployeesByJobTitle(job);
    }

    @GetMapping("/id/{id}")
    public Optional<Employees> getEmployeesByName(@PathVariable long id){
        return employeesServices.findById(id);
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employees employees){
        employeesServices.addEmployee(employees);
        return "Insert Employee " + employees.getFirstName() + employees.getLastName() + " is Successfully";
    }

    @PostMapping("/addall")
    public String addAllEmployees(@RequestBody Iterable<Employees> employees){
        employeesServices.addAllEmployees(employees);
        return "Insert All Employees Successfully";
    }

    @DeleteMapping("/delete/byemployee")
    public String deleteEmployee(@RequestBody Employees employees){
        employeesServices.deleteEmployee(employees);
        return "Delete Employee Successful";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        employeesServices.deleteEmployeeById(id);
        return "Delete Employees By "+id+" Successful";
    }

    @DeleteMapping("/delete/all")
    public String deleteAllEmployees(){
        employeesServices.deleteAllEmployees();
        return "Delete All Employees Successful";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id,@RequestBody Employees employees){
        employeesServices.updateEmployee(id,employees);
        return "Update Successfully.";
    }

}
