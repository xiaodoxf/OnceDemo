package com.baizhi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/10/29.
 */
public class TestSort {

    @Test
    public void ma(){
        List<Person> personList = Arrays.asList(
                new Person(1,"Tom"),
                new Person(2,"Lucy"),
                new Person(3,"Jack")
        );
        Optional<Person> max = personList.stream()
                .max((p1, p2) -> p1.getId() - p2.getId());
        Person person = max.get();
        System.out.println(person);

    }
    @Test
    public void mb(){
        List<Person> personList = Arrays.asList(
                new Person(1,"Tom"),
                new Person(2,"Lucy"),
                new Person(3,"Jack")
        );
        personList.stream().limit(2).collect(Collectors.toList()).forEach(System.out::println);
    }
}
