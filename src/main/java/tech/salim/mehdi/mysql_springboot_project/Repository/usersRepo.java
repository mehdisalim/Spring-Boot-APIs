package tech.salim.mehdi.mysql_springboot_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.salim.mehdi.mysql_springboot_project.Model.userInfo;

import java.util.List;

public interface usersRepo extends JpaRepository<userInfo, Long> {
    List<userInfo> findAll();
    //List<userInfo> findAllByFirst_nameOrLast_name(String name);
    //List<userInfo> findAllByEmail(String email);
}
