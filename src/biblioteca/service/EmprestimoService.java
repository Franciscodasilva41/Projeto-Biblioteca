/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.service;

/**
 *
 * @author Usuario
 */
import biblioteca.dao.EmprestimoDAO;
import biblioteca.model.Emprestimo;
import java.util.List;
public class EmprestimoService {
    
    private EmprestimoDAO dao = new EmprestimoDAO();
    
    public void emprestarLivro(int idUsuario, int idLivro){
    //Regra de negocio
    if(dao.livroJaEmprestado(idLivro)){
     throw new RuntimeException("Livro já esta emprestado! ");
    }
    dao.emprestar(idUsuario, idLivro);
    }
    public void devolverLivro(int idEmprestimo, int idLivro){
    dao.devolver(idEmprestimo, idLivro);
    }
    public List<Emprestimo> listar(){
     return new EmprestimoDAO().listarEmprestimo();
    }
}
