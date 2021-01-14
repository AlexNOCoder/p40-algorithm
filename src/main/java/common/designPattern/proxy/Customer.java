package common.designPattern.proxy;
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("Customer findlove");
    }

    public static void main(String[] args) {
        try{
            Person obj = (Person) new JDKMeipo().getInstance(new Customer());
            obj.findLove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
