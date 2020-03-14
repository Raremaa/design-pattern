package proxy.jdk;

/**
 * @author masaiqi
 * @date 2020/3/14 11:32 下午
 */
public class TestProxy {

    public static void main(String[] args) {
        PlayerProxy playerProxy = new PlayerProxy();
        IPlayer proxyObj = playerProxy.getInstance(new PlayerA());
        proxyObj.pickGame();
    }

}
