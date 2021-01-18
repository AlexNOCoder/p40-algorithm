package common.designPattern.template;
public class NetworkCourseTest {
    public static void main(String[] args) {
        System.out.println("---java课程---");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.checkHomework();

        System.out.println("---bigData课程---");
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}
