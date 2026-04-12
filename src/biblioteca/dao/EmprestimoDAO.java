/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.dao;
import java.sql.*;
import biblioteca.database.Conexao;


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
     public void listarEmprestimo(){
       String sql = "SELECT * FROM emprestimo";
       
       try(Connection conn = Conexao.conectar();
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery()){
       
         while(rs.next()){
         int id = rs.getInt("id");
         int idUsuario = rs.getInt("id_usuario");
         int idLivro = rs.getInt("id_livro");
         Timestamp dataEmprestimo = rs.getTimestamp("data_emprestimo");
         Timestamp dataDevolucao = rs.getTimestamp("data_devolucao");
             System.out.println("ID: "+ id);
             System.out.println("Usuario: "+ idUsuario);
             System.out.println("Livro: "+ idLivro);
             System.out.println("Data Emprestimo: "+ dataEmprestimo);
             System.out.println("Data Devolução: "+ dataDevolucao);
             System.out.println("------------------------------------------");
             
         }
       }catch(SQLException e){
       e.printStackTrace();
       }
     }
}
