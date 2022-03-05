package example;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @ClassName: Ann_Ref
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/5  14:16
 */
public class Ann_Ref {
    public static void main(String[] args) throws NoSuchFieldException {
        Class c1 = Studenta.class;
        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获取注解的value
        TableLGD tableLGD = (TableLGD) c1.getAnnotation(TableLGD.class);
        String value = tableLGD.value();
        System.out.println(value);

        //获取类指定注解
        Field name = c1.getDeclaredField("name");
        FieldLGD fieldLGD = name.getAnnotation(FieldLGD.class);
        System.out.println(fieldLGD.columnName());
        System.out.println(fieldLGD.length());
        System.out.println(fieldLGD.type());
    }
}

@TableLGD("db_studenta")
class Studenta{
    @FieldLGD(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldLGD(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FieldLGD(columnName = "db_name",type = "verchar",length = 3)
    private String name;

    public Studenta() {
    }

    public Studenta(int id, int age, String name) {
        this.id = id;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Studenta{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableLGD{
    String value();
}

//属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldLGD{
    String columnName();
    String type();
    int length();
}