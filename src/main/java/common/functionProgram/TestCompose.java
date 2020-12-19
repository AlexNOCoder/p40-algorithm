package common.functionProgram;
public class TestCompose {
    public interface Function<T,U>{
        U apply(T arg);
    }

    public static void main(String[] args) {
        Function<Integer,Integer> triple = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg *  3;
            }
        };

        Function<Integer,Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg * arg;
            }
        };

        System.out.println(compose(triple,square).apply(3));
    }

    public static  Function<Integer,Integer> compose(final Function<Integer,Integer> f1,final Function<Integer,Integer> f2){
        return new Function<Integer,Integer>(){

            @Override
            public Integer apply(Integer arg) {
                return f1.apply(f2.apply(arg));
            }
        };
    }
}
