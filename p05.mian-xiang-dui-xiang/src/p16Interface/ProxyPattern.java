package p16Interface;

public class ProxyPattern {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxy = new ProxyServer(server);
        proxy.browse();
    }
}

interface NetWork{
    void browse();
}

// 被代理类
class Server implements NetWork {
    @Override
    public void browse() {
        System.out.println("真实的服务器访问服务");
    }
}

// 代理类
class ProxyServer implements NetWork {
    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("联网之前做的一些工作");
    }

    @Override
    public void browse() {
        check();
        this.work.browse();
    }
}
