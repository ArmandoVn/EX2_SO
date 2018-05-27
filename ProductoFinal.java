public class ProductoFinal{
	public Pieza[] piezas = new Pieza[4];
	public int id;

	public ProductoFinal(Pieza[] piezas, int id){
		this.piezas = piezas;
		this.id = id;
	}

	public int getId()
	{
		return this.id;
	}
}