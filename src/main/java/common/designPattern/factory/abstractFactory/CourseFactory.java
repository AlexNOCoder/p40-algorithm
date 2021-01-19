package common.designPattern.factory.abstractFactory;
public interface CourseFactory {
    INote createNote();
    IVideo createVideo();
}
