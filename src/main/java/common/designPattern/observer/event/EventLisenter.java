package common.designPattern.observer.event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventLisenter {
    //监听器，观察者的桥梁

    //Jdk底层的Lisenter 通常也是这样设计的
    protected Map<String,Event> events = new HashMap<>();

    public void addLisenter(String eventType, Object target, Method callback){

        //事件注册
        events.put(eventType,new Event(target,callback));
    }


    //事件名称和一个目标对象来触发事件
    public void addLisenter(String eventType,Object target){
        try {
            this.addLisenter(eventType,target,target.getClass().getMethod("on"+ toUpperFirstCase(eventType),Event.class));
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //触发,只要有动作就触发
    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try{
            //发起回调
            if(event.getCallback() != null){
                //用反射回调

                event.getCallback().invoke(event.getTarget(),event);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //事件名称触发

    protected void trigger(String trigger){
        if(!this.events.containsKey(trigger)){
            return;
        }
        trigger(this.events.get(trigger).setTrigger(trigger));
    }


    private String toUpperFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
