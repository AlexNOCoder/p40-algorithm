package common.designPattern.adapter.loginAdapter;
public class LoginForSinaAdapter implements LoginAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForSinaAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
