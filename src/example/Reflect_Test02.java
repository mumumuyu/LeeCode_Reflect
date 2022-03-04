package example;

/**
 * @ClassName: Reflect_Test02
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/4  13:32
 */
public class Reflect_Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        Class<? extends Person> aClass = person.getClass();
        Class<?> aClass1 = Class.forName("example.Student");
        System.out.println(aClass  == aClass1);
        Class<Student> studentClass = Student.class;
        System.out.println(aClass == studentClass);

        System.out.println(Integer.TYPE);
        System.out.println(aClass.getSuperclass());

    }
}
class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}