package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象
 * <p>
 * 基于jdk自带的动态代理类实现
 *
 * @author masaiqi
 * @date 2020/3/14 11:24 下午
 */
public class PlayerProxy implements InvocationHandler {

    private IPlayer iPlayer;

    public IPlayer getInstance(IPlayer iPlayer) {

        this.iPlayer = iPlayer;

        Class<?> clazz = iPlayer.getClass();

        return (IPlayer) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(iPlayer, args);
        after();
        return object;
    }

    private void before() {
        System.err.println("代理对象: 您可以开始选择游戏!");
    }

    private void after() {
        System.err.println("代理对象: 您已成功选择完游戏!");
    }
}
