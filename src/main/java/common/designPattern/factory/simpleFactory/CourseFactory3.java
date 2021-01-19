package common.designPattern.factory.simpleFactory;
public class CourseFactory3 {
    public ICourse create(Class<? extends ICourse> clazz){
        try{
            if(null != clazz){
                return clazz.newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
