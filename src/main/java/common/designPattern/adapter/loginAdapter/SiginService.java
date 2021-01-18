package common.designPattern.adapter.loginAdapter;

import common.designPattern.template.templateJDBC.Member;

public class SiginService {

    public ResultMsg regist(String username,String password){
        return new ResultMsg(200,"注册成功",new Member());
    }


    public ResultMsg login(String username,String password){
        return null;
    }
}
