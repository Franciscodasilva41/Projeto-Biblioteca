/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.view;

/**
 *
 * @author Usuario
 */

import biblioteca.service.EmprestimoService;
import javax.swing.*;
import java.awt.event.*;
public class TelaEmprestimo extends JFrame { 
    
    private JTextField txtIdEmprestimo;
    private JTextField txtIdUsuario;
    private JTextField txtIdLivro;
    private JButton btnEmprestar;
    private JButton btnDevolver;
    
    public TelaEmprestimo(){
    
        setTitle("Emprestimo de Livro");
        setSize(300,250);
        setLayout(null);
        
        
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
        
        btnDevolver = new JButton("Ddevolver");
        btnDevolver.setBounds(150, 140, 100, 30);
        add(btnDevolver);
        //Ação emprestar
        
        btnEmprestar.addActionListener(e -> {
         try {
           int idUsuario = Integer.parseInt(txtIdUsuario.getText());
           int idLivro = Integer.parseInt(txtIdLivro.getText());
           
           EmprestimoService service = new EmprestimoService();
           
           service.emprestarLivro(idUsuario, idLivro);
           
           JOptionPane.showMessageDialog(null, "Emprestimo realizado!");
           txtIdUsuario.setText("");
           txtIdLivro.setText("");
         }catch (Exception ex){
         JOptionPane.showMessageDialog(null,ex.getMessage());
         }
        
        
        });
        
        
    
    
        btnDevolver.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
        int idLivro = Integer.parseInt(txtIdLivro.getText());
        int idEmprestimo = Integer.parseInt(txtIdEmprestimo.getText());
        EmprestimoService service = new EmprestimoService();
       
        service.devolverLivro(idEmprestimo, idLivro);
        
            System.out.println("Livro devolvido: "+ idLivro);
          JOptionPane.showMessageDialog(null, "Devolvido com sucesso !");
        }
        
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);    
    }



}
