package rmiimplementaion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmiinterface.RMIInterface;

public class RMIImplementation1 extends UnicastRemoteObject implements RMIInterface{
	private static final long serialVersionUID = 1L;
	public RMIImplementation1() throws RemoteException {
		super();
	}
	
	
	@Override
	public String Welcome(String x) throws RemoteException {
		return "*********************************\r\n" + 
				"*				*\r\n" + 
				"*     Welcome To The Server "+x+"	*\r\n" + 
				"*				*\r\n" + 
				"*********************************";
	}
	int echoc=0;
	@Override
	public String echo(String x) throws RemoteException {
		int mn=(int)(1+Math.random()*5000);
		try {
			Thread.sleep(mn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		echoc++;
		return x;
	}
	float mc;int cc;float tc;int servers=0;
	@Override
	public String compute(float m, float t, int c) throws RemoteException {
		
		mc+=m;
		tc+=t;
		cc+=c;
		servers++;
		if(servers==5) {
			return comp();
		}
		return "* There is more servers still working *";
	}
	public String comp() throws RemoteException{
	 return "message complexity = " + mc/5 + "\ntime complexity = " + tc/5 + "\nNumber of messages = " + cc;
	}


	@Override
	public String returnecho(String servername) throws RemoteException {
		return "No. of requests" + servername + "I received : " + echoc;
	}
	
}
