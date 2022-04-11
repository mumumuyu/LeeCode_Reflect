package design_parttens.proxy_test;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/10 9:02
 */
public class Proxy_t implements Rent{
    private Houser houser;

    public Proxy_t(Houser houser) {
        this.houser = houser;
    }

    @Override
    public void rent() {
        System.out.println("中介代理前");
        houser.rent();
        System.out.println("中介代理后");
    }

    public static void main(String[] args) {
        Houser lgd = new Houser("lgd");
        Proxy_t proxy_t = new Proxy_t(lgd);
        proxy_t.rent();
    }
}
