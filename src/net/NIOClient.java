package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		sc.connect(new InetSocketAddress("localhost", 8080));
		sc.configureBlocking(false);
		
		String request = "This is my Request";
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		
		while(!sc.finishConnect() ){
			sc.write(ByteBuffer.wrap(request.getBytes()));
			
		}
		while(true){
			buffer.clear();
			int read = sc.read(buffer);
			if(read > 0){
				buffer.flip();
				sc.close();
			}
		}
		
	}
}
