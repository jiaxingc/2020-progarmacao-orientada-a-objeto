public abstract class Animal {  //aminal 抽象类
    
    float peso;
    int idade;
    int membros;
  
   public float getpeso(){
     return peso;
   }
   
   public int getidade(){
     return idade;
   }
   
   public int getmembros(){
     return membros;
   }
    public void setpeso(float peso) {
        this.peso = peso;
    }
     public void setidade(int idade) {
        this.idade = idade;
    }
     public void setmembros(int membros) {
        this.membros = membros;
    }
   public void locomover(){
     System.out.println("nao definido");
   }
    
   public  void alimentar(){
     System.out.println("nao definido");
   }
  
   public void emitirSom(){
    System.out.println("nao definido");
}

}
