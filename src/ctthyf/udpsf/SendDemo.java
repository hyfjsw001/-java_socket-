package ctthyf.udpsf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//创建发送端socket对象
		DatagramSocket ds=new DatagramSocket(65500);
		//封装键盘录入数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=br.readLine())!=null) {
			if("exit".equals(line)) {
				break;
			}
			//创建一个发送数据包
			byte[] bys=line.getBytes();
			
			DatagramPacket dp=new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.123.97"), 65511);
			//发送数据
			ds.send(dp);
		}
		
		//释放资源
		ds.close();
	}
}
