import java.util.Scanner;

public class Menu{

	public static void solicitandoDatos(int[] datosUsuario){
		Scanner scan = new Scanner(System.in);
		try{
			System.out.println("Numero de hilos pintores:");
			datosUsuario[0] = scan.nextInt();
			System.out.println("Numero de hilos ensambladores:");
			datosUsuario[1] = scan.nextInt();
			System.out.println("Tiempo maximo de pintado:");
			datosUsuario[2] = scan.nextInt();
			System.out.println("Capacidad bodega:");
			datosUsuario[3] = scan.nextInt();
		}catch(Exception e){
			System.out.println("Ingrese unicamente numeros...");
		}
		if (datosUsuario[1] > datosUsuario[3]) {
			datosUsuario[1] = datosUsuario[3];
		}
	}
}