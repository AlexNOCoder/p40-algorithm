package common.designPattern.proxy.cglib;

import common.designPattern.proxy.Customer;
import common.designPattern.proxy.Person;

import java.lang.reflect.Method;

public class GPMeipo implements GPInvocationHandler {

    //被代理的对象，把引用给保存下来
    private Object target;


    public Object getInstance(Object target) throws Exception{
        this.target = target;
        Class<?> clazz = target.getClass();

        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();

        method.invoke(this.target,args);
        after();

        return null;
    }



    private void before(){
        System.out.println("Proxy before method");
    }

    private void after(){
        System.out.println("Proxy after method");
    }


    public static void main(String[] args) {
        try {
            Person obj =(Person) new GPMeipo().getInstance(new Customer());
            System.out.println(obj.getClass());
            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
