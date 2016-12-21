package ru.spbstu.telematics.java.Lab2_0;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class Lab2_TestCollection {
	
	//ArrayList
	@Test
	public void ALtestSize() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		assertTrue(list.size() == 2);
	}
	@Test
	public void ALtestContains() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		assertTrue(list.contains("a")&&list.contains("b"));
	}
	@Test
	public void ALtestAdd() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		assertTrue(list.contains("a")&&list.contains("b")&&list.size()==2);
	}
	@Test
	public void ALtestGet() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		assertTrue(list.get(0)=="a"&&list.get(1)=="b");
	}
	@Test
	public void ALtestRemove() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.remove("a");
		list.remove("b");
		assertTrue(!list.contains("a")&&!list.contains("b")&&list.size()==0);
	}
	
	//HeshSet
	@Test
	public void HStestSize() {
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		assertTrue(set.size() == 2);
	}
	@Test
	public void HStestContains() {
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		assertTrue(set.contains("a")&&set.contains("b"));
	}
	@Test
	public void HStestAdd() {
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		boolean check=set.add("b");
		assertTrue(set.contains("a")&&set.contains("b")&&set.size()==2&&!check);
	}
	@Test
	public void HStestGet() {
		ArrayList<String> set = new ArrayList<String>();
		set.add("a");
		set.add("b");
		assertTrue(set.get(0)=="a"&&set.get(1)=="b");
	}
	@Test
	public void HStestRemove() {
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.remove("a");
		set.remove("b");
		assertTrue(!set.contains("a")&&!set.contains("b")&&set.size()==0);
	}
	
	//HashMap
	@Test
	public void HMtestSize() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("a",1);
		map.put("b",2);
		assertTrue(map.size() == 2);
	}

	@Test
	public void HMtestPut() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("a",1);
		map.put("b",2);
		assertTrue(map.size() == 2&&map.containsValue(1)&&map.containsKey("a")&&map.containsValue(2)&&map.containsKey("b"));
	}
	
	@Test
	public void HMtestContains() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("a",1);
		map.put("b",2);
		assertTrue(map.size() == 2&&map.containsValue(1)&&map.containsKey("a")&&map.containsValue(2)&&map.containsKey("b"));
	}
	
	@Test
	public void HMtestGet() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("a",1);
		map.put("b",2);
		assertTrue(map.size() == 2&&map.get("a")==1&&map.get("b")==2);
	}
	
	@Test
	public void HMremoveGet() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("a",1);
		map.put("b",2);
		map.remove("a", 1);
		map.remove("b", 2);
		assertTrue(map.size() == 0);
	}
}
