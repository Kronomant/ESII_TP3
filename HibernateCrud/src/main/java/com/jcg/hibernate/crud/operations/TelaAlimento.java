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
        this.carregaLista();
    }

    public void carregaLista() {
        List<Alimento704593e706002> AlimentoBd = DbOperationsAlimento.displayRecords();
        cbPesquisar.removeAllItems();
        for (Alimento704593e706002 alimento : AlimentoBd) {
            cbPesquisar.addItem(alimento.getName());
        }
    }

    public Alimento704593e706002 montaAlimento() {
        Alimento704593e706002 c = new Alimento704593e706002();
        c.setNome(this.txtNome.getText());
        c.setPreco(Float.parseFloat(this.txtPreco.getText()));
        return c;
    }

    public Alimento704593e706002 editaAlimento(int i) {
        Alimento704593e706002 c = new Alimento704593e706002();
        c.setNome(this.txtNome.getText());
        c.setPreco(Float.parseFloat(this.txtPreco.getText()));
        return c;
    }

    public void carregaAlimentonaTela(Alimento704593e706002 c2) {
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
        if (e.getActionCommand().equals(this.btnSalvar.getActionCommand())) {
            DbOperationsAlimento.createRecord(txtNome.getText(), txtPreco.getText());

            this.limpaTela();
            this.carregaLista();
            JOptionPane.showMessageDialog(null, "Alimento " + txtNome.getText() + " cadastrado...");
        } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) {

            String nomeDigitado = cbPesquisar.getSelectedItem().toString().trim();
            Alimento704593e706002 alimento = DbOperationsAlimento.findRecordByName(nomeDigitado);
            if (alimento.getName().equals(nomeDigitado)) {
                JOptionPane.showMessageDialog(null, "Alimento encontrado!");
                this.carregaAlimentonaTela(alimento);
            } else {
                JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");

            }
        } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
            this.limpaTela();
        } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {
            String nomeDigitado = cbPesquisar.getSelectedItem().toString().trim();
            Alimento704593e706002 cbusca = DbOperationsAlimento.findRecordByName(nomeDigitado);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");
            else

            {
                JOptionPane.showMessageDialog(null, "Alimento excluido!");
                this.carregaAlimentonaTela(cbusca);
                DbOperationsAlimento.deleteRecord(nomeDigitado);
                this.limpaTela();
                this.carregaLista();
            }
        }
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
            String nomeDigitado = cbPesquisar.getSelectedItem().toString().trim();
            Alimento704593e706002 cbusca = DbOperationsAlimento.findRecordByName(nomeDigitado);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Alimento nao cadastrado...");
            else

            {
                JOptionPane.showMessageDialog(null, "Alimento editado!");

                DbOperationsAlimento.updateRecord(nomeDigitado, txtNome.getText(), txtPreco.getText());
                this.limpaTela();
                this.carregaLista();
            }
        }

    }
}
