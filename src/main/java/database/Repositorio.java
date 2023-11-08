package database;

import java.util.List;

public interface Repositorio<T> {
    void criar(T object);

    List<T> listar(String nomeOrigem);

    Object atualizar(T object);

    void deletar(Integer id);

}