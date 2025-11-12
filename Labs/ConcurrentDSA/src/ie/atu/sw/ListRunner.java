package ie.atu.sw;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ListRunner {

	private static final int MAX_THREADS = 10;
	private static final int MAX_ITERATIONS = 1000;
	
	public void go() throws Exception{
		//List Deceleration
		//Synced
		List<Integer> list = new CopyOnWriteArrayList<>();
		
		//Thread creation and Random var gen
		var threads = new Thread[MAX_THREADS];
		var rand = ThreadLocalRandom.current();
		
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for(int j = 0; j < MAX_ITERATIONS; j++) {
					list.add(rand.nextInt());
					
					//Multi-step operation must be synced
					synchronized (list) {
						//Check
						if(list.get(0) == 77) {
							//Act
							list.remove(0);
						}	
					}
				}
			});	
			threads[i].start();
		}
		
		//For each thread in threads
		for(var t : threads) {
			t.join();
		}
		
		System.out.println("Expected: " + (MAX_THREADS * MAX_ITERATIONS));
		System.out.println("Actual: " + list.size());
		System.out.println("Thread-Safe: " + (list.size() == (MAX_THREADS * MAX_ITERATIONS)));
		
	}
	
	public static void main(String[] args) throws Exception {
		new ListRunner().go(); 
	}
}
