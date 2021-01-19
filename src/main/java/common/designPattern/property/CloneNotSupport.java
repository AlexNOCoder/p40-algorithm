package common.designPattern.property;
public class CloneNotSupport {
    private CloneNotSupport INSTANCE;

    private CloneNotSupport(){};

    public CloneNotSupport getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CloneNotSupport();
        }
        return INSTANCE;
    }


    //当我们要防止克隆破坏单利模式时,需要重写clone方法，使得clone返回实例对象
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return INSTANCE;
    }

}
