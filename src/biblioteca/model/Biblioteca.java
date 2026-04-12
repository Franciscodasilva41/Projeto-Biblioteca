
package biblioteca.model;
import biblioteca.dao.EmprestimoDAO;
import biblioteca.view.TelaLivro;
import biblioteca.dao.LivroDAO;
import biblioteca.dao.UsuarioDAO;
import biblioteca.model.Usuario;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Biblioteca {

    
    public static void main(String[] args) {
        
        EmprestimoDAO empDAO = new EmprestimoDAO();
        empDAO.listarEmprestimo();
        
       // SwingUtilities.invokeLater(()-> {
        //  TelaLivro tela = new TelaLivro(); });
        
        
                
      /* LivroDAO dao = new LivroDAO();
      UsuarioDAO dao = new UsuarioDAO();
       //Livro livro1 = new Livro("Java Basico", "Carlos", 2022);
       
      
       dao.listar();
       dao.inserir(livro1);
      // Livro livro2 = new Livro("Poo Avançado", "Maria",2021);
       dao.inserir(livro2);
        System.out.println("\n---------- LISTANDO LIVROS -------");
        dao.listar();*/
       
        
        
        
      /*System.out.println("Livros: "+ new java.io.File("livros.txt").getAbsolutePath());
      System.out.println("Usuarios: "+ new java.io.File("usuarios.txt").getAbsolutePath());
        Scanner sc = new Scanner(System.in);
        Emprestimo emp = new Emprestimo();
        emp.carregarLivros();
        emp.carregarUsuarios();
             int opcao;
            do{  
                try
                {
                 emp.mostarMenu();
                 
                 opcao = sc.nextInt();
                switch(opcao){
                    case 1:
                        sc.nextLine();
                        System.out.println("Digite titulo do livro: ");
                       String titulo = sc.nextLine();
                        System.out.println("Digite o autor do livro: ");
                       String autor = sc.nextLine();
                        System.out.println("Digite ano de publicação:");
                        int anoPublicacao = sc.nextInt();
                        emp.cadastrarLivro(new Livro(titulo,autor,anoPublicacao));
                        break;
                    case 2:
                        emp.listarLivros();
                        break;
                    case 3:
                        System.out.println("Digite o ID do livro para remover:");
                        int id = sc.nextInt();
                        emp.removerLivro(id);
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.println("Digite o nome: ");
                        String nome = sc.nextLine();
                        System.out.println("Digite o telefone:");
                        String telefone = sc.nextLine();
                        emp.cadastrarUsuario(new Usuario(nome,telefone));
                        break;
                    case 5:
                        emp.listarUsuarios();
                        break;
                    case 6:
                        sc.nextLine();
                        System.out.println("Digite o numero de cadastro:");
                        int idU = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite novo nome: ");
                        String no = sc.nextLine();
                        System.out.println("Digite novo telefone: ");
                        String tel = sc.nextLine();
                        emp.atualizarUsuario(idU,no, tel);
                        break;
                    case 7:
                        emp.listarUsuarios();
                        sc.nextLine();
                        System.out.println("Digite o numero de cadastro: ");
                        int idURem = sc.nextInt();
                        emp.excluirUsuario(idURem);
                        break;
                    case 8:
                        emp.listarLivros();
                        System.out.println("Digite o ID do livro:");
                        int idLi = sc.nextInt();
                        System.out.println("Digite o cadastro do usuario");
                        int idUEmp = sc.nextInt();
                        emp.emprestar(idLi, idUEmp);
                        
                        break;
                    case 9:
                        System.out.println("Digite o ID do livro para baixa ");
                        int idDev = sc.nextInt();
                        emp.devolver(idDev);
                        break;
                    case 0:
                        
                        emp.salvarLivros();
                        emp.salvarUsuarios(); 
                        System.out.println("Dados salvos ");
                        System.out.println("Fim da operação! "); 
                        break;
                    default:
                         System.out.println("Numero Invalido!");
                }
                
                } catch (Exception e){
                    System.out.println("Digite um numero valido! ");
                    sc.nextLine();
                    opcao = -1;
                }
            }while(opcao != 0);
        
        sc.close();
      */   
    }
   
}
