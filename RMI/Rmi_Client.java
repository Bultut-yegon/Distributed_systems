package RMI;
import java.rmi.*;
import java.rmi.server.*;
public class Rmi_Client extends UnicastRemoteObject implements Search{
    Rmi_Client() throws RemoteException{
        super();
    }
    public String query(String Search) throws RemoteException{
        String result;
        if(Search.equals("Reflection of the java code"))
            result="Found it already";
        else
            result="Not found";
        return result;
    }
}
