package common.designPattern.observer.friends;

import java.util.Observable;

public class Friend  extends Observable {
    //使用jdk提供的一种观察者的实现方式，被观察者

    private String name = "朋友圈";

    private static Friend friend = null;
    private Friend(){}

    public static Friend getInstance(){
        if(null == friend){
           friend = new Friend();
        }
        return friend;
    }

    public String getName(){
        return  name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName()+"在"+this.name+"上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
