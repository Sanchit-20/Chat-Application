import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;



public class Server{
		public Server(int port) throws IOException
		{
			ServerSocket s1=new ServerSocket(port);
			System.out.println("Server Started !!");
			Socket ss=s1.accept();
			System.out.println("Client connected");
			Scanner sc=new Scanner(ss.getInputStream());
			Scanner scan=new Scanner(System.in);
			String num="",x="";

			while(!x.equals("end")){
			num=sc.nextLine();
			if(num.equals("end")){System.out.println("Client went offline");break;}
			System.out.println("Client : " + num);
			System.out.print("Server : ");
			x=scan.nextLine();
			PrintStream p=new PrintStream(ss.getOutputStream());
			p.println(x);
			}

			scan.close();
			s1.close();
			sc.close();
		}

		public static void main(String args[]) throws IOException
		{
			Server server =new Server(1342);
		}
}
