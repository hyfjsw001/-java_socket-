package ctthyf.udpsf;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		//创建端口socket对象
		DatagramSocket ds=new DatagramSocket(65511);
		while(true) {
		//创建一个接收数据包
		byte[] bys=new byte[1024];
		DatagramPacket dp=new DatagramPacket(bys, bys.length);
		//接收数据
		ds.receive(dp);
		//解析数据
		String ip =dp.getAddress().getHostAddress();
		String s=new String(dp.getData(),0,dp.getLength());
		
		System.out.println("from"+ip+":"+s);
		
		//释放资源
		//ds.close();  //服务器不关闭
		}
		
	}
}
