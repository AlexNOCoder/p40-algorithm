package common.designPattern.factory.normalFactory;

import common.designPattern.factory.simpleFactory.ICourse;
import common.designPattern.factory.simpleFactory.JavaCourse;
import common.designPattern.factory.simpleFactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory{

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
