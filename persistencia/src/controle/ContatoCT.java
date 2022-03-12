package controle;

import modelo.Contato;
import persistencia.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ContatoCT {

    public void insert(Contato c) {
        ContatoDAO dao = new ContatoDAO();
        dao.insert(c);
    }

    public void update(Contato c) {
        ContatoDAO dao = new ContatoDAO();
        dao.update(c);
    }

    public void delete(Contato c) {
        ContatoDAO dao = new ContatoDAO();
        dao.delete(c.getId());
    }

    public Contato select(String nomebusca) {
         ContatoDAO dao = new ContatoDAO();
         Contato c = (Contato) dao.select(nomebusca);
        return c;
    }

    public List<Contato> getContatos() {
        ContatoDAO dao = new ContatoDAO();
        List<Contato> c = dao.getContatos();
        return c;

    }
}