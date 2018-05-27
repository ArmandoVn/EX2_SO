/*Ing. Patricia Del Valle Morales*/
class Cola {
   //ATRIBUTOS
   
   private Nodo H; 		   // H: referencia al primer elemento de la lista
   private Nodo T;         //T: referencia al ultimo elemento de la lista
   private int size = 0;
   private String nombreCola;

   public Cola(String namae){
      H = T = null;
      this.nombreCola = namae;
   }
  
   //METODOS PUBLICOS
   //_________________
	
   public boolean ListaVacia() {
      return H == null;
   }
  
    // Anadir un elemento al final de la lista

   public synchronized void InsertarAlFinal(Pieza num, boolean flag, String mess){
      Nodo q = new Nodo(num, null);
      if (T == null)
         H=T=q;
      else{
         T.SetSiguiente(q);
         T=q;
      }
      if (!nombreCola.equals(" ") && flag)
      {
         System.out.println(mess);
         System.out.println(nombreCola + " : ");
         this.Listar();
      }
      notifyAll();
   }

	//Borra un nodo de la lista
	
   public synchronized Pieza Borrar(String name) {
      while(this.ListaVacia()){
         try{ wait(); }
         catch(Exception e){}
      }
      Nodo aux = H;
      if (H==null){}
      else if (H == T)
         H=T=null;
      else 
         H = H.GetSiguiente();
      if (!this.ListaVacia())
      {
         System.out.println(nombreCola + " desde hilo "+ name +": ");
         this.Listar();
         notifyAll(); 
      }

      return aux.Getpieza();
   }


   /*public synchronized Pieza Ensamblar(String idPieza){
      Nodo aux = H;
      while(aux != null){
         if (aux.Getpieza().getId().equals(idPieza)) {
            return aux.Getpieza();
         }
         aux = aux.GetSiguiente();
      }
      return null;
   } */
		

   public int SizeCola()
   {
      return this.size;
   }
   
   public synchronized Nodo getHead()
   {
      return this.H;
   }

   public synchronized boolean Buscar (int idtype)
   {
      Nodo dummy = this.H;
      while (dummy != null)
      {
         String[] temp = dummy.Getpieza().getId().split("(?<=\\D)(?=\\d)");
         if (Integer.parseInt(temp[1]) == idtype)
            return true;
         dummy = dummy.GetSiguiente();
      }
      return false;
   }

	//Despliega todos los nodo de la lista
   public synchronized void Listar(){
      if (ListaVacia()) {
         System.out.print("   La cola esta vacia");
      }
      // Recorrer la lista
      Nodo q = H; // referencia al primer elemento
      while (q != null){
         System.out.print(q.Getpieza().getId() + " -> ");
         q = q.GetSiguiente() ;
      }
      System.out.println("\n");
   }
}