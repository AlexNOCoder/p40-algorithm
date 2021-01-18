package common.designPattern.adapter.loginAdapter;
public interface LoginAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id,Object adapter);
}
