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
    private JTextField txtQtde;
    private JTextField txtPreco;
    private JTextField txtAnimal;

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

        // Labels
        JLabel lblPesquisar = new JLabel("Pesquisar:");
        lblPesquisar.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPesquisar.setBounds(10, 31, 109, 14);
        contentPane.add(lblPesquisar);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblNome.setBounds(10, 79, 109, 14);
        contentPane.add(lblNome);

        JLabel lblQtde = new JLabel("Quantidade produzida:");
        lblQtde.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblQtde.setBounds(10, 104, 169, 14);
        contentPane.add(lblQtde);

        JLabel lblPreco = new JLabel("Preco:");
        lblPreco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPreco.setBounds(10, 124, 109, 14);
        contentPane.add(lblPreco);

        JLabel lblAnimal = new JLabel("Animal:");
        lblAnimal.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblAnimal.setBounds(10, 150, 109, 14);
        contentPane.add(lblAnimal);

        // Campos
        cbPesquisar = new JComboBox();
        cbPesquisar.setEditable(true);
        cbPesquisar.setBounds(129, 28, 283, 20);

        contentPane.add(cbPesquisar);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtNome.setBounds(129, 76, 283, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        txtQtde = new JTextField();
        txtQtde.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtQtde.setBounds(180, 101, 283, 20);
        contentPane.add(txtQtde);
        txtQtde.setColumns(10);

        txtPreco = new JTextField();
        txtPreco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtPreco.setBounds(129, 124, 283, 20);
        contentPane.add(txtPreco);
        txtPreco.setColumns(10);

        txtAnimal = new JTextField();
        txtAnimal.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtAnimal.setBounds(129, 150, 283, 20);
        contentPane.add(txtAnimal);
        txtAnimal.setColumns(10);

        // Botões

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
        List<Produto> ProdutoBd = DbOperationsProduto.displayRecords();
        cbPesquisar.removeAllItems();
        for (Produto produto : ProdutoBd) {
            cbPesquisar.addItem(produto.getNome());
        }
    }

    public Produto montaProduto() {
        Produto c = new Produto();
        c.setNome(this.txtNome.getText());
        c.setPreco(Float.parseFloat(this.txtPreco.getText()));
        return c;
    }

    public void carregaProdutonaTela(Produto c2) {
        this.txtNome.setText(c2.getNome());
        this.txtPreco.setText(Float.toString(c2.getPreco()));
        this.txtQtde.setText(Integer.toString(c2.getQuantidadeProduzida()));
        this.txtAnimal.setText(c2.getAnimal());
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
            DbOperationsProduto.createRecord(txtNome.getText(), txtQtde.getText(), txtPreco.getText(),
                    txtAnimal.getText());

            this.limpaTela();
            this.carregaLista();
            JOptionPane.showMessageDialog(null, "Produto " + txtNome.getText() + "cadastrado...");
        } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) {

            String nomeDigitado = cbPesquisar.getSelectedItem().toString();
            Produto produto = DbOperationsProduto.findRecordByName(nomeDigitado);
            if (produto.getNome() == nomeDigitado) {

                this.carregaProdutonaTela(produto);
            } else {
                JOptionPane.showMessageDialog(null, "Produto nao cadastrado...");

            }
        } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
            this.limpaTela();
        } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {
            String nomeDigitado = cbPesquisar.getSelectedItem().toString();
            Produto cbusca = DbOperationsProduto.findRecordByName(nomeDigitado);

            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Produto nao cadastrado...");
            else {

                this.carregaProdutonaTela(cbusca);
                DbOperationsProduto.deleteRecord(nomeDigitado);
                this.limpaTela();
                this.carregaLista();
            }
        }
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
            String nomeAntigo = cbPesquisar.getSelectedItem().toString();
            Produto cbusca = DbOperationsProduto.findRecordByName(nomeAntigo);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Produto nao cadastrado...");
            else {
                DbOperationsProduto.updateRecord(
                        nomeAntigo,
                        txtNome.getText(),
                        txtQtde.getText(),
                        txtPreco.getText(),
                        txtAnimal.getText());
                this.limpaTela();
                this.carregaLista();
            }
        }

    }
}
