package example;

import java.util.TreeSet;

public class TestA{

    private static int x = 100;

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i);
            }
        }
        subSet = (TreeSet)set.subSet(608,true,611,true);
        set.add(609);
        set.add(611);
        set.add(613);
        System.out.println(set+" "+subSet);

/*        System.out.println("Hello World!!!");

        int a = 5 , b = 5;
        System.out.println("a + b = " + a / b);

        System.out.println("true" == ("tr"+"ue"));
        *//*TestA testA = new TestA();
        testA.x++;
        System.out.println(testA.x);
        TestA testA1 = new TestA();
        testA1.x++;
        System.out.println(TestA.x);*//*

        TestA testA = new Sub();//编译时表现为父类，运行时表现为子类*/
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
