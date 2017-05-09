package kienzler;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class QueueTest {

	Queue testque;
		
	@Before
	public void testQueueValid() {
		try{
			testque = new Queue(3);
		}catch(Exception e){
			fail("Argument zu klein");
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testQueue() {
		new Queue(-1);
		fail("Argument zu klein");
	}
	
	

	@Test
	public final void testEnqueueNoOverwrite() {
		testque.enqueue(1);
		assertEquals("Value notright", 1 , testque.dequeue());
		
		testque.enqueue(1);
		testque.enqueue(2);
		testque.enqueue(3);
		assertEquals("Value notright", 1 , testque.dequeue());
		assertEquals("Value notright", 2 , testque.dequeue());
		
		testque.enqueue(4);
		testque.enqueue(5);
		assertEquals("Value notright", 3 , testque.dequeue());
		assertEquals("Value notright", 4 , testque.dequeue());
	}
	
	@Test
	public final void testEnqueueOverwrite() {
		testque.enqueue(1);
		testque.enqueue(2);
		testque.enqueue(3);
		testque.enqueue(4);
		assertEquals("Value notright", 1 , testque.dequeue());
		assertEquals("Value notright", 2 , testque.dequeue());
		assertEquals("Value notright", 4 , testque.dequeue());
	}

	@Test(expected = IllegalStateException.class)
	public void testEmptyDequeue() {
		testque.dequeue();
		fail("Queueu nicht leer");
		
	}

}
