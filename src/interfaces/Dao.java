package interfaces;

import model.Aluno;

import java.util.List;

public interface Dao {

    void adiciona(Aluno aluno);

    List<Aluno> listaTodos(List u);

    Aluno busca (Aluno id);

    Aluno buscaPorEmail(String email);

    Aluno buscaLogin(String email, String senha);

    void altera(Aluno aluno);

    void alteraSenha(Aluno aluno);

    void remove(int id);

    void removePorAutor(int idUsuario);



}
