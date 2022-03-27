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

    private JComboBox cbPesquisar;
    private JComboBox cbAnimal;
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

        // Label de Pesquisa
        JLabel lblPesquisar = new JLabel("Pesquisar:");
        lblPesquisar.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPesquisar.setBounds(10, 31, 109, 14);
        contentPane.add(lblPesquisar);

        // Label campo Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblNome.setBounds(10, 79, 109, 14);
        contentPane.add(lblNome);

        // Label quantidade
        JLabel lblQtde = new JLabel("Quantidade produzida:");
        lblQtde.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblQtde.setBounds(10, 104, 169, 14);
        contentPane.add(lblQtde);

        // Label Preço
        JLabel lblPreco = new JLabel("Preco:");
        lblPreco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPreco.setBounds(10, 124, 109, 14);
        contentPane.add(lblPreco);

        // Label Animal
        JLabel lblAnimal = new JLabel("Animal:");
        lblAnimal.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblAnimal.setBounds(10, 150, 109, 14);
        contentPane.add(lblAnimal);

        // Select de Pesquisa
        cbPesquisar = new JComboBox();
        cbPesquisar.setEditable(true);
        cbPesquisar.setBounds(129, 28, 283, 20);
        contentPane.add(cbPesquisar);

        // Input Nome
        txtNome = new JTextField();
        txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtNome.setBounds(129, 76, 283, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        // Input Quantidade
        txtQtde = new JTextField();
        txtQtde.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtQtde.setBounds(180, 101, 283, 20);
        contentPane.add(txtQtde);
        txtQtde.setColumns(10);

        // Input Preco
        txtPreco = new JTextField();
        txtPreco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtPreco.setBounds(129, 124, 283, 20);
        contentPane.add(txtPreco);
        txtPreco.setColumns(10);

        // Select Animal
        cbAnimal = new JComboBox();
        cbAnimal.setEditable(true);
        cbAnimal.setBounds(129, 150, 283, 20);
        contentPane.add(cbAnimal);

        // Botões

        btnSalvar = new JButton("Incluir");
        btnSalvar.setBounds(20, 327, 95, 23);
        btnSalvar.addActionListener(this);
        btnSalvar.setActionCommand("salvar");
        contentPane.add(btnSalvar);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(120, 327, 95, 23);
        btnEditar.setText("Editar");
        btnEditar.addActionListener(this);
        btnEditar.setActionCommand("editar");
        contentPane.add(btnEditar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(220, 327, 95, 23);
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this);
        btnLimpar.setActionCommand("limpar");
        contentPane.add(btnLimpar);

        btnExcluir = new JButton("");
        btnExcluir.setBounds(320, 327, 95, 23);
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this);
        btnExcluir.setActionCommand("excluir");
        contentPane.add(btnExcluir);

        btnPesquisar = new JButton("Buscar");
        btnPesquisar.setBounds(422, 22, 95, 23);
        btnPesquisar.addActionListener(this);
        btnPesquisar.setActionCommand("pesquisar");
        contentPane.add(btnPesquisar);
        this.carregaLista();
    }

    public void carregaLista() {
        // Carrega lista de produtos
        List<Produto704593e706002> ProdutoBd = DbOperationsProduto.displayRecords();
        cbPesquisar.removeAllItems();
        // Adiciona lista de produto no select
        for (Produto704593e706002 produto : ProdutoBd) {
            cbPesquisar.addItem(produto);
        }

        List<Animal704593e706002> AnimalBD = DbOperationsAnimal.displayRecords();
        cbAnimal.removeAllItems();
        for (Animal704593e706002 animal : AnimalBD) {
            cbAnimal.addItem(animal);
        }
    }

    public Produto704593e706002 montaProduto() {
        Produto704593e706002 c = new Produto704593e706002();
        c.setNome(this.txtNome.getText());
        c.setPreco(Float.parseFloat(this.txtPreco.getText()));
        return c;
    }

    public void carregaProdutonaTela(Produto704593e706002 c2) {
        this.txtNome.setText(c2.getNome());
        this.txtPreco.setText(Float.toString(c2.getPreco()));
        this.txtQtde.setText(Integer.toString(c2.getQuantidadeProduzida()));
        // cbAnimal.setSelectedItem();
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
            String[] animal = cbAnimal.getSelectedItem().toString().split("-");

            // Insere Produto no Banco ok
            DbOperationsProduto.createRecord(txtNome.getText(), txtQtde.getText(), txtPreco.getText(),
                    Integer.parseInt(animal[0]));

            this.limpaTela();
            this.carregaLista();
            JOptionPane.showMessageDialog(null, "Produto " + txtNome.getText() + "cadastrado...");
        } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) { // Pesquisa Produto no banco ok
            String[] produtoDigitado = cbPesquisar.getSelectedItem().toString().split("-");

            Produto704593e706002 produto = DbOperationsProduto.findRecordByName(Integer.parseInt(produtoDigitado[0]));
            if (produto.getNome().equals(produtoDigitado[1])) {

                this.carregaProdutonaTela(produto);
            } else {
                JOptionPane.showMessageDialog(null, "Produto nao cadastrado...");

            }
        } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) { // Limpa campos ok
            this.limpaTela();
        } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) { // Exclui Registro
            String[] produtoDigitado = cbPesquisar.getSelectedItem().toString().split("-");
            Produto704593e706002 cbusca = DbOperationsProduto.findRecordByName(Integer.parseInt(produtoDigitado[0]));

            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Produto nao cadastrado...");
            else {

                this.carregaProdutonaTela(cbusca);
                DbOperationsProduto.deleteRecord(Integer.parseInt(produtoDigitado[0]));
                this.limpaTela();
                this.carregaLista();
            }
        }
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) { // Edita produto
            String[] produtoDigitado = cbPesquisar.getSelectedItem().toString().split("-");
            Produto704593e706002 cbusca = DbOperationsProduto.findRecordByName(Integer.parseInt(produtoDigitado[0]));
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Produto nao cadastrado...");
            else {
                String[] animal = cbAnimal.getSelectedItem().toString().split("-");
                DbOperationsProduto.updateRecord(
                        Integer.parseInt(produtoDigitado[0]),
                        txtNome.getText(),
                        txtQtde.getText(),
                        txtPreco.getText(),
                        animal[0]);
                this.limpaTela();
                this.carregaLista();
            }
        }

    }
}
