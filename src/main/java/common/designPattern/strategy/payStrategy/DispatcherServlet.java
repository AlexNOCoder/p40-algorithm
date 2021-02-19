package common.designPattern.strategy.payStrategy;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DispatcherServlet extends HttpServlet {
//    //相当于项目经理
//
//    private List<Handler> handlerMapping = new ArrayList<>();
//
//    public void init(){
//        try{
//
//            Class<?> memberControllerClass = MemberContoller.class;
//            handlerMapping.add(new Handler()
//                    .setController(memberControllerClass)
//                    .setMethod(memberControllerClass
//                            .getMethod("getMemberById",new Class[]{String.class}))
//                    .setUrl("/web/getMemberById.json"));
//        }catch (Exception e){
//
//        }
//
//    }
//
//    private void doDispatch(HttpServletRequest request, HttpServletResponse response){
//        String uri = request.getRequestURI();
//
//        Handler handler = null;
//
//
//        //匹配策略常量
//        for(Handler h: handlerMapping){
//            if(uri.equals(h.getUrl())){
//                handler = h;
//                break;
//            }
//        }
//
//        //将具体的任务分发给Method,通过反射去调用对应的方法
//        Object object = null;
//        try{
//            object = handler.getMethod().invoke(handler.getController(),request.getParameter("mid"));
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//
//        //获取到method执行的结果，通过Response返回出去
//        try {
//            response.getWriter().write("something");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    protected void service(HttpServletRequest res,HttpServletResponse response){
//        try{
//            doDispatch(res,response);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//    class Handler{
//        private Object controller;
//        private Method method;
//        private String url;
//
//        public Object getController() {
//            return controller;
//        }
//
//        public Handler setController(Object controller) {
//            this.controller = controller;
//            return this;
//        }
//
//        public Method getMethod() {
//            return method;
//        }
//
//        public Handler setMethod(Method method) {
//            this.method = method;
//            return this;
//        }
//
//        public String getUrl() {
//            return url;
//        }
//
//        public Handler setUrl(String url) {
//            this.url = url;
//            return this;
//        }
//    }
//}

public class DispatcherServlet{

}