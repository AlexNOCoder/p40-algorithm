package common.designPattern.adapter.loginAdapter;
public class PassportTest {
    public static void main(String[] args) {
        IPassportForThird passportForThird = new PassportForThirdAdapter();
        passportForThird.loginForQQ("12212");
    }
}
