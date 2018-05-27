public class Pieza{
	private String id;
	private String color;
	private String descripcion;

	public Pieza(String id, String color, String descripcion){
		this.id = id;
		this.color = color;
		this.descripcion = descripcion;
	}

	public String getId(){return id;}
	public String getColor(){return color;}
	public String getDescripcion(){return descripcion;}

	public void setId(String id){ this.id = id;}
	public void setColor(String color){ this.color = color;}
	public void setDescripcion(String descripcion){ this.descripcion = descripcion;}
}