package RMI;
import java.rmi.*;
// import java.rmi.server.*;

// public class Search {/
   public interface Search extends Remote{
    public String query(String Search) throws RemoteException;
}
 

