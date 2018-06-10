package threadprogramming;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bo
 */
public class ThreadProgramming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Laver en kø af integers FIFO. Er thread safe. 
        //De tal som skal udregnes som Fibernacci tal.
        //Er bound dvs kan ikke gemme uendelige mængder. Den skal have en limit.
        ArrayBlockingQueue<Integer> s1 = new ArrayBlockingQueue(12);

        //Tilføjer numre til s1
        int[] numbersToProducer = {42, 37, 36, 35, 34, 22, 21, 12, 8, 5, 4}; //{4, 5, 8, 12, 21, 22, 34, 35, 36, 37, 42};

        for (int i = 0; i < numbersToProducer.length; i++) {
            s1.add(numbersToProducer[i]);
        }

        //De udregnede Fibonacci tal. s2
        ArrayBlockingQueue<Integer> producedNumbers = new ArrayBlockingQueue(12);

        //Creates a thread pool that creates new threads as needed, 
        //but will reuse previously constructed threads when they are available.
        ExecutorService es = Executors.newCachedThreadPool();

        //Laver og starter de 4 producere. P1 til P4
        es.execute(new FibernacciProducer(s1, producedNumbers));
        es.execute(new FibernacciProducer(s1, producedNumbers));
        es.execute(new FibernacciProducer(s1, producedNumbers));
        es.execute(new FibernacciProducer(s1, producedNumbers));

        //Laver en consumer og starter den
        FibernacciConsumer consumer = new FibernacciConsumer(producedNumbers);
        es.execute(consumer);

        es.shutdown();

        try {
            es.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("Totalsummen er " + consumer.getTotalFibSum());
            System.out.println("Closing Down. Wait 10 secounds...");
        } catch (InterruptedException e) {
            System.out.println("Fejl ved closing down i main");
        }

    }

}
