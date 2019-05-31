package ctthyf.chatroom;

import java.io.IOException;
import java.net.DatagramSocket;


public class ChatRoom {
	public static void main(String[] args) throws IOException {
		DatagramSocket receiveds=new DatagramSocket(65512);
		DatagramSocket sendds=new DatagramSocket();
		
		ReceiveThread rt=new ReceiveThread(receiveds);
		SendThread st=new SendThread(sendds);
		
		
		Thread t1=new Thread(rt);
		Thread t2=new Thread(st);
		
		t1.start();
		t2.start();
	}
}
