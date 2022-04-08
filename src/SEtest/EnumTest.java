package SEtest;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/8 15:53
 */
public class EnumTest {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
    }
    void Print(){
        System.out.println(this.color);
    }

    public static void main(String[] args) {
        EnumTest enumTest = new EnumTest();
        enumTest.Print();
        enumTest.change();
        enumTest.Print();
    }
}
enum Signal{
    RED, YELLOW, GREEN;
}
