package com.jcg.hibernate.crud.operations;

public class AppMain {

    public static void main(String args[]) {

        TelaProduto TC = new TelaProduto();
        TC.setVisible(true);

        TelaAlimento telaAlimento = new TelaAlimento();
        telaAlimento.setVisible(false);

        TelaAnimal telaAnimal = new TelaAnimal();
        telaAnimal.setVisible(false);

    }
}