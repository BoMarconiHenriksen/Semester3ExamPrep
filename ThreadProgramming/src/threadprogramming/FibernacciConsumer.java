package threadprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bo
 */
//For at kunne bruge klassen som tråd implemter vi den som Runnable
public class FibernacciConsumer implements Runnable {
    int totalFibSum;
    List<Integer> fibernacciNumbers = new ArrayList();
    ArrayBlockingQueue<Integer> producedNumbers;
    //Volatile læser værdier fra main memory, og ikke fra cached data, hvorimod variabler, der er synkroniseret bliver cached.
    private volatile boolean moreNumbersToConsume = true;

    public FibernacciConsumer(ArrayBlockingQueue<Integer> producedNumbers) {
        this.producedNumbers = producedNumbers;
    }

    @Override
    public void run() {
        Integer fibNumber;

        while (moreNumbersToConsume) {
            try {
                //Stopper programmet for tidligt så ændre timeouten
                fibNumber = producedNumbers.poll(10, TimeUnit.SECONDS);//Venter 10 sekunder, hvis køen er tom.
                if (fibNumber != null) {
                    System.out.println("Fibernacci number is: " + fibNumber);
                    totalFibSum += fibNumber;
                    //System.out.println("Totalsummen er " + totalFibSum);//Hvis der skal printes subtotal
                } else {
                    moreNumbersToConsume = false;
                }
            } catch (InterruptedException e) {
                System.out.println("Fejl i consumer!");
            }
        }
    }

    public int getTotalFibSum() {
        return totalFibSum;
    }
    
}
