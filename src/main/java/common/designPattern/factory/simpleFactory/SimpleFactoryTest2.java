package common.designPattern.factory.simpleFactory;
public class SimpleFactoryTest2 {
    public static void main(String[] args) {
        CourseFactory2 factory = new CourseFactory2();
        ICourse course =factory.create("common.designPattern.factory.simpleFactory.JavaCourse");
        course.record();
    }
}
