package com.example.demo.resource;

import com.example.demo.model.Disciplina;
import com.example.demo.service.DisciplinaService;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j //nos ajuda a escrever log no projeto
@RestController //inicida que é uma camada para api
@RequestMapping("api/v1/disciplina")
public class DisciplinaResource  {

    @Autowired //injeção de dependência
    private DisciplinaService disciplinaService;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */

    public Disciplina create(Disciplina entity) {
        return disciplinaService.create(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */

    public Disciplina get(Integer id) {

        return disciplinaService.get(id);
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */

    public List<Disciplina> get() {
        return disciplinaService.get();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */

    public Disciplina update(Integer id, Disciplina entity) {
        return disciplinaService.update(id,entity);
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    public void delete(Integer id) {
        disciplinaService.delete(id);
    }
}
