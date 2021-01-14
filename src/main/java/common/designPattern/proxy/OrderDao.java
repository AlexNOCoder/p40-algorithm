package common.designPattern.proxy;
public class OrderDao {
    public int inser(Order order){
        System.out.println("OrderDao 创建Order成功");
        return 1;
    }
}
