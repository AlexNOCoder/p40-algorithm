package common.functionProgram;
public class TestLambdaCompose {
    public interface Function<T,U>{
        U apply(T arg);
    }

    public static void main(String[] args) {
        Function<Integer,Integer> triple = x -> x * 3;

        Function<Integer,Integer> square = x -> x * x;

        Function<Integer,Function<Integer,Integer>> add = x -> y -> x + y;

        System.out.println(compose(triple,square).apply(3));
        System.out.println(add.apply(3).apply(5));
    }

    public static Function<Integer,Integer> compose(final Function<Integer,Integer> f1, final Function<Integer,Integer> f2){
        return x -> f1.apply(f2.apply(x));
    }
}
