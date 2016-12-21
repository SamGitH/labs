package lab2.lab;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Lab4_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 6666);
		SocketChannel client = null;
		try {
			client = SocketChannel.open(crunchifyAddr);
		} catch (IOException e) {
			System.out.println("Connection ses");
			return;
		}
		
		
		//while (true) {
			
			byte[] message = new String("Hello biba!").getBytes();
			ByteBuffer bufferWrite = ByteBuffer.wrap(message);
			try {
				client.write(bufferWrite);
			} catch (IOException e) {
				e.printStackTrace();
			}

			ByteBuffer bufferRead = ByteBuffer.allocate(256);
			try {
				client.read(bufferRead);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String strRead = new String(bufferRead.array());
			System.out.println("got: " + strRead);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bufferWrite.clear();
			bufferRead.clear();
	}

}
