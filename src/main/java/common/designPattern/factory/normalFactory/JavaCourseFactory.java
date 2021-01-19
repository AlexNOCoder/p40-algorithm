package common.designPattern.factory.normalFactory;

import common.designPattern.factory.simpleFactory.ICourse;
import common.designPattern.factory.simpleFactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
