/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.service;

/**
 *
 * @author Usuario
 */
import biblioteca.model.Usuario;
import biblioteca.dao.UsuarioDAO;
import java.util.List;
public class UsuarioService {
    
    private UsuarioDAO dao = new UsuarioDAO();
    
    public String cadastrarUsuario(String nome, String telefone){
        //Validação campo vazios
    if(nome.isEmpty()||telefone.isEmpty()){
      return "Preencha todos os campos";
    }
   Usuario user = new Usuario(nome,telefone);
   dao.inserir(user);
   
   return "Usuario salvo com sucesso!";
    }
    public List<Usuario> listar(){
    return new UsuarioDAO().listar();
    }
}
