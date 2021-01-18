package common.designPattern.decorator.signin;

import common.designPattern.adapter.loginAdapter.ResultMsg;

public class SigninForThirdService implements ISigninForThirdService{

    private ISigninService signin;

    public SigninForThirdService(ISigninService iSigninService){
        this.signin = iSigninService;
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String password) {
        return null;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return signin.regist(username,password);
    }

    @Override
    public ResultMsg login(String suername, String password) {
        return signin.login(suername,password);
    }
}
