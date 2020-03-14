package proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理对象
 * <p>
 * 基于cglib的动态代理实现
 *
 * @author masaiqi
 * @date 2020/3/14 11:24 下午
 */
public class PlayerProxy implements MethodInterceptor {


    public Object getInstance(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object object = methodProxy.invokeSuper(o, objects);
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
