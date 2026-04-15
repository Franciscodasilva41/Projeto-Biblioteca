/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.dao;

import biblioteca.model.Usuario;
import biblioteca.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    
  public void inserir(Usuario u){
    String sql ="INSERT INTO usuario (nome, telefone) VALUES (?,?)";
    
      try{
         Connection conn = Conexao.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         
         ps.setString(1,u.getNome());
         ps.setString(2,u.getTelefone());
         ps.executeUpdate();
         
          System.out.println("Usuario salvo no banco!");
            ps.close();
            conn.close();
         
      } catch (Exception e){
          System.out.println("Erro ao inserir: "+ e.getMessage());
      }
  }
  
  public List<Usuario> listar(){
      List<Usuario> lista = new ArrayList<>();
  String sql = "SELECT * FROM usuario ";
  
  try{
    Connection conn = Conexao.conectar();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    
    while(rs.next()){
        Usuario u = new Usuario( rs.getString("nome"),rs.getString("telefone"));
        u.setNumCadastro(rs.getInt("id"));
        lista.add(u);
    }
    rs.close();
    st.close();
    conn.close();
  
  }catch (Exception e){
        e.printStackTrace();
  }
  return lista;
  }
  public void atualizar(Usuario u){
  
   String sql = "UPDATE usuario SET nome = ?, telefone = ? WHERE id = ?";
    try{
      Connection conn = Conexao.conectar();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1,u.getNome());
      ps.setString(2,u.getTelefone());
      ps.setInt(3,u.getNumCadastro());
      ps.executeUpdate();
      
        System.out.println("Usuario atualizado!");
        
        ps.close();
        conn.close();
    }catch(Exception e){
        System.out.println("Erro ao atualizar: " + e.getMessage());
    }
   
  }
  public void deletar(int id){
    String sql = "DELETE FROM usuario WHERE id = ?";
    
    try{
     Connection conn = Conexao.conectar();
     PreparedStatement ps = conn.prepareStatement(sql);
     ps.setInt(1, id);
     ps.executeUpdate();
        System.out.println("Usuario removido!");
        
        ps.close();
        conn.close();
     
    }catch(Exception e){
        System.out.println("Erro ao remover: "+ e.getMessage());
    }
  }
  
}
