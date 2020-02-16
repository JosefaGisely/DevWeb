package dao;

import model.Aluno;
import model.Cursos;
import model.Instrutor;
import model.Turmas;
import java.sql.SQLException;
import java.util.List;

public interface DaoAdm {
    /**Alunos**/
    void incluiAluno( Aluno a);

    List<Aluno> listaAluno(Aluno id) throws SQLException;

    void alteraAlunos(Aluno id, Aluno cpf, Aluno nome, Aluno email, Aluno celular, Aluno login, Aluno Senha, Aluno Endereço, Aluno Bairro, Aluno Cidade, Aluno Cep);

    void excluiAluno(Aluno id);

    void excluiTodosAlunos(Aluno aluno);

    /**Instrutores**/
    void incluiInstrutor(Instrutor id, Instrutor nome, Instrutor email, Instrutor valor_hora, Instrutor login, Instrutor Senha, Instrutor Experiencia);

    void listaIntrutor(Instrutor id);

    void alteraInstrutor(Instrutor id, Instrutor nome, Instrutor email, Instrutor valor_hora, Instrutor login, Instrutor Senha, Instrutor Experiencia);

    void excluiInstrutor(Instrutor id);

    void excluiTodosInstrutores(Instrutor instrutor);
    /**Curso**/
    void incluiCurso(Cursos id, Cursos nome, Cursos requisito, Cursos cargaHoraria, Cursos preco);

    void listaCurso(Cursos id);

    void alteraCurso(Cursos id, Cursos nome, Cursos requisito, Cursos cargaHoraria, Cursos preco);;

    void excluiCurso(Cursos id);

    void excluiTodosCursos(Cursos cursos);
    /**Turmas**/
    void incluiTurma(Turmas id, Turmas instrutorId, Turmas cursoId, Turmas dataInicio, Turmas dataFinal, Turmas cargaHoraria);

    void listaTurma(Turmas id);

    void alteraTurma(Turmas id, Turmas instrutorId, Turmas cursoId, Turmas dataInicio, Turmas dataFinal, Turmas cargaHoraria);

    void excluiTurma(Turmas id);

    void excluitTodasTurmas(Turmas turmas);

    /*Listar Tudo RF16,RF17**/

    void listarPorAlunosTodasOsCursoTurmasENota(Cursos idCurso, Turmas idTurma, Aluno idAluno);

    void listarPorInstrutorTodosOsCursosTurmasValorTotal(Instrutor idInstrutor, Turmas idTurma, Cursos IdCursos);


}
