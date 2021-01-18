package common.designPattern.decorator.signin;
public class DecoratorTest {
    public static void main(String[] args) {
        ISigninForThirdService signinForThirdService = new SigninForThirdService(new SigninService());
        signinForThirdService.loginForQQ("abcdefg");
    }
}
