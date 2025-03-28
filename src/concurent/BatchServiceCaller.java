package concurent;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class BatchServiceCaller {

    // 模拟调用服务的方法，每次接收最多10个参数
    public static List<String> callService(List<String> batch) {
        // 模拟耗时
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
        return batch.stream().map(s -> "result_of_" + s).collect(Collectors.toList());
    }

    public static List<String> process(List<String> allParams) throws InterruptedException, ExecutionException {
        int batchSize = 10;
        List<List<String>> batches = new ArrayList<>();

        // 1. 拆分参数
        for (int i = 0; i < allParams.size(); i += batchSize) {
            batches.add(allParams.subList(i, Math.min(i + batchSize, allParams.size())));
        }

        // 2. 使用线程池并发调用
        ExecutorService executor = Executors.newFixedThreadPool(5); // 可调整线程数
        List<Future<List<String>>> futures = new ArrayList<>();

        for (List<String> batch : batches) {
            futures.add(executor.submit(() -> callService(batch)));
        }

        // 3. 聚合所有结果
        List<String> allResults = new ArrayList<>();
        for (Future<List<String>> future : futures) {
            allResults.addAll(future.get());
        }

        executor.shutdown();
        return allResults;
    }

    public static void main(String[] args) throws Exception {
        List<String> input = new ArrayList<>();
        for (int i = 1; i <= 35; i++) {
            input.add("param" + i);
        }

        List<String> result = process(input);
        System.out.println("最终结果：");
        result.forEach(System.out::println);
    }
}
