import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        
        int puerto = 8080;
        String servidor = "192.168.56.103";

        try{
            Calculadora calc = (Calculadora) Naming.lookup("rmi://" + servidor + ":" + puerto + "/Calculadora");
            while(true){
                String opt = JOptionPane.showInputDialog("Calcular\n" + 
                            "Suma......(1: x + y)\n" +
                            "Resta.....(2: x - y)\n" +
                            "Multi.....(3: x * y)\n" + 
                            "Divis......(4: x / y)\n"+
                            "Cancelar para salir");
                if(opt == null){
                    break;
                }
                int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese x"));
                int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese y"));

                switch(opt){
                    case "1":{
                        JOptionPane.showMessageDialog(null, a + "+" + b + "=" + calc.sum(a, b));
                        break;
                    }
                    case "2":{
                        JOptionPane.showMessageDialog(null, a + "-" + b + "=" + calc.res(a, b));
                        break;
                    }
                    case "3":{
                        JOptionPane.showMessageDialog(null, a + "*" + b + "=" + calc.mul(a, b));
                        break;
                    }
                    case "4":{
                        JOptionPane.showMessageDialog(null, a + "/" + b + "=" + calc.div(a, b));
                        break;
                    }
                }
            }
        }catch(RemoteException | NotBoundException ex){
            JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor:\n" + ex);
        }catch(MalformedURLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor:\n" + ex);
        }
    }
}
