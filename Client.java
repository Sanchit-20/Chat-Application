import java.io.*;
import java.util.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client{
	
	public Client(String address,int port) throws UnknownHostException, IOException
	{
		String n,receive="";
		Socket s = new Socket(address,port);
		Scanner sc1=new Scanner(s.getInputStream());
		Scanner sc=new Scanner(System.in);

		while(!receive.equals("end")){
		System.out.print("Client : ");
		n=sc.nextLine();
		PrintStream p=new PrintStream(s.getOutputStream());
		p.println(n);
		if(n.equals("end"))break;
		receive=sc1.nextLine();
		if(receive.equals("end")){System.out.println("Server went offline");break;}
		System.out.println("Server : "+ receive);
		}
		sc.close();
		s.close();
		sc1.close();
	}
	
	public static void main(String args[]) throws UnknownHostException, IOException 
	{
		Client client =new Client("10.250.7.18",1342);
	}
}
