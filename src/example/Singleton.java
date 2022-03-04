package example;

//public class Singleton {
//    private static volatile Singleton instance;
//    public static Singleton getInstance(){
//        if(instance != null)
//            return instance;
//        synchronized(Singleton.class){
//            if(instance == null)
//                instance = new Singleton();
//        }
//        return instance;
//    }
//    public static void main(String[] args) {
//        new Thread(()->{
//            Singleton s1 = new Singleton();
//            Singleton s2 = new Singleton();
//            System.out.println(s1 == s2);
//        }).start();
//    }
//}
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
    public static void main(String[] args) {
        MakeUp makeUp = new MakeUp(1,"lgd");
        MakeUp makeUp1 = new MakeUp(0,"lgd2");
        makeUp.start();
        makeUp1.start();
    }
}
class Fish {

    private static Fish uniqueInstance;

    private Fish() {
    }

    public static Fish getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Fish();
        }
        return uniqueInstance;
    }
}
class Pig {
    private static Pig uniqueInstance;
    private Pig() {
    }
    public static Pig getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Pig();
        }
        return uniqueInstance;
    }
}
class MakeUp extends Thread{
    int choice;
    String name;

    public MakeUp(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        if(choice==1){
            synchronized (Fish.class){
                System.out.println(name+"获得了fish");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Pig.class){
                    System.out.println(name + "获得了pig");
                }
            }
        }else{
            synchronized (Pig.class){
                System.out.println(name + "获得了pig");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Fish.class){
                    System.out.println(name+"获得了fish");
                }
            }
        }
    }
}