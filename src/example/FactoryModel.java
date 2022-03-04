package example;

public class FactoryModel {
    public static void main(String[] args) {
        Animal fish = new Fisha();
        Animal dog = new Dog();
        Animal cat = new Cat();
        fish.shout();
        dog.shout();
        cat.shout();
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