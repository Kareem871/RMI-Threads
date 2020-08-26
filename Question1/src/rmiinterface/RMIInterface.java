package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

	public String Welcome(String x) throws RemoteException;
	public String echo(String x) throws RemoteException;
	public String compute(float m, float t, int c) throws RemoteException;
	public String returnecho(String servername) throws RemoteException;
}

