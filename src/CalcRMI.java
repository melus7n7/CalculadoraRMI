import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcRMI extends UnicastRemoteObject implements Calculadora {

    protected CalcRMI() throws RemoteException{
        super();
    }
    @Override
    public int div(int a, int b) throws RemoteException {
        System.out.println("Ejecutando div");
        if(b == 0) return 0;
        return a/b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        System.out.println("Ejecutando mul");
        return a*b;
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        System.out.println("Ejecutando sum");
        return a+b;
    }

    @Override
    public int res(int a, int b) throws RemoteException {
        System.out.println("Ejecutando res");
        return a-b;
    }
    
}
