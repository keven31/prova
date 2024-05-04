package com.example.demo.service;

import com.example.demo.model.Disciplina;
import com.example.demo.repository.DisciplinaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j //nos ajuda a escrever log no projeto
@Service //indica que é uma camada de serviço(negócio)
public class DisciplinaService  {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)

    public Disciplina create(Disciplina entity) {
        return disciplinaRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */

    public Disciplina get(Integer id) {
        return disciplinaRepository.findById(id).orElse(new Disciplina());
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */

    public List<Disciplina> get() {
        return disciplinaRepository.findAll();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)

    public Disciplina update(Integer id, Disciplina entity) {
        Disciplina disciplinaEncontrada = this.get(id);

        if(disciplinaEncontrada.getId()!=0 || disciplinaEncontrada.getId()!=null){
            return disciplinaRepository.save(entity);
        }
        else{
            //return null;
            return new Disciplina();
        }
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)

    public void delete(Integer id) {
        disciplinaRepository.deleteById(id);
    }
}
