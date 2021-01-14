package common.designPattern.singleton;

import java.io.Serializable;

public class SeriableSingleton implements Serializable {


    public final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton(){

    }

    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }

    //hasReadResolveMethod方法
    private Object readResolve(){
        return INSTANCE;
    }

}
