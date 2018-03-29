package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The compute.Compute interface defines the remotely accessible part, the compute engine itself. 
 */
public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}