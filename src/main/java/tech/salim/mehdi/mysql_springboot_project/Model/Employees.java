package tech.salim.mehdi.mysql_springboot_project.Model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long ID;
    String firstName;
    String lastName;
    String jobTitle;
    int salary;

}
