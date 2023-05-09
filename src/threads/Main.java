package threads;

import static java.lang.Long.sum;

public class Main {
    static long num = 1000000000;

    public static void main(String[] args) {
        // Temps d'exécution avec un seul thread
        long startTime = System.nanoTime();
        long sum = sum(0, num);
        long endTime = System.nanoTime();
        System.out.println("La somme est " + sum + ". Temps avec un thread: " + (endTime - startTime) + " nanoseconds");

        // Temps d'exécution avec deux threads
        startTime = System.nanoTime();
        SumThread t1 = new SumThread(0, num / 2);
        SumThread t2 = new SumThread(num / 2, num);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = t1.getSum() + t2.getSum();
        endTime = System.nanoTime();
        System.out.println("La somme " + sum + ". Le temps avec deux threads: " + (endTime - startTime) + " nanoseconds");
    }

    public static long sum(long start, long end) {
        long sum = 0;
        for (long i = start; i < end; i++) {
            sum += i;
        }
        return sum;
    }
}
