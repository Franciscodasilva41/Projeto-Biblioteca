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
import java.awt.*;
import java.util.List;
import biblioteca.service.UsuarioService;
import biblioteca.model.Usuario;
import biblioteca.dao.UsuarioDAO;

public class TelaUsuario extends JFrame{
    
    
    JTextField txtNome;
    JTextField txtTelefone;
    
    JTable tabela;
    DefaultTableModel modelo;
    public TelaUsuario(){
    
    setTitle("Cadastro Usuario");
    setSize(600,400);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    txtNome = new JTextField();
    txtNome.setBounds(50,20,200,25);
    add(txtNome);
    
    txtTelefone = new JTextField();
    txtTelefone.setBounds(50,60,200,25);
    add(txtTelefone);
    
    JLabel lblNome = new JLabel("Nome: ");
    lblNome.setBounds(50, 0,100, 20);
    add(lblNome);
    
    JLabel lblTelefone = new JLabel("Telefone: ");
    lblTelefone.setBounds(50,40,100,20);
    add(lblTelefone);
    
    JButton btnSalvar = new JButton("Salvar");
    btnSalvar.setBounds(80, 140,120, 30);
    add(btnSalvar);
    modelo = new DefaultTableModel();
    modelo.addColumn("ID");
    modelo.addColumn("Nome");
    modelo.addColumn("Telefone");
    
    tabela = new JTable(modelo);
    JScrollPane scroll = new JScrollPane(tabela);
    scroll.setBounds(300, 20, 300, 250);
    add(scroll);
    
    
    UsuarioService service = new UsuarioService();
    
    btnSalvar.addActionListener(e -> {
        try{
     String mensagem = service.cadastrarUsuario(txtNome.getText(), txtTelefone.getText());
     if(txtNome.getText().trim().isEmpty()){
    JOptionPane.showMessageDialog(null, "Digite o nome!");
    return;
}
     JOptionPane.showMessageDialog(null, mensagem);
         carregarUsuarios();
         limparCampos();
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,ex.getMessage());
        }
     
    });
    carregarUsuarios();
    setVisible(true);
    }
    public void limparCampos(){
        txtNome.setText("");
        txtTelefone.setText("");
    
    }
    public void carregarUsuarios(){
        
    try{
    modelo.setRowCount(0);
    UsuarioService service = new UsuarioService();
     
     List<Usuario> lista = service.listar();
    
    for(Usuario u : lista){
    modelo.addRow(new Object[]{
    u.getNumCadastro(),u.getNome(),u.getTelefone()
    });
    }
    
    }catch(Exception e){
    e.printStackTrace();
    }
    
    }
}
