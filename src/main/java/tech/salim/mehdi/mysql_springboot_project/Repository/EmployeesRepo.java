package tech.salim.mehdi.mysql_springboot_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.salim.mehdi.mysql_springboot_project.Model.Employees;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees, Long> {
    List<Employees> findAll();

    List<Employees> findAllByFirstNameAndLastName(String firstName,String lastName);

    List<Employees> findAllByFirstName(String firstName);

    List<Employees> findAllByLastName(String lastName);

    List<Employees> findAllByJobTitle(String jobTitle);

}
