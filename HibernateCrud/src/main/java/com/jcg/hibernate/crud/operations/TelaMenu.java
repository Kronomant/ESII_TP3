package com.jcg.hibernate.crud.operations;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.WindowAdapter;
import java.util.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenu extends JFrame implements ActionListener {

    private JPanel contentPane;
    private ButtonGroup bt = new ButtonGroup();

    private JButton btnAnimais;
    private JButton btnAlimentos;
    private JButton btnProdutos;

    public TelaMenu() {
        setTitle("Menu  de Opções");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPesquisar = new JLabel("Escolha a tela de cadastro que deseja:");

        btnAnimais = new JButton("Cadastrar Animais");
        btnAnimais.setBounds(20, 40, 200, 23);
        btnAnimais.addActionListener(this);
        btnAnimais.setActionCommand("Cadastrar Animais");
        contentPane.add(btnAnimais);

        btnAlimentos = new JButton("Cadastrar Alimentos");
        btnAlimentos.setBounds(300, 40, 200, 23);
        btnAlimentos.setText("Cadastrar Alimentos");
        btnAlimentos.addActionListener(this);
        btnAlimentos.setActionCommand("Cadastrar Alimentos");
        contentPane.add(btnAlimentos);

        btnProdutos = new JButton("Cadastrar Produtos");
        btnProdutos.setBounds(560, 40, 200, 23);
        btnProdutos.setText("Cadastrar Produtos");
        btnProdutos.addActionListener(this);
        btnProdutos.setActionCommand("Cadastrar Produtos");
        contentPane.add(btnProdutos);

    }

    public void actionPerformed(ActionEvent e) {
        TelaAlimento telaAlimento = new TelaAlimento();
        TelaAnimal telaAnimal = new TelaAnimal();
        TelaProduto telaProduto = new TelaProduto();

        if (e.getActionCommand().equals(this.btnAlimentos.getActionCommand())) {

            telaAlimento.setVisible(true);

        } else if (e.getActionCommand().equals(this.btnAnimais.getActionCommand())) {

            telaAnimal.setVisible(true);

        } else if (e.getActionCommand().equals(this.btnProdutos.getActionCommand())) {

            telaProduto.setVisible(true);

        }

    }
}
