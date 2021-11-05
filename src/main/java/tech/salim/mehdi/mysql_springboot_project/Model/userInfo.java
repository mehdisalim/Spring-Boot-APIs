package tech.salim.mehdi.mysql_springboot_project.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_info")
public class userInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long customer_id;
    String first_name;
    String last_name;
    String email;
    String firstName_Manager;
    String lastName_Manager;
    String Manager_email;
    long phone;
    String username;
    String password;
    String address;
    String district;
    long city_id;
    String location;
    long postal_code;
    String password_check;
}
