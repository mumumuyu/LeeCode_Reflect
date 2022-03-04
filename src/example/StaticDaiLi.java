package example;

public class StaticDaiLi {
    public static void main(String[] args) {
        Host host = new Host();
        Daili daili = new Daili(host);
        daili.rent();
    }
}

interface Rent{
    void rent();
}
class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房主出租");
    }
}
class Daili implements Rent{
    private Host host;

    public Daili(Host host) {
        this.host = host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        this.before();
        host.rent();
        this.after();
    }

    void before(){
        System.out.println("rent前");
    }
    void after(){
        System.out.println("rent后");
    }
}
