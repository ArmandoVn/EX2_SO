class Nodo {
   	private Pieza pieza;
	private Nodo siguiente;
	
	public Nodo (Pieza num) {
		pieza = num;
		siguiente = null;
	}

	public Nodo (Pieza num, Nodo n) {
		pieza = num;
		siguiente = n;
	}

	public Pieza Getpieza() {
		return pieza;
	}
	
	public void Setpieza(Pieza nvopieza) {
		pieza= nvopieza;
	}

	public Nodo GetSiguiente() {
		return siguiente;
	}
	
	public void SetSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	 
}