package se.kth;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainClass {
    static ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<PrintRunnable> printRunnableList = new ArrayList<PrintRunnable>(200);
        List<Future> futures = new ArrayList<Future>(100);
        List<CompletableFuture<Integer>> compList = new ArrayList<>(100);

        for (int i=0; i<100; i++) {
            PrintRunnable printRunnable = new PrintRunnable(i);
           /* printRunnableList.add(printRunnable);
           new Thread(printRunnable).start();*/

          /*  Future<?> future = executorService.submit(printRunnable);
            futures.add(future);*/

          final int j= i;
            CompletableFuture<Integer> comp = CompletableFuture.supplyAsync(() -> {
                System.out.println("CompletableFuture!: " + j);
                return j;
            }, executorService);
            compList.add(comp);
        }


        CompletableFuture.allOf(compList.toArray(new CompletableFuture[compList.size()] )).join();


       /* int numberDone = 0;
        while (numberDone < 100) {
           // System.out.println("NumberDone: "+numberDone);
           /* PrintRunnable runnable = printRunnableList.get(numberDone);
            if (runnable.isDone()) {
                numberDone++;
            } */

         /* if (futures.get(numberDone).isDone()){
              numberDone++;
            }*/

      //  }

       for(CompletableFuture<Integer> future: compList) {
           System.out.println("We got future.get: "+ future.get());
       }

        System.out.println("All thread done!!!!!");


    }


}
