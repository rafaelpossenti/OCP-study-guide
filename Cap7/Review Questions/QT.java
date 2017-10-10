import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class QT{
	
	private static void q3() throws Exception{
		/*
		ExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleWithFixedDelay(() -> { // w1 --does not compile
			System.out.println("Open Zoo");
			return null; // w2
		}, 0, 1, TimeUnit.MINUTES);
		Future<?> result = service.submit(() -> System.out.println("Wake Staff")); // w3
		System.out.println(result.get()); // w4
		*/
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleWithFixedDelay(() -> { // w1 --does not compile because it is assigned to an ExecutorService.
			System.out.println("Open Zoo");
			return; // --does not compile because scheduleWithFixedDelay()supports only Runnable(return void)
		}, 0, 1, TimeUnit.MINUTES);
		Future<?> result = service.submit(() -> System.out.println("Wake Staff")); // w3
		System.out.println(result.get()); // w4
	}			
			
	private static void q4(){
		AtomicLong value1 = new AtomicLong(0);
		final long[] value2 = {0};
		IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> value1.incrementAndGet()); //100
		IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> ++value2[0]); //undefined
		System.out.println(value1+" "+value2[0]);
	}
	
	
	private static void q7(){
		int count;
		List<Integer> l1 = Arrays.asList(1,2,3);
		List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
		Set<Integer>  s3 = new ConcurrentSkipListSet<>();
		s3.addAll(l1);
		/*The CopyOnWriteArrrayList class is designed to preserve the original list on iteration */
		for(Integer item: l2) l2.add(4); // x1
		
		/*he second loop executes exactly four times, since elements in a set are unique and 5 can be added only once.*/
		for(Integer item: s3) s3.add(5); // x2 
		
		System.out.println(l1.size()+" "+l2.size()+" "+s3.size()); //3 6 4  
		
		/**The ConcurrentSkipListSet class allows modifications while iterating,
			so the second loop above generate an infinite loop.
		count = 4;
		for(Integer item: s3){ count++; s3.add(count);} // x2
		*/
	}
	
	private static void q8(){
		Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get(); //1  
		synchronized(i1) { // y1
			Integer i2 = Arrays.asList(6,7,8,9,10)
				.parallelStream()
				.sorted() // y2
				.findAny().get(); // y3 can be anything, because is parallelStream()
			System.out.println(i1+" "+i2);
		}
	}
	
	
	private static void q10(){
		/* https://coderanch.com/t/671281/certification/Streams */
		/*
		<U> U reduce(U identity,
             BiFunction<U,? super T,U> accumulator,
             BinaryOperator<U> combiner)
		
		<U> U reduce(U identity,
			BiFunction<Integer,? super String, Integer> accumulator,
			BinaryOperator<U> combiner)
			
		*/	 
		/*
		System.out.println(Arrays.asList("duck","chicken","flamingo","pelican")
			.parallelStream().parallel() // q1 OK 
			.reduce(0,
				    (c1, c2) -> c1 /*.length() + c2.length(), // q2 
					(s1, s2) -> s1 + s2) ); // q3
		*/
					
		System.out.println(Arrays.asList("duck","chicken","flamingo","pelican")
			.parallelStream().parallel() // q1 OK 
			.reduce(0,(i1, s2) -> i1 + s2.length(),
			 Integer::sum));
	}
	
	public static void main(String...args) throws Exception{
		q10();
	}
}


