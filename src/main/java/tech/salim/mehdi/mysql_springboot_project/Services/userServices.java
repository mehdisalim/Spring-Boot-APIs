package tech.salim.mehdi.mysql_springboot_project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.salim.mehdi.mysql_springboot_project.Model.userInfo;
import tech.salim.mehdi.mysql_springboot_project.Repository.usersRepo;

import java.util.List;

@Service
public class userServices {

    @Autowired
    usersRepo user;

    public List<userInfo> findAll(){
        return user.findAll();
    }

}
