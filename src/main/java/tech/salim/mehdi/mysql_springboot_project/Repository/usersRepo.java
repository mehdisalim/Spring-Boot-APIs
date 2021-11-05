package tech.salim.mehdi.mysql_springboot_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import tech.salim.mehdi.mysql_springboot_project.Model.userInfo;

import java.util.List;

public interface usersRepo extends JpaRepository<userInfo,Long> {
    List<userInfo> findAll();
}
