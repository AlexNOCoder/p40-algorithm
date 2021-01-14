package common.designPattern.proxy;
public class OrderService implements IOrderService{
    private OrderDao orderDao;

    public OrderService(){
        orderDao = new OrderDao();
    }


    @Override
    public int createOrder(Order order) {
        System.out.println("OderService 调用orderDao创建订单");
        return orderDao.inser(order);
    }
}
