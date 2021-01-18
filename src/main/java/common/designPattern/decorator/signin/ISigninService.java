package common.designPattern.decorator.signin;

import common.designPattern.adapter.loginAdapter.ResultMsg;

public interface ISigninService {
    ResultMsg regist(String username,String password);

    ResultMsg login(String suername,String password);
}
