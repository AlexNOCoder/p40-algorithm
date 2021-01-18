package common.designPattern.template;
public class BigDataCourse extends NetworkCourse{
    private boolean needHomeworkFlag = false;

    public BigDataCourse(boolean needHomeworkFlag){
        this.needHomeworkFlag = needHomeworkFlag;
    }



    @Override
    void checkHomework() {
        System.out.println("检查大数据课后作业");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
