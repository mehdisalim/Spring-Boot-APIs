package tech.salim.mehdi.mysql_springboot_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.salim.mehdi.mysql_springboot_project.Model.Employees;
import tech.salim.mehdi.mysql_springboot_project.Services.EmployeesServices;

import java.util.List;
import java.util.Optional;

/**
 *
 * @Created_By : SALIM MEHDI
 * @Date : 05/11/2021
 *
 */


/**
 * We use @{@link RequestMapping} to add a request in url <br>
 * like : <b>"http//localhost:8080/employees"</b> <br>
 * and @{@link RestController} for showing the result in the webpage
 */

@RequestMapping("employees")
@RestController
public class mainController {

    @Autowired
    EmployeesServices employeesServices;

    /**
     * the Main Page in the web app (Home)
     * @param model
     * @return index.html
     */

    @GetMapping("/")
    public String index(Model model) {
        String username = (String) model.getAttribute("username");
        model.addAttribute("usernametext", username);
        return "index";
    }

    @GetMapping("/all")
    public List<Employees> getAllEmployees() {
        return employeesServices.getAllEmployees.get();
    }

    @GetMapping("/fullname/{firstname}&{lastname}")
    public List<Employees> getEmployeesByFullName(
            @PathVariable(value = "firstname") String firstname,
            @PathVariable(value = "lastname") String lastname) {

        return employeesServices.findEmployeesByFirstNameAndLastName.apply(firstname, lastname);

    }

    @GetMapping("/firstname/{name}")
    public List<Employees> getEmployeesByFirstName(@PathVariable String name) {
        return employeesServices.findEmployeesByFirstName.apply(name);
    }

    @GetMapping("/lastname/{name}")
    public List<Employees> getEmployeesByLastName(@PathVariable String name) {
        return employeesServices.findEmployeesByLastName.apply(name);
    }

    @GetMapping("/jobtitle/{job}")
    public List<Employees> getEmployeesByName(@PathVariable String job) {
        return employeesServices.findEmployeesByJobTitle.apply(job);
    }

    @GetMapping("/id/{id}")
    public Optional<Employees> getEmployeesByName(@PathVariable long id) {
        return employeesServices.findById.apply(id);
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employees employees) {
        employeesServices.addEmployee.accept(employees);
        return "Insert Employee " + employees.getFirstName() + employees.getLastName() + " is Successfully";
    }

    @PostMapping("/addall")
    public String addAllEmployees(@RequestBody Iterable<Employees> employees) {
        employeesServices.addAllEmployees.accept(employees);
        return "Insert All Employees Successfully";
    }

    @DeleteMapping("/delete/byemployee")
    public String deleteEmployee(@RequestBody Employees employees) {
        employeesServices.deleteEmployee.accept(employees);
        return "Delete Employee Successful";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        employeesServices.deleteEmployeeById.accept(id);
        return "Delete Employees By " + id + " Successful";
    }

    @DeleteMapping("/delete/all")
    public String deleteAllEmployees() {
        employeesServices.deleteAllEmployees.get();
        return "Delete All Employees Successful";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employees employees) {
        employeesServices.updateEmployee.apply(id, employees);
        return "Update Successfully.";
    }

}
