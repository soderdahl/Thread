package se.kth;

import java.util.List;

public class PrintRunnable implements Runnable {

    private int printInt;
    private volatile boolean done = false;
    //private List<String> stringList;

    public PrintRunnable(int printInt) {
        this.printInt = printInt;
    }

    public void run() {
        System.out.println(printInt);
        done = true;

    }

    public boolean isDone() {
        return done;
    }

    public int getPrintInt() {
        return printInt;
    }
}
