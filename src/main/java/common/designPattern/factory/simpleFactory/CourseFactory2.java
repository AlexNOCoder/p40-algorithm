package common.designPattern.factory.simpleFactory;
public class CourseFactory2 {
    public ICourse create(String className){
        try{

            if(!(null == className || "".equals(className))){
                return (ICourse) Class.forName(className).newInstance();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
