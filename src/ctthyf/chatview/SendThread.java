package ctthyf.chatview;



import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendThread extends Thread {
	private DatagramSocket ds=null;
        private DatagramPacket dp=null;
        String ip=null;
        String sendtext=null;
	public SendThread(String sendtext,String ip) {
		this.ip=ip;
                this.sendtext=sendtext;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
                    ds=new DatagramSocket();
                    
		//封装录入数据
		dp=new DatagramPacket(sendtext.getBytes(), sendtext.getBytes().length, InetAddress.getByName(ip), 65511);
		//发送数据
		ds.send(dp);
		//释放资源
		ds.close(); 	
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}
