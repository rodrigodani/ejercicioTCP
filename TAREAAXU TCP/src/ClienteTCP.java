import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteTCP {
	public static void main(String[] args) throws IOException{
		
		Socket socketCliente =null;
		BufferedReader entrada =null;
		PrintWriter salida =null;
		
		System.out.println("Cliente");
		try{
			socketCliente = new Socket("localhost",4673);
			entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);			
		}catch(Exception e){
			System.out.println(e);
		}
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("---Menu---");
			System.out.println("- opcion 1: papel");
			System.out.println("- opcion 2: piedra");
			System.out.println("- opcion 3: tijeras");
			while (true) {
				String cad = sc.readLine();
				if (cad.equals("salir")) {
					salida.println(cad);
					break;
				}
				salida.println(cad);
				cad =entrada.readLine();
				System.out.println("la respuesta del servidor es  "+ cad);
				
			}
		} catch (Exception e) {
		System.out.println(e);
		}
		
		salida.close();
		entrada.close();
		sc.close();
		socketCliente.close();
		
	}
}
