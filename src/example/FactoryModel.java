package example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactoryModel {
    public static void main(String[] args) {
//        Animal fish = new Fisha();
//        Animal dog = new Dog();
//        Animal cat = new Cat();
//        fish.shout();
//        dog.shout();
//        cat.shout();
        ExecutorService service = Executors.newFixedThreadPool(5);

    }
}

interface Animal{
    void shout();
}
class Dog implements Animal{
    @Override
    public void shout() {
        System.out.println("wangwangwang!");
    }
}
class Cat implements  Animal{
    @Override
    public void shout() {
        System.out.println("miaomiaomiao!!!");
    }
}
class Fisha implements Animal{
    @Override
    public void shout() {
        System.out.println("yuyuyu!!!");
    }
}
