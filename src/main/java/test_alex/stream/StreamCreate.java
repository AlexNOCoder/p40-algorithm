package test_alex.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 创建流
 * @date 2021-12-29 21:42:43
 */
public class StreamCreate {
    public static void main(String[] args) throws IOException {
        Stream stream1 = Stream.of(1,2,3,4);
        int[] array = {1,2,3,4};
        IntStream stream2 = Arrays.stream(array);

        Stream<String> stream3 = Files.lines(Paths.get("/Users/luoyuntian/Desktop/projects/AlexNOCoder/p40-algorithm/src/main/java/test_alex/stream/StreamCreate.java"));
        stream3.forEach(line -> System.out.println(line));

        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);

        Stream stream = Stream.generate(Math::random);
    }
}
