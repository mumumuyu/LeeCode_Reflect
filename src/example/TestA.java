package example;
public class TestA{

    private static int x = 100;

    public static void main(String[] args) {
        System.out.println("Hello World!!!");

        int a = 5 , b = 5;
        System.out.println("a + b = " + a / b);

        System.out.println("true" == ("tr"+"ue"));
        /*TestA testA = new TestA();
        testA.x++;
        System.out.println(testA.x);
        TestA testA1 = new TestA();
        testA1.x++;
        System.out.println(TestA.x);*/

        TestA testA = new Sub();//编译时表现为父类，运行时表现为子类
    }

   private String baseName = "base";
   public TestA()
   {
       callName2();
   }

   public void callName2()
   {
       System. out. println(baseName);
   }

   static class Sub extends TestA
   {
       private String baseName = "sub";
       public void callName()
       {
           System. out. println (baseName) ;
       }
   }

}
