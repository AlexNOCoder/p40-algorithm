package common.designPattern.decorator.signin;

import common.designPattern.adapter.loginAdapter.ResultMsg;

public interface ISigninForThirdService extends ISigninService{
    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String telphone,String code);

    ResultMsg loginForRegist(String username,String password);
}
