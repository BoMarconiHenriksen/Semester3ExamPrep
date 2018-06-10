package threadslockingandvisibility;

import java.util.ArrayList;

/**
 *
 * @author Bo
 */
public class ConcurrentStack<T> {
    private final ArrayList<T> stack;
    private int size;

    public ConcurrentStack() {
        size = 0;
        stack = new ArrayList<T>(size);
    }

    public void add(T e) {
        synchronized (stack) {
            stack.add(e);
            size++;
        }
    }

    public T remove() {
        synchronized (stack.get(size - 1)) {
            if (size > 0) {
                return stack.remove(--size);
            } else {
                return null;
            }
        }
    }

    public T peek() {
        synchronized (this) {
            if (size > 0) {
                int lastIndex = size - 1;
                return stack.get(lastIndex);
            } else {
                return null;
            }
        }
    }

    //Example usage of ConcurrentStack
    public static void main(String[] args) {
        ConcurrentStack<Integer> stack = new ConcurrentStack<>();
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }
        for (int i = 0; i < 10; i++) {
            if (stack.peek() != null) {
                System.out.println(stack.remove());
            }
        }
    }
}

//Opg. 1. What data may be changed or only read by diffrent threads?
    //size.
    //arrayList - (Objektet).
    //Værdierne i arrayListen bliver bare taget ind og ud.

//Opg. 2A: Er det et problem, at der ikke låses på det samme objekt? 
    //Er det nok at de låser inde fra klassen og inden fra arrayListen?

	//Skal låse på samme objekt.
	//Synkronisering beskytter ikke mod adgang til elementerne i arrayList. 
        //Når vi ikke ændrer elementerne, men bare flytter dem ind og ud er det fint bare at synkroniserer på arrayListen.

//Opg. 2B: Kan peek metoden gøres volatile? Skal den overhovedet synkroniseres.
	
//Ja, den skal synkroniseres kan ikke nøjes med at bruge volatile. Ellers kan der opstår racing condition.
//Synkronisering på objektet da der ikke er beregninger.

//Peek læser kun
//lastIndex = Size-1
//return stack.get(lastIndex)

//tråd 1 	s = size
	//s= s -1
	//e = stack.get(s)
	//return e

//Noget der ødelægger i forbindelse med ovenstående
	//tråd 2
	//remove – size
	//s = læser size
	//s = s -1
	
//peek læser først og den anden tråd fjerner size → index out of bounce

//Til eksamen fint: problemer fordi vi læser og skriver på delt data. Hvis vi kun læser er der ikke noget problem.
    
 //BlockingQue methods:
// https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html
// http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html
