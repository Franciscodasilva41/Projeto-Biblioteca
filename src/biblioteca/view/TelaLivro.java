/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.view;

/**
 *
 * @author Usuario
 */
import javax.swing.*;
import biblioteca.model.Livro;
import biblioteca.service.LivroService;
import biblioteca.dao.LivroDAO;

public class TelaLivro extends JFrame {
    
    JTextField txtTitulo;
    JTextField txtAutor;
    JTextField txtAno;
    
    public TelaLivro(){
      
      setTitle("Cadastro de Livro");
      setSize(300,250);
      setLayout(null);
      
      txtTitulo = new JTextField();
      txtTitulo.setBounds(50,20,200,25);
      add(txtTitulo);
      
      txtAutor = new JTextField();
      txtAutor.setBounds(50,60,200,25);
      add(txtAutor);
      
      txtAno = new JTextField();
      txtAno.setBounds(50,100,200,25);
      add(txtAno);
      
      JLabel lblTitulo = new JLabel("Titulo: ");
      lblTitulo.setBounds(50,0,100,20);
      add(lblTitulo);
      
      JLabel lblAutor = new JLabel("Autor: ");
      lblAutor.setBounds(50,40,100,20);
      add(lblAutor);
      
      JLabel lblAno = new JLabel("Ano: ");
      lblAno.setBounds(50,80,100,20);
      add(lblAno);
      
      JButton btnSalvar = new JButton("Salvar");
      btnSalvar.setBounds(80,140,120,30);
      add(btnSalvar);
      
       LivroService service = new LivroService(); 
       
      btnSalvar.addActionListener(e -> {
      String mensagem = service.cadastrarLivros(txtTitulo.getText(), 
              txtAutor.getText(),txtAno.getText());
      JOptionPane.showMessageDialog(null,mensagem);
       });
      setVisible(true);
    }
    
}
