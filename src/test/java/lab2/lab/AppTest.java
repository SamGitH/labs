package lab2.lab;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class AppTest 
    
{
	File f1 = new File("1.txt");
	File f2 = new File("2.txt");
	File f3 = new File("3.txt");
	File f1new = new File("1new.txt");
	File f2new = new File("src/2new.txt");
	File f3new = new File("../3new.txt");

	
	@Before
	public void beforeTestMethod(){
		System.out.println("Before test: true, true, true." );
	}
	
	@After
	public void afterTestMethod() throws IOException {
		System.out.println("After test:" + f1new.exists()+" "+f2new.exists()+" "+f3new.exists());
	}
	
	@Test
	public void test1(){
		if(f1.exists())
		f1.renameTo(f1new);
		assertTrue(f1new.exists());
	}
	
	@Test
	public void test2(){
		
		if(f2.exists())
		f2.renameTo(f2new);
		assertTrue(f2new.exists());
	}
	
	@Test
	public void test3(){

		if(f3.exists())
		f3.renameTo(f3new);
		assertTrue(f3new.exists());

	}
}