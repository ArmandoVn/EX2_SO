public class RobotPintor extends Thread{
	private int tiempoPintar;
	private Robot[] robotsGeneradores;
	private String[] colores = {"Verde", "Rojo", "Azul", "Violeta", "Rosa", "Naranja", "Amarillo", "Blanco", "Negro", "Cromo", "Ultramar"};

	public RobotPintor(int tiempoPintar, Robot[] robotsGeneradores, int numero){
		this.tiempoPintar = tiempoPintar;
		this.robotsGeneradores = robotsGeneradores;
		setName("Robot pintor "+numero);

	}

	public void run(){
		while (true)
		pintarPieza();
	}

	public void pintarPieza(){
		try{
			Pieza p = Test.lineaDePiezas.Borrar(getName());
			sleep((int)(Math.random()*tiempoPintar)+1);
			String[] idtemp = p.getId().split("(?<=\\D)(?=\\d)");
			p.setColor(colores[(Integer.parseInt(idtemp[1])) % 11]);
				String message = getName() + " he terminado de pintar la pieza "+p.getId();
			Test.lineaDeEnsamblajeFinal.InsertarAlFinal(p, true, message);
		}catch(Exception e){
			//Preguntar porque...
			//System.out.println("Algo salio mal...");
		}
	}

	public boolean comprobarHilos(){
		int contador = 0;
		int validador = 0;
		while(contador < 4){
			if (!robotsGeneradores[contador].isAlive()) {
				validador++;
			}
			contador++;
		}
		if (validador == 4) {
			return false;
		}
		return true;
	}
}