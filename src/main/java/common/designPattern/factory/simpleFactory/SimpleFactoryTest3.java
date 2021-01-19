package common.designPattern.factory.simpleFactory;
public class SimpleFactoryTest3 {
    public static void main(String[] args) {
        CourseFactory3 factory = new CourseFactory3();
        ICourse course =factory.create(JavaCourse.class);
        course.record();
    }
}
