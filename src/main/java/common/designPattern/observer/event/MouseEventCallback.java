package common.designPattern.observer.event;
public class MouseEventCallback {
    public void onClick(Event e) {
        System.out.println("=======出发鼠标单击事件========" + "\n" + e);
    }

    public void onDoubleClick(Event e) {
        System.out.println("=======出发鼠标双击事件========" + "\n" + e);
    }


    public void onUp(Event e) {
        System.out.println("=======出发鼠标单击事件========" + "\n" + e);
    }

    public void onDown(Event e) {
        System.out.println("=======出发鼠标单击事件========" + "\n" + e);
    }

    public void onMove(Event e) {
        System.out.println("=======出发鼠标单击事件========" + "\n" + e);
    }

    public void onWheel(Event e) {
        System.out.println("=======出发鼠标单击事件========" + "\n" + e);
    }

    public void onOver(Event e) {
        System.out.println("=======出发鼠标单击事件========" + "\n" + e);
    }

    public void onBlur(Event e) {
        System.out.println("=======出发鼠标单击事件========" + "\n" + e);
    }

    public void onFocus(Event e) {
        System.out.println("=======出发鼠标单击事件========" + "\n" + e);
    }
}
