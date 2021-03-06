package interfaces;

import model.Aluno;
import model.Cursos;
import model.Instrutor;
import model.Turma;
import java.sql.SQLException;
import java.util.List;

public interface DaoAdm {
    /**Alunos
     * @return*/
    List<Aluno> incluiAluno (Aluno id, Aluno cpf, Aluno nome, Aluno email, Aluno celular, Aluno login, Aluno Senha, Aluno Endereco, Aluno Bairro, Aluno Cidade, Aluno Cep,Aluno comentario, Aluno Aprovado);

    List<Aluno> listaAluno(Aluno id) throws SQLException;

    void alteraAlunos(Aluno id, Aluno cpf, Aluno nome, Aluno email, Aluno celular, Aluno login, Aluno Senha, Aluno Endereco, Aluno Bairro, Aluno Cidade, Aluno Cep);

    void excluiAluno(Aluno id);

    void excluiTodosAlunos(Aluno aluno);

    /**Instrutores**/
    void incluiInstrutor(Instrutor id, Instrutor nome, Instrutor email, Instrutor valor_hora, Instrutor login, Instrutor Senha, Instrutor Experiencia);

    List<Instrutor> listaIntrutor(Instrutor id);

    void alteraInstrutor(Instrutor id, Instrutor nome, Instrutor email, Instrutor valor_hora, Instrutor login, Instrutor Senha, Instrutor Experiencia);

    void excluiInstrutor(Instrutor id);

    void excluiTodosInstrutores(Instrutor instrutor);
    /**Curso**/
    void incluiCurso(Cursos id, Cursos nome, Cursos requisito, Cursos cargaHoraria, Cursos preco);

    List<Cursos> listaCurso(Cursos id);

    void alteraCurso(Cursos id, Cursos nome, Cursos requisito, Cursos cargaHoraria, Cursos preco);;

    void excluiCurso(Cursos id);

    void excluiTodosCursos(Cursos cursos);
    /**Turmas**/
    void incluiTurma(Turma id, Turma instrutorId, Turma cursoId, Turma dataInicio, Turma dataFinal, Turma cargaHoraria);

    List<Turma> listaTurma(Turma id);

    void alteraTurma(Turma id, Turma instrutorId, Turma cursoId, Turma dataInicio, Turma dataFinal, Turma cargaHoraria);

    void excluiTurma(Turma id);

    void excluitTodasTurmas(Turma turmas);

    /*Listar Tudo RF16,RF17**/

    void listarPorAlunosTodasOsCursoTurmasENota(Cursos idCurso, Turma idTurma, Aluno idAluno);

    void listarPorInstrutorTodosOsCursosTurmasValorTotal(Instrutor idInstrutor, Turma idTurma, Cursos IdCursos);


}
