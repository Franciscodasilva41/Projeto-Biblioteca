
package biblioteca.model;


public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private static int contador = 1;
    private int id;

    public void setId(int id) {
        this.id = id;
    }
    private int idUser = 0;
    private boolean disponivel;

   
    
    public int getIdUser(){
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    public Livro(String titulo,String autor, int anoPublicacao){
     this.titulo = titulo;
     this.autor = autor;
     this.anoPublicacao = anoPublicacao;
     this.disponivel = true;
     

    }
    public Livro(int id, String titulo, String autor, int anoPublicacao){
    this.titulo = titulo;
     this.autor = autor;
     this.anoPublicacao = anoPublicacao;
    
     
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getId() {
        return id;
    }
   
 public static void setContador(int valor){
         contador = valor;
 }
    @Override
      public String toString(){
        return
                "=============== Livro ================"+"\n"+
                "ID:"+this.id+" Titulo: "+this.titulo+"\n"+
                "Autor: " +autor+"\n"+
                "Ano publicação: "+anoPublicacao+"\n"+
                "Status : "+(disponivel?"Disponivel":"Indisponivel")+"\n"+
                "Numero do usuario que emprestou: "+idUser+"\n"+
                 "=============================================" ;      
      }
}
