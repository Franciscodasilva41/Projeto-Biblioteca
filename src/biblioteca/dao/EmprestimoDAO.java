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
}
