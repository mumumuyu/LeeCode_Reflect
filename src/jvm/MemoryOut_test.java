package jvm;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/3 21:03
 */
public class MemoryOut_test {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("lgdStudyJava");
        while(true){
            a.append(Math.random()*100);
        }
    }
}
