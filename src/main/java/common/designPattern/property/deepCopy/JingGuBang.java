package common.designPattern.property.deepCopy;

import java.io.Serializable;

public class JingGuBang implements Serializable {
    private float h = 100;
    private float d = 10;

    public void big(){
        this.d *= 2;
        this.h *= 2;
    }

    public void small(){
        this.d /= 2;
        this.h /= 2;
    }
}
