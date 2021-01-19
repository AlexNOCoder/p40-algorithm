package common.designPattern.property.deepCopy;

import java.io.*;
import java.util.Date;

public class QiTianDaSheng extends Monkey implements Cloneable, Serializable {
    public JingGuBang jingGuBang;

    public QiTianDaSheng(){
        this.birthday = new Date();
        this.jingGuBang = new JingGuBang();
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return deepClone();
    }

    public Object deepClone(){
        try{
            //字节流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            //对象字节流
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            //将当前对象读取成对象字节流，然后转换成字节流
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);


            QiTianDaSheng copy = (QiTianDaSheng)ois.readObject();
            copy.birthday = new Date();

            return copy;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }

    public QiTianDaSheng shallowClone(QiTianDaSheng target){
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.weight;

        qiTianDaSheng.jingGuBang = target.jingGuBang;
        qiTianDaSheng.birthday = new Date();

        return qiTianDaSheng;
    }
}
