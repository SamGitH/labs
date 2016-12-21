package lab2.lab;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.Iterator;

public class Lab4_Server {

	public static void main(String[] args) throws IOException {
		Selector selector = Selector.open();
		ServerSocketChannel serverSocket = ServerSocketChannel.open();
		InetSocketAddress serverAddr = new InetSocketAddress("localhost", 6666);
		serverSocket.bind(serverAddr);
		serverSocket.configureBlocking(false);

		int ops = serverSocket.validOps();
		SelectionKey selectKye = serverSocket.register(selector, ops, null);


		while(true){
			selector.select();
			Set<SelectionKey> clientsKeys = selector.selectedKeys();
			Iterator<SelectionKey> clientsIterator = clientsKeys.iterator();
			while (clientsIterator.hasNext()) {
				SelectionKey Key = clientsIterator.next();
				if(Key.isAcceptable()){
					SocketChannel clientSoket = serverSocket.accept();
					//try{
					clientSoket.configureBlocking(false);

					clientSoket.register(selector, SelectionKey.OP_READ);
					
					System.out.println("Connection Accepted: " + clientSoket.getRemoteAddress() + "\n");
					//} catch (Exception e){}
				}
				else if(Key.isReadable()){
					SocketChannel clientSoket = (SocketChannel) Key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(256);
					clientSoket.read(buffer);
					String result = new String(buffer.array()).trim();
					buffer.clear();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					clientSoket.read(buffer);
					String result1 = new String(buffer.array()).trim();
					System.out.println("Message received: " + result+result1);
					buffer.clear();
					buffer.wrap(new String("Hello biba!").getBytes());
					clientSoket.write(buffer);
					buffer.clear();
					clientSoket.close();
				}
				
				clientsIterator.remove();
			}
			
		}
	}

}

