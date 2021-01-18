package common.designPattern.adapter.loginAdapter;
public interface LoginAdapter {
    //适配器模式一般都有support方法，来判断是否兼容
    boolean support(Object adapter);
    ResultMsg login(String id,Object adapter);
}
