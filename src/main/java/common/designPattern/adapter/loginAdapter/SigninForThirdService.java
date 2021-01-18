package common.designPattern.adapter.loginAdapter;
public class SigninForThirdService extends SiginService {
    public ResultMsg loginForQQ(String openId){
        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }


    public ResultMsg loginForToken(String token){
        return null;
    }


    public ResultMsg loginForTelphone(String telphone,String password){
        return null;
    }

    public ResultMsg loginForRegist(String username,String password){
        super.regist(username,password);
        return super.login(username,null);
    }
}
