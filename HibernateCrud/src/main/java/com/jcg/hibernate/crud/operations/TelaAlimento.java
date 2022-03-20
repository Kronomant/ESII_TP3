package com.jcg.hibernate.crud.operations;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.WindowAdapter;
import java.util.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlimento extends JFrame implements ActionListener {

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

    public TelaAlimento() {
        setTitle("Cadastro de Alimentos");
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
        List<Alimento> AlimentoBd = DbOperationsAlimento.displayRecords();
        cbPesquisar.removeAllItems();
        for (Alimento alimento : AlimentoBd) {
            cbPesquisar.addItem(alimento.getId());
        }
    }

    public Alimento montaAlimento() {
        // Pega os dados digitados nos campos do formulário e atribui ao objeto da
        // classe Alimento;
        Alimento c = new Alimento();
        c.setNome(this.txtNome.getText());
        c.setPreco(Float.parseFloat(this.txtPreco.getText()));
        return c;
    }

    public Alimento editaAlimento(int i) {
        // Pega os dados digitados nos campos do formulário e atribui ao objeto da
        // classe Alimento;
        Alimento c = new Alimento();
        c.setId(i);
        c.setNome(this.txtNome.getText());
        c.setPreco(Float.parseFloat(this.txtPreco.getText()));
        return c;
    }

    public void carregaAlimentonaTela(Alimento c2) {
        // Pega os dados digitados nos campos do formulário e atribui ao objeto da
        // classe Alimento;
        this.txtNome.setText(c2.getName());
        this.txtPreco.setText(Float.toString(c2.getPreco()));
    }

    public void limpaTela() {
        for (int i = 0; i < contentPane.getComponentCount(); i++) {
            // laço de repetição percorrendo o contentPane - JPanel, o painel principal do
            // form
            Component c = contentPane.getComponent(i);
            // Cria um objeto Component c que recebe o componente na posição i do laço for
            if (c instanceof JTextField) { // se o componente c for uma instância de JTextField
                JTextField campo = (JTextField) c;
                // cria uma variável JTextField recebendo o componente c com um cast
                campo.setText(null);
                // apaga o conteúdo do campo JTextField;
            }
        }

    }

    /*
     * public void actionPerformed(ActionEvent e) {
     * if (e.getActionCommand().equals(this.btnSalvar.getActionCommand())) {
     * DbOperationsAlimento.createRecord(txtNome.getText(), txtPreco.getText());
     * this.limpaTela();
     * JOptionPane.showMessageDialog(null, "Alimento " + txtNome.getText() +
     * " cadastrado...");
     * } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand()))
     * {
     * String nomeDigitado = txtNome.getText();
     * Alimento cbusca = DbOperationsAlimento.findRecordByName(nomeDigitado);
     * if (cbusca.getName().equals(nomeDigitado)) {
     * JOptionPane.showMessageDialog(null, "Alimento encontrado!");
     * this.carregaAlimentonaTela(cbusca);
     * } else {
     * JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");
     * 
     * }
     * 
     * } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
     * this.limpaTela();
     * } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {
     * DbOperationsAlimento.deleteRecord(txtNome.getText());
     * this.limpaTela();
     * JOptionPane.showMessageDialog(null, "Alimento " + txtNome.getText() +
     * " excluído...");
     * }
     * if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
     * 
     * }
     * }
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.btnSalvar.getActionCommand())) {
            DbOperationsAlimento.createRecord(txtNome.getText(), txtPreco.getText());

            this.limpaTela();
            this.carregaLista();
            JOptionPane.showMessageDialog(null, "Alimento " + txtNome.getText() + " cadastrado...");
        } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) {

            int idDigitado = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Alimento alimento = DbOperationsAlimento.findRecordByName(idDigitado);
            if (alimento.getId() == idDigitado) {
                JOptionPane.showMessageDialog(null, "Alimento encontrado!");
                this.carregaAlimentonaTela(alimento);
            } else {
                JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");

            }
        } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
            this.limpaTela();
        } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {
            int idDigitado = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Alimento cbusca = DbOperationsAlimento.findRecordByName(idDigitado);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");
            else

            {
                JOptionPane.showMessageDialog(null, "Alimento excluido!");
                this.carregaAlimentonaTela(cbusca);
                DbOperationsAlimento.deleteRecord(idDigitado);
                this.limpaTela();
                this.carregaLista();
            }
        }
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
            int idDigitado = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Alimento cbusca = DbOperationsAlimento.findRecordByName(idDigitado);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");
            else

            {
                JOptionPane.showMessageDialog(null, "Alimento editado!");

                DbOperationsAlimento.updateRecord(idDigitado, txtNome.getText(), txtPreco.getText());
                this.limpaTela();
                this.carregaLista();
            }
        }

    }
}
