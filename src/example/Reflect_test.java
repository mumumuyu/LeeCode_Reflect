package example;

/**
 * @ClassName: Reflect_test
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/4  13:11
 */
public class Reflect_test {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class<?> aClass = Class.forName("example.User");
        Class<?> aClass2 = Class.forName("example.User");
        Class<?> aClass3 = Class.forName("example.User");
        Class<?> aClass4 = Class.forName("example.User");
        Class<?> aClass5 = Class.forName("example.User");

        System.out.println(aClass.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());
        System.out.println(aClass4.hashCode());
        System.out.println(aClass5.hashCode());

    }
}
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}