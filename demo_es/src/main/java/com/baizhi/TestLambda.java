package com.baizhi;

import org.omg.CORBA.UNKNOWN;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/10/29.
 */
public class TestLambda {
    /**
     * 结合 FunctionalInterface Lib, forEach, stream()，method reference
     * @param args
     */
    public static void main(String[] args) {
        LambdaInterface li = (s)-> System.out.println("hello:"+s);
        li.mb("xiaobao");

        List<Person> ps = new ArrayList<Person>();
        ps.add(new Person(1,"zhangsan"));
        ps.add(new Person(2,"lisi"));
       /* ma(ps,
                p -> p.getId()==1,
                p -> System.out.println(p));*/
       //使用Stream替代静态函数
        Stream<Person> stream = ps.stream();

        stream.filter(person -> person.getId()==1).forEach(p-> System.out.println(p));

        // 使用method reference 简化
        ps.stream().forEach(System.out::println);
        /**
         * optional配合lambda 简化null值判断
         */
        Person person = goAndGetPerson();
        Optional<Person> personOps = Optional.ofNullable(person);
        /*if(person1.isPresent()){
            System.out.println(person1.get());
        }else{
            System.out.println("不知道的类型");
        }*/
        personOps.ifPresent(System.out::println);
        // 不存在则自定义返回
        personOps.orElseGet(()->new Person(1,""));
        String s = personOps.map(p -> p.getName()).map(name -> name.toLowerCase()).orElse(null);
        System.out.println(s);
    }
    public static void ma(List<Person> ps, Predicate<Person> pd, Consumer<Person> c){
        ps.forEach(p-> {
            if(pd.test(p)) c.accept(p);
        });
    }

    public static Person goAndGetPerson(){
        return new Person(3,"AAA");
    }
}
