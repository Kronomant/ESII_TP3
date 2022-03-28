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
    private JTextField txtQuantidadeAlimentos;
    private JComboBox cbPesquisar;
    private JComboBox cbAlimentos;
    private ButtonGroup bt = new ButtonGroup();

    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnEditar;
    private JButton btnPesquisar;
    private JButton btnLimpar;
    private JButton btnConsumoAlimentos;

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
        lblPesquisar.setBounds(10, 30, 200, 14);
        contentPane.add(lblPesquisar);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblNome.setBounds(10, 80, 200, 14);
        contentPane.add(lblNome);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblQuantidade.setBounds(10, 130, 200, 14);
        contentPane.add(lblQuantidade);

        JLabel lblBuscarAlimentos = new JLabel("Selecionar Alimentos:");
        lblBuscarAlimentos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblBuscarAlimentos.setBounds(10, 180, 200, 14);
        contentPane.add(lblBuscarAlimentos);

        JLabel lblQtdeAlimentos = new JLabel("Quantidade Consumida:");
        lblQtdeAlimentos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblQtdeAlimentos.setBounds(10, 230, 200, 14);
        contentPane.add(lblQtdeAlimentos);

        cbPesquisar = new JComboBox();
        cbPesquisar.setEditable(true);
        cbPesquisar.setBounds(140, 30, 300, 20);

        contentPane.add(cbPesquisar);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtNome.setBounds(140, 80, 320, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        txtQuantidade = new JTextField();
        txtQuantidade.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtQuantidade.setBounds(140, 130, 320, 20);
        contentPane.add(txtQuantidade);
        txtQuantidade.setColumns(10);

        cbAlimentos = new JComboBox();
        cbAlimentos.setEditable(true);
        cbAlimentos.setBounds(140, 180, 320, 20);

        contentPane.add(cbAlimentos);

        txtQuantidadeAlimentos = new JTextField();
        txtQuantidadeAlimentos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtQuantidadeAlimentos.setBounds(140, 230, 320, 20);
        contentPane.add(txtQuantidadeAlimentos);
        txtQuantidadeAlimentos.setColumns(10);

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

        btnPesquisar = new JButton("Alimentos Consumidos");
        btnPesquisar.setBounds(480, 180, 200, 23);
        btnPesquisar.addActionListener(this);
        btnPesquisar.setActionCommand("consumoAlimentos");
        contentPane.add(btnPesquisar);

        btnPesquisar = new JButton("Buscar");
        btnPesquisar.setBounds(450, 30, 95, 23);
        btnPesquisar.addActionListener(this);
        btnPesquisar.setActionCommand("pesquisar");
        contentPane.add(btnPesquisar);

        this.carregaLista();
    }

    public void carregaLista() {
        // Carrega lista de animais
        List<Animal704593e706002> AnimalBD = DbOperationsAnimal.displayRecords();
        cbPesquisar.removeAllItems();
        // Adiciona lista de animais no select
        for (Animal704593e706002 animal : AnimalBD) {
            cbPesquisar.addItem(animal);
        }

        // Carrega lista de alimentos
        List<Alimento704593e706002> AlimentoBd = DbOperationsAlimento.displayRecords();
        cbAlimentos.removeAllItems();
        // Adiciona lista de Alimento no select
        for (Alimento704593e706002 alimento : AlimentoBd) {
            cbAlimentos.addItem(alimento);
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
            String[] alimento = cbAlimentos.getSelectedItem().toString().split("-");

            // Insere Animal no Banco ok
            DbOperationsAnimal.createRecord(txtNome.getText(), txtQuantidade.getText());

            this.limpaTela();
            this.carregaLista();
            JOptionPane.showMessageDialog(null, "Animal " + txtNome.getText() + "cadastrado...");
        } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) { // Pesquisa Animal no banco ok
            String[] animalDigitado = cbPesquisar.getSelectedItem().toString().split("-");

            Animal704593e706002 Animal = DbOperationsAnimal.findRecordById(Integer.parseInt(animalDigitado[0]));
            if (Animal.getName().equals(animalDigitado[1])) {

                this.carregaAnimalnaTela(Animal);
            } else {
                JOptionPane.showMessageDialog(null, "Animal nao cadastrado...");

            }
        } else if (e.getActionCommand().equals(this.btnConsumoAlimentos.getActionCommand())) {
            String[] animalDigitado = cbPesquisar.getSelectedItem().toString().split("-");
            Animal704593e706002 cbusca = DbOperationsAnimal.findRecordById(Integer.parseInt(animalDigitado[0]));
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Animal nao cadastrado...");
            else {
                String[] alimento = cbAlimentos.getSelectedItem().toString().split("-");

                DbOperationsConsumoAlimentos.createConsumoAlimentos(
                        Integer.parseInt(animalDigitado[0]),
                        Integer.parseInt(alimento[0]),
                        Integer.parseInt(txtQuantidadeAlimentos.getText()));
                this.limpaTela();
                this.carregaLista();
            }
        } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) { // Limpa campos ok
            this.limpaTela();
        } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) { // Exclui Registro
            String[] animalDigitado = cbPesquisar.getSelectedItem().toString().split("-");
            Animal704593e706002 cbusca = DbOperationsAnimal.findRecordById(Integer.parseInt(animalDigitado[0]));

            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Animal nao cadastrado...");
            else {

                this.carregaAnimalnaTela(cbusca);
                DbOperationsAnimal.deleteRecord(Integer.parseInt(animalDigitado[0]));
                this.limpaTela();
                this.carregaLista();
            }
        }
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) { // Edita animal
            String[] animalDigitado = cbPesquisar.getSelectedItem().toString().split("-");
            Animal704593e706002 cbusca = DbOperationsAnimal.findRecordById(Integer.parseInt(animalDigitado[0]));
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Animal nao cadastrado...");
            else {
                String[] alimento = cbAlimentos.getSelectedItem().toString().split("-");
                DbOperationsAnimal.updateRecord(
                        Integer.parseInt(animalDigitado[0]),
                        txtNome.getText(),
                        txtQuantidade.getText());
                this.limpaTela();
                this.carregaLista();
            }
        }
    }
}
