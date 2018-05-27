

/*Ing. Patricia Del Valle Morales*/
class ColaAutos {
   //ATRIBUTOS
   
   private NodoCoches H; 		   // H: referencia al primer elemento de la lista
   private NodoCoches T;         //T: referencia al �ltimo elemento de la lista
   private int size = 0;
   private String nombreCola;
   
   public ColaAutos(String namae){
      H = T = null;
      this.nombreCola = namae;
   }
  
   //M�TODOS PUBLICOS
   //_________________
	
   public boolean ListaVacia() {
      return H == null;
   }
  
    // A�adir un elemento al final de la lista

   public synchronized void InsertarAlFinal(ProductoFinal num){
      NodoCoches q = new NodoCoches(num, null);
      if (T == null)
         H=T=q;
      else{
         T.SetSiguiente(q);
         T=q;
      }
      if (!nombreCola.equals(" "))
      {
         System.out.println(nombreCola + " : ");
         this.Listar();
      }
      notifyAll();
   }
   
   public int SizeCola()
   {
	   return this.size;
   }
   
	//Borra un NodoCoches de la lista
	

   public synchronized ProductoFinal Borrar(String name) {
      while(this.ListaVacia()){
         try{ wait(); }
         catch(Exception e){}
      }
      NodoCoches aux = H;
      if (H==null){}
      else if (H == T)
         H=T=null;
      else 
         H = H.GetSiguiente();
      System.out.println(nombreCola + " desde hilo "+ name +": ");
      this.Listar();
      notifyAll();
      return aux.GetProductoFinal();
   }

   public synchronized NodoCoches getHead()
   {
	   return this.H;
   }
		
		
	//Despliega todos los NodoCoches de la lista
   public void Listar(){
      if (ListaVacia()) {
         System.out.println("La cola esta vacia");
      }
      // Recorrer la lista
      NodoCoches q = H; // referencia al primer elemento
      while (q != null){
         System.out.print(q.GetProductoFinal().getId() + " -> ");
         q = q.GetSiguiente() ;
      }
      System.out.println("\n");
   }
}
