package common.designPattern.observer.friends;
public class FriendTest {
    public static void main(String[] args) {
        Friend friend = Friend.getInstance();
        Teacher tom = new Teacher("tome");
        Teacher mic = new Teacher("Mic");

        friend.addObserver(tom);
        friend.addObserver(mic);


        Question question = new Question();
        question.setContent("如何使用观察者模式");
        question.setUserName("小明");

        friend.publishQuestion(question);
     }
}
