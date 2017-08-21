package net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;


public class NIOServer {
	private static class Handler{
		private int bufferSize = 1024;
		private String localCharset = "UTF-8";
		public Handler(){}
		public Handler(int bufferSize){
			this (bufferSize,null);
		}
		public Handler(String localCharset){
			this(-1,localCharset);
		}
		
		public Handler(int bufferSize , String localCharset){
			if(bufferSize > 0 )
				this.bufferSize = bufferSize;
			if(localCharset != null)
				this.localCharset =  localCharset;
		}
		
		public void handlerAccept(SelectionKey key) throws IOException{
			SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
			sc.configureBlocking(false);
			sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(bufferSize));
		}
		public void handlerRead(SelectionKey key) throws IOException{
			SocketChannel sc = (SocketChannel) key.channel();
			ByteBuffer buffer = (ByteBuffer) key.attachment();
			buffer.clear();
			if(sc.read(buffer) == -1){
				sc.close();
			}else{
				buffer.flip();
				String receivedStr = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
				System.out.println("received from client: " + receivedStr);
				
				String sendStr = "received data:" + receivedStr;
				buffer = ByteBuffer.wrap(sendStr.getBytes(localCharset));
				sc.write(buffer);
				sc.close();
				
				
				
			}
		}
	}
	public static void main(String[] args) throws Exception {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(8080));
		ssc.configureBlocking(false);
		
		Selector  selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		
		Handler handler = new Handler(1024);
		while(true){
			if(selector.select(3000) == 0){
				System.out.println("Time Out");
				continue;
			}
			System.out.println("Doing request");
			
			Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
			
			while(keyIter.hasNext()){
				SelectionKey key  = keyIter.next();
				try{
					if(key.isAcceptable()){
						handler.handlerAccept(key);
					}
					if(key.isReadable()){
						handler.handlerRead(key);
					}
				}catch(IOException ex){
					keyIter.remove();
					continue;
				}
				keyIter.remove();
			}
			}
		}
		
	}
	


