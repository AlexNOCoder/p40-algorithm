package common.designPattern.singleton;
public class LazySimpleSingleton {
    private LazySimpleSingleton(){}

    private static LazySimpleSingleton lazy = null;

    public static LazySimpleSingleton getInstance(){
        if(lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
