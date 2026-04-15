/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.dao;

/**
 *
 * @author Usuario
 */
import biblioteca.model.Livro;
import biblioteca.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    
  
    public void inserir(Livro l){
    String sql = "INSERT INTO livro (titulo, autor, ano_publicacao, disponivel) VALUES (?,?,?,?)";
    try(Connection conn = Conexao.conectar(); 
            PreparedStatement ps = conn.prepareStatement(sql)){
   
    ps.setString(1, l.getTitulo());
    ps.setString(2,l.getAutor());
    ps.setInt(3,l.getAnoPublicacao());
    ps.setBoolean(4, l.isDisponivel());
    ps.executeUpdate();
    
        System.out.println("Livro salvo no banco!");
    }catch(Exception e){
        System.out.println("Erro ao salva livro!"+e.getMessage());
    }
    
    }
    
    public List<Livro> listar(){
     List<Livro> lista = new ArrayList<>();  
    
     String sql = "SELECT * FROM livro";  
    try(
        Connection conn = Conexao.conectar();
          
        Statement st = conn.createStatement();   
        ResultSet rs = st.executeQuery(sql);){
       while(rs.next()){
         Livro l = new Livro(
        
     rs.getString("titulo"),
      rs.getString("autor"),
 rs.getInt("ano_publicacao")
  );
         l.setId(rs.getInt("id"));
         lista.add(l);
          
       }
       conn.close();
    }catch(Exception e){
            e.printStackTrace();
            }
     return lista;
    }
    
public void atualizar(Livro l){
    String sql = "UPDATE livro SET titulo = ?, autor = ?, ano_publicacao = ?, disponivel = ? WHERE id = ?";
    try{
    Connection conn = Conexao.conectar();
    PreparedStatement ps = conn.prepareStatement(sql);
    
    ps.setString(2,l.getTitulo());
    ps.setString(3,l.getAutor());
    ps.setInt(4,l.getAnoPublicacao());
    ps.setBoolean(5, l.isDisponivel());
    ps.setInt(1,l.getId());
    ps.executeUpdate();
        System.out.println("Livro Atualizado!");
        
        ps.close();
        conn.close();
    }catch(Exception e){
        System.out.println("Erro ao atualizar o livro"+ e.getMessage());
    }
    
}
}
