package design_parttens.proxy_test;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/10 9:01
 */
public class Houser implements Rent{
    private String name;

    public Houser(String name) {
        this.name = name;
    }

    @Override
    public void rent() {
        System.out.println(name+"Houser 要出租");
    }
}
