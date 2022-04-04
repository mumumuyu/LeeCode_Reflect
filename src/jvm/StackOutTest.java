package jvm;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/3 21:01
 */
public class StackOutTest {
    public static void main(String[] args) {
        StackOutTest stackOutTest = new StackOutTest();
        stackOutTest.a();
    }

    void a(){
        this.b();
    }
    void b(){
        this.a();
    }
}
