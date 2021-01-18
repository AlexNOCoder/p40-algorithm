package common.designPattern.adapter.loginAdapter;
public class PassportForThirdAdapter extends SiginService implements IPassportForThird{
    @Override
    public ResultMsg loginForQQ(String id) {
        return proccessLogin(id,LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return proccessLogin(id,LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return proccessLogin(token,LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return proccessLogin(telphone,LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String username, String password) {
        super.regist(username,null);
        return super.login(username,null);
    }


    //简单工厂模式和策略模式

    private ResultMsg proccessLogin(String key,Class<? extends  LoginAdapter> clazz){
        try {

            LoginAdapter adapter = clazz.newInstance();
            if(adapter.support(adapter)){
                return adapter.login(key,adapter);
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
