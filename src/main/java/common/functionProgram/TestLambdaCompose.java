package common.functionProgram;
public class TestLambdaCompose {
    public interface Function<T,U>{
        U apply(T arg);
    }

    public static void main(String[] args) {
        TestCompose.Function<Integer,Integer> triple = x -> x * 3;

        TestCompose.Function<Integer,Integer> square = x -> x * x;

        System.out.println(compose(triple,square).apply(3));
    }

    public static TestCompose.Function<Integer,Integer> compose(final TestCompose.Function<Integer,Integer> f1, final TestCompose.Function<Integer,Integer> f2){
        return x -> f1.apply(f2.apply(x));
    }
}
