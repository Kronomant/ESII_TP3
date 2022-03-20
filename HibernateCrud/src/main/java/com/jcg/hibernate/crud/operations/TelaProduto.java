package com.jcg.hibernate.crud.operations;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.WindowAdapter;
import java.util.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProduto extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtPreco;
    private String txtID;
    private JComboBox cbPesquisar;
    private ButtonGroup bt = new ButtonGroup();

    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnEditar;
    private JButton btnPesquisar;
    private JButton btnLimpar;

    public TelaProduto() {
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 556, 413);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPesquisar = new JLabel("Pesquisar:");
        lblPesquisar.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPesquisar.setBounds(10, 31, 109, 14);
        contentPane.add(lblPesquisar);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblNome.setBounds(10, 79, 109, 14);
        contentPane.add(lblNome);

        JLabel lblPreco = new JLabel("Preco:");
        lblPreco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPreco.setBounds(10, 104, 109, 14);
        contentPane.add(lblPreco);

        cbPesquisar = new JComboBox();
        cbPesquisar.setEditable(true);
        cbPesquisar.setBounds(129, 28, 283, 20);

        contentPane.add(cbPesquisar);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtNome.setBounds(129, 76, 283, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        txtPreco = new JTextField();
        txtPreco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtPreco.setBounds(129, 101, 365, 20);
        contentPane.add(txtPreco);
        txtPreco.setColumns(10);

        btnSalvar = new JButton("Incluir");
        btnSalvar.setBounds(193, 327, 75, 23);
        btnSalvar.addActionListener(this);
        btnSalvar.setActionCommand("salvar");
        contentPane.add(btnSalvar);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(280, 327, 75, 23);
        btnEditar.setText("Editar");
        btnEditar.addActionListener(this);
        btnEditar.setActionCommand("editar");
        contentPane.add(btnEditar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(360, 327, 75, 23);
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this);
        btnLimpar.setActionCommand("limpar");
        contentPane.add(btnLimpar);

        btnExcluir = new JButton("");
        btnExcluir.setBounds(440, 327, 75, 23);
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this);
        btnExcluir.setActionCommand("excluir");
        contentPane.add(btnExcluir);

        btnPesquisar = new JButton("Buscar");
        btnPesquisar.setBounds(422, 22, 80, 23);
        btnPesquisar.addActionListener(this);
        btnPesquisar.setActionCommand("pesquisar");
        contentPane.add(btnPesquisar);
        txtID = "";
        this.carregaLista();
    }

    public void carregaLista() {
        List<Produto> AlimentoBd = DbOperationsProduto.displayRecords();
        cbPesquisar.removeAllItems();
        for (Produto alimento : AlimentoBd) {
            cbPesquisar.addItem(alimento.getId());
        }
    }

    public Produto montaAlimento() {
        Produto c = new Produto();
        c.setNome(this.txtNome.getText());
        c.setPreco(Float.parseFloat(this.txtPreco.getText()));
        return c;
    }

    public Produto editaAlimento(int i) {
        Produto c = new Produto();
        c.setId(i);
        c.setNome(this.txtNome.getText());
        c.setPreco(Float.parseFloat(this.txtPreco.getText()));
        return c;
    }

    public void carregaAlimentonaTela(Produto c2) {
        this.txtNome.setText(c2.getName());
        this.txtPreco.setText(Float.toString(c2.getPreco()));
    }

    public void limpaTela() {
        for (int i = 0; i < contentPane.getComponentCount(); i++) {
            Component c = contentPane.getComponent(i);
            if (c instanceof JTextField) {
                JTextField campo = (JTextField) c;
                campo.setText(null);
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        // if (e.getActionCommand().equals(this.btnSalvar.getActionCommand())) {
        // DbOperationsProduto.createRecord(txtNome.getText(), txtPreco.getText());

        // this.limpaTela();
        // this.carregaLista();
        // JOptionPane.showMessageDialog(null, "Alimento " + txtNome.getText() + "
        // cadastrado...");
        // } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand()))
        // {

        // int idDigitado =
        // Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
        // Produto alimento = DbOperationsProduto.findRecordByName(idDigitado);
        // if (alimento.getId() == idDigitado) {
        // JOptionPane.showMessageDialog(null, "Alimento encontrado!");
        // this.carregaAlimentonaTela(alimento);
        // } else {
        // JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");

        // }
        // } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
        // this.limpaTela();
        // } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {
        // int idDigitado =
        // Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
        // Produto cbusca = DbOperationsProduto.findRecordByName(idDigitado);
        // if (cbusca == null)
        // JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");
        // else

        // {
        // JOptionPane.showMessageDialog(null, "Alimento excluido!");
        // this.carregaAlimentonaTela(cbusca);
        // DbOperationsProduto.deleteRecord(idDigitado);
        // this.limpaTela();
        // this.carregaLista();
        // }
        // }
        // if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
        // int idDigitado =
        // Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
        // Produto cbusca = DbOperationsProduto.findRecordByName(idDigitado);
        // if (cbusca == null)
        // JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");
        // else

        // {
        // JOptionPane.showMessageDialog(null, "Alimento editado!");

        // DbOperationsProduto.updateRecord(idDigitado, txtNome.getText(),
        // txtPreco.getText());
        // this.limpaTela();
        // this.carregaLista();
        // }
        // }

    }
}
