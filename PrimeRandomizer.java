package challenge1;


import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PrimeRandomizer {

		    public static void main(String[] args) {
	        Randomizer ran = new Randomizer();
	        Queue<Value> outVal = new Prime().primeCheck(ran.randomGenerate());
	        System.out.println(outVal);
	    }

	    private static class Value implements Comparable<Value> {

	        int val;
	        boolean isPrime;

	        public Value(int val, boolean isPrime) {
	            this.val = val;
	            this.isPrime = isPrime;
	        }

	        @Override
	        public int compareTo(Value o) {
	            if (o == null) {
	                return 1;
	            }
	            return this.val - o.val;
	        }

	        @Override
	        public String toString() {
	            return "{" + "value=" + val + ", isPrime=" + isPrime + '}';
	        }
	    }

	    private static class Prime {

	        Queue<Value> primeVal = new PriorityQueue<>();

	        public Queue<Value> primeCheck(Queue<Integer> q) {
	            boolean prime;
	            Iterator<Integer> itr = q.iterator();
	            while (itr.hasNext()) {
	                Value val;
	                int item = (int) itr.next();
	                int srt = (int) Math.sqrt((double) item);
	                if (item == 1) {
	                    prime = true;
	                } else {
	                    prime = true;
	                    for (int i = 2; i <= srt; i++) {

	                        if (item % i == 0) {
	                            prime = false;
	                        }
	                    }
	                }
	                val = new Value(item, prime);

	                primeVal.add(val);

	            }
	            return primeVal;
	        }
	    }

	    private static class Randomizer {

	        public Queue<Integer> randomGenerate() {
	            Queue<Integer> q = new PriorityQueue<>();
	            int num;
	            Random rand = new Random();
	            for (int k = 0; k < 10; k++) {
	                num = rand.nextInt(100);
	                q.add(num);
	            }
	            return q;
	        }
	    }
	}