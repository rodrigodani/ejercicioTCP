import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
	public static void main(String[] args) throws IOException {
		ServerSocket socketServidor=null;
		Socket socketCliente =null;
		BufferedReader entrada =null;
		PrintWriter salida =null;
		System.out.println("Servidor");
		
		try {
			socketServidor = new ServerSocket(4673);
			
		} catch (Exception e) {
			
		}
		
		try {
			while(true){
				socketCliente = socketServidor.accept();
				
				entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);	
				while (true) {
					String cad = entrada.readLine();
					switch(cad) {
					  case "1":
						salida.println("papel");
					    break;
					  case "2":
						salida.println("piedra");
					    break;
					  case "3":
						salida.println("tijera");
						break;
					  case "salir":
						
						break;
						
					  default:
						salida.println("no existe esa opcion");
					}
					if (cad.equals("salir")) {
						break;
					}
				}
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		salida.close();
		entrada.close();
		socketServidor.close();
		socketCliente.close();
		
	}
}
