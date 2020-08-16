package se.kth;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> collect = IntStream.range(0, 200).boxed().collect(Collectors.toList());
        List<Integer> processList = collect.parallelStream()
                .flatMap(file -> {
                    fileRead(file);
                    return fileReadList;
                })
                .filter()
                .collect(Collectors.toList());

        for (Integer result:processList) {
            System.out.println("Result: "+result);
        }
    }
}
