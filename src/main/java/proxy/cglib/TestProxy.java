package proxy.cglib;

import proxy.jdk.IPlayer;

/**
 * @author masaiqi
 * @date 2020/3/14 11:32 下午
 */
public class TestProxy {

    public static void main(String[] args) {
        PlayerProxy playerProxy = new PlayerProxy();
        PlayerA playerA = (PlayerA) playerProxy.getInstance(PlayerA.class);
        playerA.pickGame();
    }

}
