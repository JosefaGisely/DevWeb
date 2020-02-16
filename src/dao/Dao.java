package dao;

import model.Usuario;
import java.util.List;

public interface Dao {

    void inclui(Usuario u);

   // List<Usuario> listaTodos(List u);

    Usuario busca(Usuario id);

    Usuario buscaLogin(String email, String senha);

    void altera(Usuario u);

    void alteraSenha(Usuario u);

    void remove(int id);

    void removePorAutor(int idUsuario);



}
