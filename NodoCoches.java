class NodoCoches {
   	private ProductoFinal coche;
	private NodoCoches siguiente;
	
	public NodoCoches (ProductoFinal num) {
		coche = num;
		siguiente = null;
	}

	public NodoCoches (ProductoFinal num, NodoCoches n) {
		coche = num;
		siguiente = n;
	}

	public ProductoFinal GetProductoFinal() {
		return coche;
	}
	
	public void Setcoche(ProductoFinal nvopieza) {
		coche= nvopieza;
	}

	public NodoCoches GetSiguiente() {
		return siguiente;
	}
	
	public void SetSiguiente(NodoCoches siguiente) {
		this.siguiente = siguiente;
	}
	 
}