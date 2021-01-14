package common.designPattern.singleton;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingleton2 {

    //默认使用LazyInnerClassSingleton general的时候，会先初始化内部类
    //如果没有使用的话，内部类是不加载的
    private LazyInnerClassSingleton2(){
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }



    //每一个关键字都不是多余的
    //static是为了使单例的空间共享
    //保证这个方法不会被重写
    public static final LazyInnerClassSingleton2 getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        private static final LazyInnerClassSingleton2 LAZY = new LazyInnerClassSingleton2();
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyInnerClassSingleton2.class;

            //通过反射拿到私有的构造函数
            Constructor c = clazz.getDeclaredConstructor(null);

            //强制访问
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();

            Object o2 = c.newInstance();

            System.out.println(o1 == o2);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
