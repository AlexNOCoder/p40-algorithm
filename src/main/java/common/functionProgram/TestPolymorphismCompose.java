package common.functionProgram;
public class TestPolymorphismCompose {
    public interface Function<T,U>{
        U apply(T arg);
        static <T ,U , V> Function<Function<U,V>, Function<Function<T,U>, Function<T,V>>> compose (){
           return x -> y -> z -> x.apply(y.apply(z));
        }



        static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
            return f -> g -> x -> f.apply(g.apply(x));
        }
    }


    public static void main(String[] args) {
        Function<Integer,Integer> triple = x -> x * 3;

        Function<Integer,Integer> square = x -> x * x;

        Function<Function<Integer,Integer>, Function<Function<Integer,Integer>, Function<Integer,Integer>>> compose =
                x -> y -> z -> x.apply(y.apply(z));

        Function<Integer,Integer> f = compose.apply(square).apply(triple);
        System.out.println(f.apply(2));

    }
}
