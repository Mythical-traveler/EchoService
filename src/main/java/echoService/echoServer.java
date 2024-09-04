package echoService;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class echoServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(3000);
        DatagramPacket request=new DatagramPacket(new byte[1024],1024);
        while(true){
            socket.receive(request);
            InetAddress clientIp=request.getAddress();
            int clientPort=request.getPort();
            byte[]payload= Arrays.copyOf(request.getData(),request.getLength());
            String clientMessage=new String(payload);
            System.out.println("Client Message: "+clientMessage);
            String replyMessage=clientMessage.toUpperCase();
            DatagramPacket reply=new DatagramPacket(
                    replyMessage.getBytes(),replyMessage.getBytes().length,clientIp,clientPort
            );
            socket.send(reply);
        }
    }
}
