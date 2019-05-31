package ctthyf.chatview;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveThread  {
	private DatagramSocket ds=null;
	private DatagramPacket dp=null;
	
	public void run() {
		// TODO Auto-generated method stub
		try {
		
                    ds=new DatagramSocket(65511);
                 
			//创建一个数据包
			byte[] bys=new byte[1024];
			 dp=new DatagramPacket(bys, bys.length);
			//接收数据
			ds.receive(dp);
			//解析数据
//			String ip =dp.getAddress().getHostAddress();
			String s=new String(dp.getData(),0,dp.getLength());
			ChatView.received=s;

			
                       
			//释放资源
			//ds.close();  //服务器不关闭
               
	}catch(IOException e) {
		e.printStackTrace();
	}finally{
                    if(ds!=null){
                        ds.close();
                    }
                }
	}
}
