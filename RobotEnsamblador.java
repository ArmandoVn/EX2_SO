import java.util.Arrays;

public class RobotEnsamblador extends Thread{
	private int piezasAEnsamblar, tipoID = -1, numRobotsPintores, codigorobot, contador=0, maximus;
	private RobotPintor[] robotsPintores;
	private Pieza [] p;


	/*
	La clase robot ensamblador funciona correctamente, unicamente si se tiene el mismo numeros
	de autos que de ensambladores.
	*/
	public RobotEnsamblador(int piezasAEnsamblar, int numRobotsPintores, RobotPintor[] a, int codigo, int maximobodega){
		this.piezasAEnsamblar = piezasAEnsamblar;
		this.numRobotsPintores = numRobotsPintores;
		this.robotsPintores = a;
		this.codigorobot = codigo;
		this.maximus = maximobodega;
		p = new Pieza [piezasAEnsamblar];
		setName("Robot ensamblador "+ codigo);

	}

	public void run(){
		while(true){
			ensamblarPiezas();
		}
	}

	public void ensamblarPiezas(){
		try{ 
			Nodo temp = new Nodo (Test.lineaDeEnsamblajeFinal.Borrar(getName()));
			String[] idtemp = temp.Getpieza().getId().split("(?<=\\D)(?=\\d)");
			int tempint = Integer.parseInt(idtemp[1]);
			if (tipoID == -1 && !Test.ensamblajeAux.Buscar(tempint))
			{	
				Test.ensamblajeAux.InsertarAlFinal(temp.Getpieza(), false, "");
				System.out.println("detectada nuevo tipo de pieza: " + tempint);
				tipoID = tempint;
			}
			if (tempint == tipoID)
			{
				p[contador] = temp.Getpieza();
				contador++;
				System.out.println("El robot ensamblador "+ codigorobot+ " está ensamblando la pieza "+temp.Getpieza().getId());
			}
			else
			{
				Test.lineaDeEnsamblajeFinal.InsertarAlFinal(temp.Getpieza(), false, "");
			}
			if (piezasAEnsamblar == contador)
			{
			String str = "A"+tipoID+"B"+tipoID+"C"+tipoID+"D"+tipoID;
			System.out.println("Termine de ensamblar las piezas con un id: "+str);
			ProductoFinal carrito = new ProductoFinal(p, tipoID);
			Test.bodega.InsertarAlFinal(carrito);
			this.tipoID = -1;
			contador = 0;
			p = new Pieza [piezasAEnsamblar];
			}
			if(Test.bodega.SizeCola() == maximus){
				System.out.println("Bodega llena, finalizando producción...");
				System.exit(0);
			}

		}
		catch(Exception e) {
		}	
	}

	public boolean comprobarHilos(){ 
		int contador = 0;
		int validador = 0;
		while(contador < numRobotsPintores){
			if (!robotsPintores[contador].isAlive()) {
				validador++;
			}
			contador++;
		}
		if (validador == numRobotsPintores) {
			return false;
		}
		return true;
	}
	

	public void listarPiezas(){
		for (Pieza pie : p) {
			System.out.println(pie.getId()+" ");
		}
	}
}