package tech.salim.mehdi.mysql_springboot_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.salim.mehdi.mysql_springboot_project.Model.userInfo;
import tech.salim.mehdi.mysql_springboot_project.Services.userServices;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin

@RequestMapping("/user")
@RestController
public class userController {

    @Autowired
    userServices services;

    @GetMapping("all")
    public List<userInfo> findAllUsers() {
        return services.findAll()
                .stream()
                .filter(userInfo -> !Objects
                        .equals(userInfo.getPassword(), null))
                        .sorted(Comparator.comparing(userInfo::getCustomer_id).reversed())
                        .collect(Collectors.toList());
    }

}
