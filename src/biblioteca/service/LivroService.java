/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.service;

/**
 *
 * @author Usuario
 */
import biblioteca.dao.LivroDAO;
import biblioteca.model.Livro;
import java.util.List;

public class LivroService {
    private LivroDAO dao = new LivroDAO();
    
    public String cadastrarLivros(String titulo, String autor,String anoTexto){
       // validação campos vazios
    if(titulo.isEmpty()|| autor.isEmpty()|| anoTexto.isEmpty()){
        return "Preencha todos os campos!";
    }
    // Validação numero inteiro
    int ano;
    try{
    ano = Integer.parseInt(anoTexto);
    }catch (NumberFormatException e){
    return "Ano deve ser número! ";
    }
    // regra de negocio
    if(ano < 1500 || ano > 2026){
     return "Ano invalido!";
    }
   Livro livro = new Livro(titulo, autor, ano);
   dao.inserir(livro);

   return "Livro salvo com sucesso! ";
    
    }
    
     public List<Livro> listar(){
       return new LivroDAO().listar();
     }
     
    public boolean excluirLivro(int id){
    if(id <= 0){
        throw new IllegalArgumentException("ID Inválido! ");
        
    }
    return dao.excluir(id);
    }
    
    }
    

