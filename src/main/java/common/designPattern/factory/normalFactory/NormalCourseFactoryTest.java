package common.designPattern.factory.normalFactory;

import common.designPattern.factory.simpleFactory.ICourse;

public class NormalCourseFactoryTest {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();
    }
}
