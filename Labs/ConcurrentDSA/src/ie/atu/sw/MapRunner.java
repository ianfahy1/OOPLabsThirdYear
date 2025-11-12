package ie.atu.sw;

import java.util.*;
import java.util.concurrent.*;

public class MapRunner {

	private static final int MAX_THREADS = 10;
	private static final int MAX_ITERATIONS = 1000;

	//Lost Update. Multiple concurrent updates in memory, keep overwriting each other
	//Read, Modify, Write operation
	public void lostUpdate() throws Exception {
	
		//Create map (Doesn't work as we are not doing an atomic operation)
		//Map<String, Integer> map = new HashMap<>();
		//Map<String, Integer> map = new TreeMap<>();
		
		//Work on atomic state of operation
		//Map<String, Integer> map = new ConcurrentSkipListMap<>();
		//Map<String, Integer> map = new ConcurrentHashMap<>();
		Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
		
		
		//Add counter
		map.put("counter", 0);
		
		var threads = new Thread[MAX_THREADS];

		for (int i = 0; i < threads.length; i++) {
			
			//Placing value of i lambda variable on idx so it can be read
			int idx = i;
			threads[i] = new Thread(() -> {

				for(int j = 0; j < MAX_ITERATIONS; j++) {
					//read-modify-write
					//Get counter
					Integer current = map.get("counter");
					//Increment counter
					//Done to make the operation atomic
					map.compute("counter", (k, v) -> v + 1);
				}
			});

			threads[i].start();
		}

		// For each thread in threads
		for (var t : threads) {
			t.join();
		}
		
		int actual = map.get("counter");
		
		System.out.println("Expected: " + (MAX_THREADS * MAX_ITERATIONS));
		System.out.println("Actual: " + actual);
		System.out.println("Lost Updates: " + ((MAX_THREADS * MAX_ITERATIONS) - actual));
	}
	
	
	public void go() throws Exception {

		//DONT USE HASH OR TREE MAP WITH MULTIPLE THREADS
		//Synced map
		//Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
		
		//Tree Map
		//Map<Integer, String> map = new TreeMap<>();
		
		//Concurrent HashMap. Allows atomic level access to different methods
		//Map<Integer, String> map = new ConcurrentHashMap<>();
		
		//Concurrent Sorted Map
		Map<Integer, String> map = new ConcurrentSkipListMap<>();
		
		
		var threads = new Thread[MAX_THREADS];

		for (int i = 0; i < threads.length; i++) {
			
			//Placing value of i lambda variable on idx so it can be read
			int idx = i;
			threads[i] = new Thread(() -> {

				for(int j = 0; j < MAX_ITERATIONS; j++) {
					int k = j % 100;
					map.put(k, idx + "-value-" + j);
				}
			});

			threads[i].start();
		}

		// For each thread in threads
		for (var t : threads) {
			t.join();
		}
		
		System.out.println("Expected: " + 100);
		System.out.println("Actual: " + map.size());
		
	}

	public static void main(String[] args) throws Exception {
		//new MapRunner().go();
		new MapRunner().lostUpdate();
	}
}
