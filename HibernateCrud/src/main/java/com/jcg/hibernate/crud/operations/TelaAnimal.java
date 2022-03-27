package com.jcg.hibernate.crud.operations;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.WindowAdapter;
import java.util.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAnimal extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtQuantidade;
    private JComboBox cbPesquisar;
    private JComboBox cbAlimentos;
    private JComboBox cbProdutos;
    private ButtonGroup bt = new ButtonGroup();

    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnEditar;
    private JButton btnPesquisar;
    private JButton btnLimpar;

    public TelaAnimal() {
        setTitle("Cadastro de Animais");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 413);
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

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblQuantidade.setBounds(10, 104, 109, 14);
        contentPane.add(lblQuantidade);

        JLabel lblBuscarAlimentos = new JLabel("Selecionar Alimentos:");
        lblBuscarAlimentos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblBuscarAlimentos.setBounds(10, 150, 109, 14);
        contentPane.add(lblBuscarAlimentos);

        JLabel lblBuscarProdutos = new JLabel("Selecionar Produtos:");
        lblBuscarProdutos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblBuscarProdutos.setBounds(10, 190, 109, 14);
        contentPane.add(lblBuscarProdutos);

        cbPesquisar = new JComboBox();
        cbPesquisar.setEditable(true);
        cbPesquisar.setBounds(129, 28, 283, 20);

        contentPane.add(cbPesquisar);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtNome.setBounds(129, 76, 283, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        txtQuantidade = new JTextField();
        txtQuantidade.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtQuantidade.setBounds(129, 101, 283, 20);
        contentPane.add(txtQuantidade);
        txtQuantidade.setColumns(10);

        cbAlimentos = new JComboBox();
        cbAlimentos.setEditable(true);
        cbAlimentos.setBounds(129, 150, 283, 20);

        contentPane.add(cbAlimentos);

        cbProdutos = new JComboBox();
        cbProdutos.setEditable(true);
        cbProdutos.setBounds(129, 190, 283, 20);

        contentPane.add(cbProdutos);

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
        this.carregaListaAlimento();
        this.carregaListaProduto();
    }

    public void carregaListaProduto() {
        List<Produto704593e706002> ProdutoBd = DbOperationsProduto.displayRecords();
        cbProdutos.removeAllItems();
        for (Produto704593e706002 produto : ProdutoBd) {
            cbProdutos.addItem(produto.getId());
        }
    }

    public void carregaListaAlimento() {
        List<Alimento704593e706002> AlimentoBd = DbOperationsAlimento.displayRecords();
        cbAlimentos.removeAllItems();
        for (Alimento704593e706002 alimento : AlimentoBd) {
            cbAlimentos.addItem(alimento.getId());
        }
    }

    public void carregaLista() {
        List<Animal704593e706002> AnimalBd = DbOperationsAnimal.displayRecords();
        cbPesquisar.removeAllItems();
        for (Animal704593e706002 Animal : AnimalBd) {
            cbPesquisar.addItem(Animal.getId());
        }
    }

    public Animal704593e706002 montaAnimal() {
        Animal704593e706002 c = new Animal704593e706002();
        c.setNome(this.txtNome.getText());
        c.setQuantidade(Integer.parseInt(this.txtQuantidade.getText()));
        return c;
    }

    public Animal704593e706002 editaAnimal(int i) {
        Animal704593e706002 c = new Animal704593e706002();
        c.setNome(this.txtNome.getText());
        c.setQuantidade(Integer.parseInt(this.txtQuantidade.getText()));
        return c;
    }

    public void carregaAnimalnaTela(Animal704593e706002 c2) {
        this.txtNome.setText(c2.getName());
        this.txtQuantidade.setText(Integer.toString(c2.getQuantidade()));
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
            DbOperationsAnimal.createRecord(txtNome.getText(), txtQuantidade.getText());
            this.limpaTela();
            this.carregaLista();
            JOptionPane.showMessageDialog(null, "Animal " + txtNome.getText() + " cadastrado...");
        } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) {

            int idDigitado = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Animal704593e706002 Animal = DbOperationsAnimal.findRecordByName(idDigitado);
            if (Animal.getId() == idDigitado) {
                JOptionPane.showMessageDialog(null, "Animal encontrado!");
                this.carregaAnimalnaTela(Animal);
            } else {
                JOptionPane.showMessageDialog(null, "Animal nao cadastrado...");

            }
        } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
            this.limpaTela();
        } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {
            int idDigitado = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Animal704593e706002 cbusca = DbOperationsAnimal.findRecordByName(idDigitado);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Animal nao cadastrado...");
            else

            {
                JOptionPane.showMessageDialog(null, "Animal excluido!");
                this.carregaAnimalnaTela(cbusca);
                DbOperationsAnimal.deleteRecord(idDigitado);
                this.limpaTela();
                this.carregaLista();
            }
        }
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
            int idDigitado = Integer.parseInt(cbPesquisar.getSelectedItem().toString().trim());
            Animal704593e706002 cbusca = DbOperationsAnimal.findRecordByName(idDigitado);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Animal nao cadastrado...");
            else

            {
                JOptionPane.showMessageDialog(null, "Animal editado!");

                DbOperationsAnimal.updateRecord(idDigitado, txtNome.getText(), txtQuantidade.getText());
                this.limpaTela();
                this.carregaLista();
            }
        }

    }
}
