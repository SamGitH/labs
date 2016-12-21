package lab2.lab;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import lab2.lab.Lab2_LinkedList;;

public class Lab2_LinkedListTest {
	@Test
	public void testSize() {
		Lab2_LinkedList<String> list = new Lab2_LinkedList<String>();
		list.add("a");
		list.add("b");
		assertTrue(list.size() == 2);
	}
	@Test
	public void testContains() {
		Lab2_LinkedList<String> list = new Lab2_LinkedList<String>();
		list.add("a");
		list.add("b");
		assertTrue(list.contains("a")&&list.contains("b"));
	}
	@Test
	public void testAdd() {
		Lab2_LinkedList<String> list = new Lab2_LinkedList<String>();
		list.add("a");
		list.add("b");
		assertTrue(list.contains("a")&&list.contains("b")&&list.size()==2);
	}
	@Test
	public void testGet() {
		Lab2_LinkedList<String> list = new Lab2_LinkedList<String>();
		list.add("a");
		list.add("b");
		assertTrue(list.get(0)=="a"&&list.get(1)=="b");
	}
	@Test
	public void testRemove() {
		Lab2_LinkedList<String> list = new Lab2_LinkedList<String>();
		list.add("a");
		list.add("b");
		list.remove("a");
		list.remove("b");
		assertTrue(!list.contains("a")&&!list.contains("b")&&list.size()==0);
	}
}
