package common.designPattern.proxy.cglib;


import common.designPattern.proxy.Customer;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeipo implements MethodInterceptor{

    public Object getInstance(Class<?> clazz)throws Exception{
        Enhancer enhancer = new Enhancer();
        //要把哪个设置为即将生成的新类父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o,objects);
        after();
        return obj;
    }
    private void before(){
        System.out.println("Proxy before method");
    }

    private void after(){
        System.out.println("Proxy after method");
    }

    public static void main(String[] args) {
        try{
            Customer obj = (Customer) new CglibMeipo().getInstance(Customer.class);
            obj.findLove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
