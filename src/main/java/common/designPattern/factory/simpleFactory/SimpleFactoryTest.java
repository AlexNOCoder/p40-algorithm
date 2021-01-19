package common.designPattern.factory.simpleFactory;
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new CourseFactory();
        courseFactory.create("java").record();
    }
}
