package clientserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmiimplementaion.RMIImplementation1;
import rmiinterface.RMIInterface;

public class ClientServer {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		
		
		ClientThread objectc = new ClientThread(args[0]); 
		ServerThread objects = new ServerThread(args[0]); 
		
		objects.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		objectc.start();
		
	
	}

}


class ClientThread extends Thread 
{ 
	String ar;
	public ClientThread(String a){
		this.ar=a;
	}
	
	
	
	public void run() 
	{ 
		int counter=0;float msg_comp=0;float time_comp=0;
		long start1=System.currentTimeMillis();
		while(System.currentTimeMillis() - start1 < 30000) {
		try
		{ 
			int server=(int)(1 + Math.random()*5);
			
			String x="s"+server;
			
			RMIInterface stub=(RMIInterface)Naming.lookup(x);  
			
			System.out.println(stub.Welcome(x));
			
			int ln=(int)(1+Math.random()*20);		
			String text="";
			for(int i=0;i<ln;++i) {
				text+="a";
			}
			
			String c;
			long start = System.currentTimeMillis();
			c=stub.echo(text);
			long end = System.currentTimeMillis();
			long elapsedTime = (end - start);
			counter++;
			msg_comp+=ln;

			time_comp+=elapsedTime/1000;
	
			
			System.out.println(c + " " + elapsedTime);
		

		} 
		catch (Exception e) 
		{ 
			// Throwing an exception 
			System.out.println ("Exception is caught client"); 
		} 
		}
		msg_comp/=counter;
		time_comp/=counter;
		System.out.println("");
		System.out.println("For server " + ar + "\nmessage complexity =  " + msg_comp+ "\ntime complexity =  "
										+ time_comp + "\nNumber of messages =  " + counter + "\n****************************");
		
		try {
			RMIInterface s=(RMIInterface)Naming.lookup("s1"); 
			System.out.println(s.compute(msg_comp, time_comp, counter));
			System.out.println("****************************");
			if(ar.equals("s5")) {
				for(int i=1; i<6; i++) {
					String ss="s"+i;
					RMIInterface s1=(RMIInterface)Naming.lookup(ss);	
					System.out.println(s1.returnecho(ar));
				}
			}
			
			
		}catch(Exception ex) {
			System.out.println ("Computer failed");
		}	
		
	} 
} 


class ServerThread extends Thread 
{ 
	String ar;
	public ServerThread(String a){
		this.ar=a;
	}
	public void run() 
	{ 
		try{  
			RMIInterface stub=new RMIImplementation1(); 
			String name = "//localhost/" + ar;
			System.setProperty("java.rmi.server.hostname", name);
			Naming.bind(name,stub);
			System.out.println("Server " + ar + " ready");
			}
		catch(Exception e){
			System.out.println(e);
			} 
	} 
} 
