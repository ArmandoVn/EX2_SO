public class Robot extends Thread{
	int tiempo;
	int numPiezas;

	public Robot(String nombre, int tiempo, int numPiezas){
		setName(nombre);
		this.tiempo = tiempo;
		this.numPiezas = numPiezas;
	}

	public void run(){
		for (int i = 0 ; i < numPiezas ; i++ ) {
			GenerarPiezaA(i);
		}
	}

	public void GenerarPiezaA(int numPieza){
		Pieza pieza = new Pieza(getName()+numPieza,"Hola como estas","Adios xD");
		try{
			sleep(tiempo);
			System.out.println("El robot "+getName()+ " termino la pieza " + getName() + numPieza); //debe de ir dentro, pero no
			Test.lineaDePiezas.InsertarAlFinal(pieza, true, " ");
		}catch(Exception e){
			System.out.println("Algo salio mal...");
		}
	}
}