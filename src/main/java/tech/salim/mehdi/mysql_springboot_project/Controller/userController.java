package tech.salim.mehdi.mysql_springboot_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/user")
@RestController
public class userController {

    @Autowired
    userServices services;

    @GetMapping("all")
    public List<userInfo> findAllUsers(){
        List<userInfo> userInfoList=services.findAll();
        Stream<userInfo> stream = userInfoList.stream();
        List<userInfo> collect =
                stream.filter(userInfo -> !Objects
                        .equals(userInfo.getPassword(), null))
                        .sorted(Comparator.comparing(userInfo::getCustomer_id).reversed())
                        .collect(Collectors.toList());
        return collect;
    }

}
