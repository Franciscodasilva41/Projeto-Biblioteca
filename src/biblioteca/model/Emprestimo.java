

package biblioteca.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.Scanner;

public class Emprestimo {
    
    private ArrayList<Livro>listaLivro = new ArrayList();
    private  ArrayList<Usuario>listaUser = new ArrayList();
    int id;
    int idUsuario;
    int idLivro;
    Timestamp dataEmprestimo;
    Timestamp dataDevolucao;

   
    public Emprestimo(int idUsuario, int idLivro, Timestamp dataEmprestimo, Timestamp dataDevolucao ){
        
       this.idUsuario = idUsuario;
       this.idLivro = idLivro;
       this.dataEmprestimo = dataEmprestimo;
       this.dataDevolucao = dataDevolucao;
        
    }

    public Timestamp getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public Timestamp getDataDevolucao() {
        return this.dataDevolucao;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLivro() {
        return this.idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        
      return this.id;
    }
    public void mostarMenu(){
     System.out.println("======= Menu ========");
                System.out.println("     ");
                System.out.println("1 para cadastrar livro");
                System.out.println("2 para lista livro");
                System.out.println("3 para remover livro");
                System.out.println("4 para cadastrar usuario");
                System.out.println("5 para listar usuario");
                System.out.println("6 para atualizar usuario");
                System.out.println("7 para excluir usuario");
                System.out.println("8 emprestar livro ");
                System.out.println("9 devolver livro ");
                System.out.println("0 para salva ao sair ");
                System.out.println("       ");
    
    }
    
    public void cadastrarLivro(Livro livro){
       listaLivro.add(livro);
        System.out.println("Livro cadastrado!");
    }
    public void listarLivros(){
        System.out.println("======= Lista de Livros ====== ");
      for(Livro livro : listaLivro){
          System.out.println(livro);
          System.out.println("=============================");
      }
    }
    public void removerLivro(int id){
       Iterator<Livro> it = listaLivro.iterator();
        while(it.hasNext()){
            Livro livro = it.next();
       if(livro.getId()== id){
         it.remove();
           System.out.println("Livro removido! ");
           return;
       }
       }
           System.out.println("Livro não encontrado!");
       
       
    }
    public void cadastrarUsuario(Usuario user){
       listaUser.add(user);
        System.out.println("Usuario cadastrado!");
    }
    public void listarUsuarios(){
        System.out.println("======= Lista de usuarios ======");
     for(Usuario user : listaUser){
         System.out.println(user);
         System.out.println("================================");
     }
    }
    
    public Usuario buscarUser(int idU){
    for(Usuario user : listaUser){
           if(user.getNumCadastro()== idU){
            return user; 
           }
               }
            return null;            
    }
    public void atualizarUsuario(int idU,String nome, String telefone){
       Usuario user = buscarUser(idU);
               
       if(user != null){
        user.atualizar(nome, telefone);
           System.out.println("Usuario atualizada!");
       }else{
           System.out.println("Usuario não encontrado!");
       }
    }
    public void excluirUsuario(int idURem){
        Iterator<Usuario> it = listaUser.iterator();
    while(it.hasNext()){
         Usuario user = it.next();
       if(user.getNumCadastro() == idURem){
          it.remove();
           System.out.println("Usuario removido!");
           return;
       }
    }
           System.out.println("Usuario não encontrado ");
       
       
    }
    
    public void emprestar(int idLi, int idUEmp){
        
        Usuario user = buscarUser(idUEmp);
        if(user == null){
            System.out.println("Usuario não existe!");
            return;
        }
    for(Livro livro : listaLivro){
       if (livro.getId()== idLi){
           if(livro.isDisponivel()){
        livro.setDisponivel(false);
        livro.setIdUser(idUEmp);
               System.out.println("Livro Emprestado com Sucesso!");
        return;
       }else{
            System.out.println("Livro não disponivel"); 
            return;
               }
    }
    }
        System.out.println("Livro não encontrado");
    }
    public void devolver(int idDev){
    for(Livro livro : listaLivro){
      if(idDev == livro.getId()){
          if(livro.isDisponivel()){
              System.out.println("Livro já está disponivel");
              return;
          }
       livro.setDisponivel(true);
       livro.setIdUser(0);
          System.out.println(livro);
          System.out.println("Livro devolvido com sucesso!");
         return;
      }
    }
    
          System.out.println("Livro não encontrado para baixa no sistema");
    }
    public void salvarLivros(){
    try{
       PrintWriter pw = new PrintWriter(new FileWriter("livros.txt"));
          for(Livro l : listaLivro){
            pw.println(l.getId()+";"+l.getTitulo()+";"+l.getAutor()+";"+
                    l.getAnoPublicacao()+";"+l.isDisponivel()+";"+l.getIdUser());
          }
       pw.close();
        System.out.println("Livros salvos!");
    } catch(Exception e){
        System.out.println("Erro ao salvar livros ");
    }
    }
    public void carregarLivros(){
    
  try{
      File file = new File("livros.txt");
      
      if(!file.exists()) return;
         Scanner sc = new Scanner(file);
         int maiorId = 0;
         while(sc.hasNextLine()){
            String linha = sc.nextLine();
            String[] p = linha.split(";");
            String titulo = p[1];
            String autor = p[2];
            int ano = Integer.parseInt(p[3]);
            boolean disp = Boolean.parseBoolean(p[4]);
            int idUser = Integer.parseInt(p[5]);
            int id = Integer.parseInt(p[0]);
            Livro l = new Livro(titulo,autor,ano);
                      l.setDisponivel(disp);
                      l.setIdUser(idUser);
                      listaLivro.add(l);
                      if(id > maiorId){
                         maiorId = id;
                      }
         }
         Livro.setContador( maiorId + 1);
      sc.close();
  }  catch (Exception e){
        System.out.println("Erro ao carregar livros ");
  }
    
    }
    public void salvarUsuarios(){
     try{
       PrintWriter pw = new PrintWriter(new FileWriter("usuarios.txt"));
       for(Usuario u : listaUser){
         pw.println(u.getNumCadastro()+";"+u.getNome()+";"+u.getTelefone());
       }
       pw.close();
         System.out.println("Usuarios salvos!");
     }catch (Exception e){
         System.out.println("Erro ao salvar usuarios");
     }
    }
    public void carregarUsuarios(){
        
    try{
      File file = new File("usuarios.txt");
      
      if(!file.exists())return;
      Scanner sc = new Scanner(file);
      int maiorId = 0;
      while(sc.hasNextLine()){
       String linha = sc.nextLine();
       String[] p = linha.split(";");
       int id = Integer.parseInt(p[0]);
       String nome = p[1];
       String telefone = p[2];
       Usuario u = new Usuario(id,nome,telefone);
       listaUser.add(u);
      }
      Usuario.setContador(maiorId + 1);
      sc.close();
                }catch (Exception e){
            System.out.println("Erro ao carregar usuarios ");

    }
    }
    
    

}
    
    
    

