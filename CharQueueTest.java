import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class CharQueueTest {

	@Test
	void testConstructorDefault() {
		CharQueue queue = new CharQueue();
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
	}

	@Test
	void testConstructorWithCapacity() {
		CharQueue queue = new CharQueue(10);
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());

		assertThrows(IllegalArgumentException.class, () -> {
			CharQueue invalidQueue = new CharQueue(-1); // Test exception for negative capacity
		});
	}

	@Test
	void testEnqueueAndDequeue() {
		CharQueue queue = new CharQueue(2);
		queue.enqueue('A');
		assertFalse(queue.isEmpty());
		assertEquals(1, queue.size());
		assertEquals('A', queue.peek());

		queue.enqueue('B');
		assertEquals(2, queue.size());
		assertEquals('A', queue.dequeue()); // Dequeue 'A'

		assertEquals('B', queue.peek()); // Peek 'B'
		assertEquals('B', queue.dequeue()); // Dequeue 'B'
		assertTrue(queue.isEmpty());
	}

	@Test
	void testPeekAndDequeueEmptyQueue() {
		CharQueue queue = new CharQueue(1);
		NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> queue.peek());
		assertEquals("Queue is empty", thrown.getMessage());

		thrown = assertThrows(NoSuchElementException.class, () -> queue.dequeue());
		assertEquals("Queue is empty", thrown.getMessage());
	}

	@Test
	void testEnqueueWhenFull() {
		CharQueue queue = new CharQueue(1);
		queue.enqueue('A'); // Fill the queue

		assertThrows(IllegalStateException.class, () -> {
			queue.enqueue('B'); // Attempt to enqueue when full
		});
	}

}
