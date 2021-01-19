package common.designPattern.factory.simpleFactory;
public class CourseFactory {

    public ICourse create(String name){
        if("java".equals(name)){
            return new JavaCourse();
        }else if("python".equals(name)){
            return new PythonCourse();
        }else {
            return null;
        }
    }
}
