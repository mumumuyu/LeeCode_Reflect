package example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: LGD
 * @date:2022/8/16 19:50
 */
public class MTest {
    public static void main(String[] args) {
//        char a = 'c';
//        System.out.println(Character.isLowerCase(a));
//        System.out.println((a>='a' && a <= 'z'));
//        System.out.println(String.valueOf(new Date().getTime()));
        /*ArrayList<String> lists = new ArrayList<>();
        lists.add("a");
        lists.add("b");
        String collect = String.join(",", lists);
        System.out.println(collect);
*/
/*        String b = "id为---- " + 14556 + " ----的实时投放活动创建成功";
        System.out.println(b.substring(0,7));
        System.out.println(b.split(" ")[1]);*/
        Animal2 a = new Animal2();
        Animal2 c = new Cat2();
        a.move();
        c.move();
    }
}


class Animal2{
    public void move(){
        System.out.println("动物可以移动");
    }
}
class Cat2 extends Animal2{
    public void move(){
        System.out.println("猫可以奔跑");
    }
    public void bark(){
        System.out.println("猫可以喵喵叫");
    }
}





