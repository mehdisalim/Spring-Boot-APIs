package tech.salim.mehdi.mysql_springboot_project;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
class MysqlSpringbootProjectApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void streams(){

        List<String> list2= List.of("salim","malika");
        List<String> list=List.of("salim","malika","mehdi","hanan","omar","samir","khadija");
        Stream<String> stream = list.stream();
        List<String> listOfNames = stream.filter(p -> p.contains("li")).limit(3).collect(Collectors.toList());
        listOfNames.forEach(s -> {
            //Assertions.assertSame(list.contains(s) ? /* if true*/ list.get(list.indexOf(s)) : /* if false*/ null ,s,"is the same");
            System.out.println(s);
        });
        Assertions.assertSame(list2, listOfNames, "is not the same");

    }

}
