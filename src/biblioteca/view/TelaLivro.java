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
import javax.swing.table.DefaultTableModel;
import biblioteca.model.Livro;
import java.awt.*;
import java.util.List;
import biblioteca.service.LivroService;
import biblioteca.dao.LivroDAO;

public class TelaLivro extends JFrame {
    
    JTextField txtTitulo;
    JTextField txtAutor;
    JTextField txtAno;
    
    JTable tabela;
    DefaultTableModel modelo;
    
    public TelaLivro(){
      
      setTitle("Cadastro de Livro");
      setSize(600,400);
      setLayout(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      txtTitulo = new JTextField();
      txtTitulo.setBounds(50,30,200,25);
      add(txtTitulo);
      
      txtAutor = new JTextField();
      txtAutor.setBounds(50,90,200,25);
      add(txtAutor);
      
      txtAno = new JTextField();
      txtAno.setBounds(50,150,200,25);
      add(txtAno);
      
      JLabel lblTitulo = new JLabel("Titulo: ");
      lblTitulo.setBounds(50,0,100,20);
      add(lblTitulo);
      
      JLabel lblAutor = new JLabel("Autor: ");
      lblAutor.setBounds(50,60,100,20);
      add(lblAutor);
      
      JLabel lblAno = new JLabel("Ano: ");
      lblAno.setBounds(50,120,100,20);
      add(lblAno);
      
      JButton btnSalvar = new JButton("Salvar");
      btnSalvar.setBounds(60,200,100,30);
      add(btnSalvar);
      
      modelo = new DefaultTableModel();
      modelo.addColumn("ID");
      modelo.addColumn("Título");
      modelo.addColumn("Ano");
      
      tabela = new JTable(modelo);
      JScrollPane scroll = new JScrollPane(tabela);
      scroll.setBounds(300, 20, 300, 300);
      add(scroll);
      
       LivroService service = new LivroService(); 
       
      btnSalvar.addActionListener(e -> {
      String mensagem = service.cadastrarLivros(txtTitulo.getText(), 
              txtAutor.getText(),txtAno.getText());
      
      JOptionPane.showMessageDialog(null,mensagem);
      carregarLivros();
     limparCampos();
     
       });
      carregarLivros();
      setVisible(true);
    }
    public void limparCampos(){
        
    txtTitulo.setText("");
    txtAutor.setText("");
    txtAno.setText("");
    
    }
    public void carregarLivros(){
    try{
    modelo.setRowCount(0);
       LivroService service = new LivroService();
       List<Livro> lista = service.listar();
        for(Livro l : lista){
        modelo.addRow(new Object[]{
        l.getId(),l.getTitulo(),l.getAutor(),l.getAnoPublicacao()
         });
        }
    }catch(Exception e){
     e.printStackTrace();
    }
    }
}
