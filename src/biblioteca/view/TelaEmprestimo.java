/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.view;

/**
 *
 * @author Usuario
 */
import java.util.List;
import biblioteca.model.Emprestimo;
import biblioteca.service.EmprestimoService;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;
public class TelaEmprestimo extends JFrame { 
    
    private JTextField txtIdEmprestimo;
    private JTextField txtIdUsuario;
    private JTextField txtIdLivro;
    private JButton btnEmprestar;
    private JButton btnDevolver;
    
    JTable tabela;
    DefaultTableModel modelo;
    
    public TelaEmprestimo(){
    
        setTitle("Emprestimo de Livro");
        setSize(800,300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        JLabel lblEmprestimo = new JLabel("ID Emprestimo");
        lblEmprestimo.setBounds(10, 100,100, 25);
        add(lblEmprestimo);
        
        txtIdEmprestimo = new JTextField();
        txtIdEmprestimo.setBounds(120,100, 150, 25);
        add(txtIdEmprestimo);
        
        
        JLabel lblUsuario = new JLabel("ID Usuario: ");
        lblUsuario.setBounds(10, 20, 100, 25);
        add(lblUsuario);
        
        txtIdUsuario = new JTextField();
        txtIdUsuario.setBounds(120, 20, 150,25);
        add(txtIdUsuario);
        
        JLabel lblLivro = new JLabel("ID Livro");
        lblLivro.setBounds(10, 60, 100, 25);
        add(lblLivro);
        
        txtIdLivro = new JTextField();
        txtIdLivro.setBounds(120, 60,150, 25);
        add(txtIdLivro);
        
        btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBounds(30, 140, 100, 30);
        add(btnEmprestar);
        
        btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(150, 140, 100, 30);
        add(btnDevolver);
        
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("ID Usuario");
        modelo.addColumn("ID Livro");
        modelo.addColumn("Data Emprestimo");
        modelo.addColumn("Data Devoluçâo");
        
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(300, 20, 600, 300);
        add(scroll);
        //Ação emprestar
        
        btnEmprestar.addActionListener(e -> {
         try {
           int idUsuario = Integer.parseInt(txtIdUsuario.getText());
           int idLivro = Integer.parseInt(txtIdLivro.getText());
           
           EmprestimoService service = new EmprestimoService();
           
           service.emprestarLivro(idUsuario, idLivro);
           
           JOptionPane.showMessageDialog(null, "Emprestimo realizado!");
           carregarEmprestimo();
           limparCampos();
           
         }catch (Exception ex){
         JOptionPane.showMessageDialog(null,ex.getMessage());
         }
        
        
        });
        
        
    
    
        btnDevolver.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            try{
        int idLivro = Integer.parseInt(txtIdLivro.getText());
        int idEmprestimo = Integer.parseInt(txtIdEmprestimo.getText());
        EmprestimoService service = new EmprestimoService();
       
        service.devolverLivro(idEmprestimo, idLivro);
        
            System.out.println("Livro devolvido: "+ idLivro);
          JOptionPane.showMessageDialog(null, "Devolvido com sucesso !");
          carregarEmprestimo();
          limparCampos();
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Favor colocar ID do emprestimo");
            }
        }
       
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carregarEmprestimo();
         setVisible(true);    
    }


     public void carregarEmprestimo(){
       try{
       modelo.setRowCount(0);
       EmprestimoService service = new EmprestimoService();
       List<Emprestimo> lista = service.listar();
       
        for (Emprestimo emp : lista){
        modelo.addRow(new Object[]{
        emp.getId(),emp.getIdUsuario(),emp.getIdLivro(),emp.getDataEmprestimo(),emp.getDataDevolucao()
        
        });
        
        }
       
       }catch(Exception e){
       e.printStackTrace();
       }
     }
     
     public void limparCampos(){
           txtIdUsuario.setText("");
           txtIdLivro.setText("");
     }
}
