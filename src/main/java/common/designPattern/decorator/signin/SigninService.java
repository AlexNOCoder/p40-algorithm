package common.designPattern.decorator.signin;

import common.designPattern.adapter.loginAdapter.ResultMsg;
import common.designPattern.template.templateJDBC.Member;

public class SigninService implements ISigninService{

    @Override
    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200,"注册成功",new Member());
    }

    @Override
    public ResultMsg login(String suername, String password) {
        return null;
    }
}
