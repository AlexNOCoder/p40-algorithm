package common.designPattern.adapter.loginAdapter;
public interface IPassportForThird {
    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForToken(String token);


    ResultMsg loginForTelphone(String telphone,String code);

    ResultMsg loginForRegist(String username,String password);
}
