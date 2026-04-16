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
    JTextField txtId;
    
    JTable tabela;
    DefaultTableModel modelo;
    
    public TelaLivro(){
      
      setTitle("Cadastro de Livro");
      setSize(600,400);
      setLayout(null);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      txtId = new JTextField();
      txtId.setBounds(50,250,200,25);
      add(txtId);
      
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
      
      JLabel lblId = new JLabel("Digite o ID para excluir:");
      lblId.setBounds(80, 230, 200, 20);
      add(lblId);
      
      
      JButton btnSalvar = new JButton("Salvar");
      btnSalvar.setBounds(90,190,100,30);
      add(btnSalvar);
      
      JButton btnExcluir = new JButton("Excluir");
      btnExcluir.setBounds(90,280,100,30);
      add(btnExcluir);
      
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
       btnExcluir.addActionListener(e -> {  
           try{
      int id = Integer.parseInt(txtId.getText());
      int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir? ",
              "Confirmar",JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){   
           boolean sucesso = service.excluirLivro(id);
              
      if(sucesso){
      JOptionPane.showMessageDialog(null,"Livro excluido com sucesso!");
      carregarLivros();
      limparCampos();
      
      }else{
          JOptionPane.showMessageDialog(null, "Livro não encontrado");
      }
           } 
           }catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(null,"Digite um ID válido! ");
           }
    } );
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
