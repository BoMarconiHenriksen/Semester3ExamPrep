
package threadprogramming;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Bo
 */
public class FibernacciProducer implements Runnable {
    BlockingQueue<Integer> numbersToUse;
    BlockingQueue<Integer> producedNumbers;
    //Volatile læser værdier fra main memory, og ikke fra cached data, hvorimod variabler, der er synkroniseret bliver cached.
    private volatile boolean moreNumbersToFetch = true;

    public FibernacciProducer(BlockingQueue<Integer> numbersToUse, BlockingQueue<Integer> producedNumbers) {
        this.numbersToUse = numbersToUse;
        this.producedNumbers = producedNumbers;
    }

    @Override
    public void run() {

        while (moreNumbersToFetch) {

            try {
                Integer number = numbersToUse.poll();//poll returner null, hvis køen er tom.

                if (number == null) {
                    moreNumbersToFetch = false;
                } else {
                    long fibNumber = fib(number);
                    //Skal castes til Integer
                    Integer fibInt = (int) (long) fibNumber;
                    producedNumbers.put(fibInt); //put hvis der ikke er plads til flere tal, så venter den indtil der er.
                }
            } catch (InterruptedException e) {
                System.out.println("Fejl i producer run metoden!");
            }
        }

    }

    //Metoden er ikke synkroniseret, da det ikke har betydning
    //for resultatet om n ændrer sig mellem tråde. 
    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    
}
