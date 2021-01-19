package common.designPattern.factory.abstractFactory;
public class JavaCourseFactory implements CourseFactory{


    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
