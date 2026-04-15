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
import java.awt.event.*;

public class TelaMenu extends JFrame{
    
    private JButton btnLivro;
    private JButton btnUsuario;
    private JButton btnEmprestimo;
    
    public TelaMenu(){
    
        setTitle("Menu Principal");
        setSize(300, 200);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        btnLivro = new JButton("Cadastrar Livro");
        btnLivro.setBounds(50,20,200,30);
        add(btnLivro);
    
        btnUsuario = new JButton("Cadastrar Usuário");
        btnUsuario.setBounds(50,60,200,30);
        add(btnUsuario);
        
        btnEmprestimo = new JButton("Empréstimo");
        btnEmprestimo.setBounds(50,100,200,30);
        add(btnEmprestimo);
        
        //Ações dos botões
        btnLivro.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
        new TelaLivro().setVisible(true);
                }
        });
        btnUsuario.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
        new TelaUsuario().setVisible(true);
                 }
        });
        btnEmprestimo.addActionListener(new ActionListener(){
        
        public void actionPerformed(ActionEvent e){
            
        new TelaEmprestimo().setVisible(true);
                  }
        });
        
    }
    
}
