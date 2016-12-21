package ru.spbstu.telematics.java.Lab2_0;

import java.util.ArrayList;
import java.util.Random;

class MyThread			
implements Runnable		
{
	int numberOfThread;
	int begin;
	int end;
	MyThread(int numberOfThread,int begin,int end){
		this.numberOfThread=numberOfThread;
		this.begin=begin;
		this.end=end;
	}
	public void run()		
	{
		long time = System.currentTimeMillis();
		for(int i=begin;i<end;i++)
		{
			Lab3_Thread.Matrix[i]=Lab3_Thread.rand.nextInt(2001)-1000;		

		}
		time=System.currentTimeMillis()-time;
		System.out.println(numberOfThread);
		System.out.println(time+"ms");
	}
}

public class Lab3_Thread {
	static int n=10;
	public static int Matrix []=new int[n*n];
	public static Random rand=new Random();

	public static void main(String[] args) throws InterruptedException {
		int Thread=7;
		int begin=0;
		int end=n*n/Thread;
		ArrayList<Thread> list= new ArrayList<Thread>();
		for(int i=0;i<Thread;i++){
			
			MyThread myThread = new MyThread(i+1, begin, end);
			Thread thread = new Thread(myThread);
			list.add(thread);
			thread.start();
			begin+=n*n/Thread;
			end+=n*n/Thread;
			if(i==Thread-2)
				end=n*n;
		}
		for(int i=0; i< Thread; i++)		
			list.get(i).join();	
		int check=n;
		for(int i=0;i<n*n;i++)
		{
			if(i==check){
				System.out.println();
				check+=n;
			}
			System.out.print(Matrix[i] + " ");
		}
	}


}