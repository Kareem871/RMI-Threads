package rmiserver;

import java.rmi.*;

import rmiimplementaion.RMIImplementation1;
import rmiinterface.RMIInterface;

public class ServerOperation {
		public static void main(String[] args){
			try{  
				RMIInterface stub=new RMIImplementation1();  
				Naming.bind(args[0],stub); 
				System.err.println("Server "+args[0] +" ready");
				}
			catch(Exception e){
				System.out.println(e);
				} 
	}

}
///////////////////////////// done