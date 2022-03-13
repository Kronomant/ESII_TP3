package controle;

import modelo.Produto;
import persistencia.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ProdutoCT {

    public void insert(Produto c) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.insert(c);
    }

    public void update(Produto c) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.update(c);
    }

    public void delete(Produto c) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.delete(c.getId());
    }

    public Produto select(String nomebusca) {
         ProdutoDAO dao = new ProdutoDAO();
         Produto c = (Produto) dao.select(nomebusca);
        return c;
    }

    public List<Produto> getProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> c = dao.getProdutos();
        return c;

    }
}