public class Test{
	public static Cola lineaDePiezas = new Cola("Linea de piezas");
	public static Cola lineaDeEnsamblajeFinal = new Cola("Linea de ensamblaje final");
	public static ColaAutos bodega = new ColaAutos("Bodega");
	public static Cola ensamblajeAux = new Cola(" ");

	public static void main(String[] args) {
		int datosUsuario[] = new int[4];
		int contador = 0;
		/*
		Cada dato del arreglo tiene asignado:
		[0] numHilosPintores;
		[1] numHilosEnsambladores;
		[2] tiempoPintado;
		[3] capacidadBodega;
		*/
		Menu.solicitandoDatos(datosUsuario);
		Robot[] robotsGeneradores = new Robot[4];
		RobotPintor[] robotsPintores = new RobotPintor[datosUsuario[0]];
		RobotEnsamblador[] robotsEnsambladores = new RobotEnsamblador[datosUsuario[1]];

		robotsGeneradores[0] = new Robot("A",1000,datosUsuario[3]);
		robotsGeneradores[1] = new Robot("B",1200,datosUsuario[3]);
		robotsGeneradores[2] = new Robot("C",900,datosUsuario[3]);
		robotsGeneradores[3] = new Robot("D",1100,datosUsuario[3]);

		for (int i = 0; i < 4; i++) {
			robotsGeneradores[i].start();
		}

		for (int i = 0; i < datosUsuario[0] ; i++) {
			robotsPintores[i] = new RobotPintor(datosUsuario[2], robotsGeneradores, i);
		}

		for (int i = 0; i < datosUsuario[0] ; i++) {
			robotsPintores[i].start();
		}

		for (int i = 0; i < datosUsuario[1] ; i++) {
		   robotsEnsambladores[i] = new RobotEnsamblador(4, datosUsuario[0], robotsPintores, i, datosUsuario[3]);
		}

		for (int i = 0; i < datosUsuario[1] ; i++) {
			robotsEnsambladores[i].start();
		}
		
		/*for (int i = 0; i < datosUsuario[0]; i++) {
			try{
				robotsPintores[i].join();
			}catch(Exception e){
				System.out.println("Algo fallo");
			}
		}*/
 	}
}