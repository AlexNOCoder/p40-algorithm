package common.designPattern.observer.friends;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

    private String name;
    public Teacher(String name){
        this.name = name ;
    }


    @Override
    public void update(Observable o, Object arg) {
        Friend friend = (Friend)o;
        Question question = (Question)arg;
        System.out.println("=======");
        System.out.println(name+"你好！\n"+"您收到一个来自"+friend.getName()+"的提问，内容如下： \n"+question.getContent()+"\n"+"提问者： "+question.getUserName());
    }
}
