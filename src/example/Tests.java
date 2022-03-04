package example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tests
{
    private List names = new ArrayList();
    public synchronized void add(String name)
    {
        names.add(name);
    }
    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++)
        {
            System.out.print(names.get(i) + "");
        }
    }

    public static void main(String[]args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final Tests sl = new Tests();
        for (int i = 0; i < 2; i++)
        {
            executorService.execute(new Thread()
            {
                @Override
                public void run()
                {
                    sl.add("A");
                    sl.add("B");
                    sl.add("C");
                    sl.printAll();
                }
            });
        }
        executorService.shutdown();
    }
}
interface B{
    void b();
}
interface C{
    void c();
}
interface D extends B,C{
    void d();
}

class E implements D{
    int a = 10;

    @Override
    public void d() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
}

class F{
    public int c;
    static int g = 10;
    public static void main(String[] args) {
        F f = new F();
        int m = F.g;
    }
}
