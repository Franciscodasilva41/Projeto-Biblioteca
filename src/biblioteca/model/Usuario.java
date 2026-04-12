
package biblioteca.model;

public class Usuario {
    private String nome;
    private String telefone;
    private final int numCadastro;
    private static int contador = 1;
    
    public Usuario(String nome,String telefone){
     this.nome = nome;
     this.telefone = telefone;
     this.numCadastro = contador ++;
     
    }
    public Usuario(int id,String nome,String telefone){
     this.nome = nome;
     this.telefone = telefone;
     this.numCadastro = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone != null && ! telefone.isEmpty()){
        this.telefone = telefone;
        }else{
            System.out.println("Telefone invalido!");
        }
    }

    public int getNumCadastro() {
        return numCadastro;
    }
    public void atualizar(String nome, String telefone){
      this.nome = nome;
      this.telefone = telefone;
    }
   public static void setContador(int valor){
    contador = valor;
   }
    @Override
       public String toString(){
       return "=========== USUÁRIO ==========="+"\n"+
              "ID:"+numCadastro+"\n"+
              "Nome: "+nome+"\n"+
              "Telefone: "+telefone +"\n"+
              "===============================";
       }
    
}
