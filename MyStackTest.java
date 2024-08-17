import org.junit.jupiter.api.*;
import utilities.FullStackException;
import java.util.EmptyStackException;
import  org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;

class MyStackTest {

	@Test
	void testConstructorWithCapacity() {
		MyStack stack = new MyStack(5);
		assertEquals(5, stack.capacity());
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	@Test
	void testConstructorWithInvalidCapacity() {
		assertThrows(IllegalArgumentException.class, () -> new MyStack(0));
		assertThrows(IllegalArgumentException.class, () -> new MyStack(-1));
	}

	@Test
	void testDefaultConstructor() {
		MyStack stack = new MyStack();
		assertEquals(10, stack.capacity());
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	@Test
	void testIsEmpty() {
		MyStack stack = new MyStack(3);
		assertTrue(stack.isEmpty());
		stack.push("A");
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	void testClear() {
		MyStack stack = new MyStack(3);
		stack.push("A");
		stack.push("B");
		stack.clear();
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}

	@Test
	void testSize() {
		MyStack stack = new MyStack(5);
		assertEquals(0, stack.size());
		stack.push("A");
		assertEquals(1, stack.size());
		stack.push("B");
		assertEquals(2, stack.size());
		stack.pop();
		assertEquals(1, stack.size());
	}

	@Test
	void testCapacity() {
		MyStack stack1 = new MyStack(3);
		assertEquals(3, stack1.capacity());
		MyStack stack2 = new MyStack(100);
		assertEquals(100, stack2.capacity());
	}

	@Test
	void testPeek() {
		MyStack stack = new MyStack(3);
		stack.push("A");
		stack.push("B");
		assertEquals("B", stack.peek());
		assertEquals(2, stack.size());
	}

	@Test
	void testPeekEmptyStack() {
		MyStack stack = new MyStack(3);
		assertThrows(EmptyStackException.class, stack::peek);
	}

	@Test
	void testPush() {
		MyStack stack = new MyStack(3);
		stack.push("A");
		assertEquals("A", stack.peek());
		stack.push("B");
		assertEquals("B", stack.peek());
	}

	@Test
	void testPushFullStack() {
		MyStack stack = new MyStack(2);
		stack.push("A");
		stack.push("B");
		assertThrows(FullStackException.class, () -> stack.push("C"));
	}

	@Test
	void testPushNull() {
		MyStack stack = new MyStack(3);
		assertThrows(IllegalArgumentException.class, () -> stack.push(null));
	}

	@Test
	void testPop() {
		MyStack stack = new MyStack(3);
		stack.push("A");
		stack.push("B");
		assertEquals("B", stack.pop());
		assertEquals("A", stack.pop());
		assertTrue(stack.isEmpty());
	}

	@Test
	void testPopEmptyStack() {
		MyStack stack = new MyStack(3);
		assertThrows(EmptyStackException.class, stack::pop);
	}

	@Test
	void testMultiPush() {
		MyStack stack = new MyStack(5);
		String[] elements = {"A", "B", "C"};
		stack.multiPush(elements);
		assertEquals(3, stack.size());
		assertEquals("C", stack.pop());
		assertEquals("B", stack.pop());
		assertEquals("A", stack.pop());
	}

	@Test
	void testMultiPushNull() {
		MyStack stack = new MyStack(3);
		assertThrows(IllegalArgumentException.class, () -> stack.multiPush(null));
	}

	@Test
	void testMultiPushExceedingCapacity() {
		MyStack stack = new MyStack(2);
		String[] elements = {"A", "B", "C"};
		assertThrows(FullStackException.class, () -> stack.multiPush(elements));
	}

	@Test
	void testMultiPop() {
		MyStack stack = new MyStack(5);
		stack.push("A");
		stack.push("B");
		stack.push("C");
		String[] popped = stack.multiPop(2);
		assertArrayEquals(new String[]{"C", "B"}, popped);
		assertEquals(1, stack.size());
		assertEquals("A", stack.peek());
	}

	@Test
	void testMultiPopInvalidAmount() {
		MyStack stack = new MyStack(3);
		assertThrows(IllegalArgumentException.class, () -> stack.multiPop(0));
		assertThrows(IllegalArgumentException.class, () -> stack.multiPop(-1));
	}

	@Test
	void testMultiPopMoreThanSize() {
		MyStack stack = new MyStack(3);
		stack.push("A");
		stack.push("B");
		String[] popped = stack.multiPop(3);
		assertArrayEquals(new String[]{"B", "A"}, popped);
		assertTrue(stack.isEmpty());
	}

	@Test
	void testComplexOperations() {
		MyStack stack = new MyStack(5);
		stack.push("A");
		stack.push("B");
		stack.pop();
		stack.push("C");
		stack.push("D");
		assertEquals("D", stack.peek());
		assertEquals(3, stack.size());
		stack.clear();
		assertTrue(stack.isEmpty());
		stack.multiPush(new String[]{"X", "Y", "Z"});
		assertEquals("Z", stack.pop());
		assertEquals(2, stack.size());
	}

}
