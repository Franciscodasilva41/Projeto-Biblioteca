/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.dao;
import java.sql.*;

import biblioteca.database.Conexao;
import java.util.ArrayList;
import java.util.List;
import biblioteca.model.Emprestimo;


/**
 *
 * @author Usuario
 */
public class EmprestimoDAO {
    
     public void emprestar(int idUsuario, int idLivro) {
        String verificar = "SELECT disponivel FROM livro WHERE id = ?";
        String inserir = "INSERT INTO emprestimo (id_usuario, id_livro, data_emprestimo) VALUES (?, ?, CURDATE())";
        String atualizar = "UPDATE livro SET disponivel = false WHERE id = ?";

        try (Connection conn = Conexao.conectar()) {

            // Verifica se livro está disponível
            PreparedStatement stmtVerifica = conn.prepareStatement(verificar);
            stmtVerifica.setInt(1, idLivro);
            ResultSet rs = stmtVerifica.executeQuery();

            if (rs.next() && rs.getBoolean("disponivel")) {

                // Registrar empréstimo
                PreparedStatement stmtInsert = conn.prepareStatement(inserir);
                stmtInsert.setInt(1, idUsuario);
                stmtInsert.setInt(2, idLivro);
                stmtInsert.executeUpdate();

                // Atualizar disponibilidade
                PreparedStatement stmtUpdate = conn.prepareStatement(atualizar);
                stmtUpdate.setInt(1, idLivro);
                stmtUpdate.executeUpdate();

                System.out.println("Empréstimo realizado!");

            } else {
                System.out.println("Livro indisponível!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void devolver(int idEmprestimo, int idLivro){
        
      String sqlEmprestimo = "UPDATE emprestimo SET data_devolucao = NOW()WHERE id = ?";
       String sqlLivro = "UPDATE livro SET disponivel = true WHERE id = ?";
       
       try(Connection conn = Conexao.conectar()){
        conn.setAutoCommit(false);// transação
        PreparedStatement stmt1 = conn.prepareStatement(sqlEmprestimo);
        stmt1.setInt(1,idEmprestimo);
        stmt1.executeUpdate();
        
        PreparedStatement stmt2 = conn.prepareStatement(sqlLivro);
        stmt2.setInt(1, idLivro);
        stmt2.executeUpdate();
          conn.commit();
           System.out.println("Devolução realizada com sucesso!");
        
       }catch (SQLException e){
       e.printStackTrace();
       }
     }
     public List<Emprestimo> listarEmprestimo(){
         List<Emprestimo> lista = new ArrayList<>();
         
       String sql = "SELECT * FROM emprestimo";
       
       try(Connection conn = Conexao.conectar();
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery()){
       
         while(rs.next()){
             Emprestimo emp = new Emprestimo(
        
         rs.getInt("id_usuario"),
         rs.getInt("id_livro"),
        rs.getTimestamp("data_emprestimo"),
         rs.getTimestamp("data_devolucao")
             );
           emp.setId(rs.getInt("id")); 
           lista.add(emp);
         }
         conn.close();
       }catch(SQLException e){
       e.printStackTrace();
       }
       return lista;
     }

    public boolean livroJaEmprestado(int idLivro) {
        String sql = "SELECT COUNT(*)FROM emprestimo WHERE id_Livro = ? AND data_devolucao IS NULL";
        try(Connection conn = Conexao.conectar()){
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idLivro);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
          return rs.getInt(1)> 0;
        }
        }catch(Exception e){
        e.printStackTrace();
        }
        return false;
    }
}
