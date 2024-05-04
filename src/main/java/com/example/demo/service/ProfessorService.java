package com.example.demo.service;

import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j //nos ajuda a escrever log no projeto
@Service //indica que é uma camada de serviço(negócio)
public class ProfessorService  {

    @Autowired
    private ProfessorRepository professorRepository;
    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)

    public Professor create(Professor entity) {
        return professorRepository.save(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */

    public Professor get(Integer id) {
        return professorRepository.findById(id).orElse(new Professor());
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */

    public List<Professor> get() {
        return professorRepository.findAll();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @Transactional(rollbackFor = Exception.class)

    public Professor update(Integer id, Professor entity) {
        Professor professorEncontrado = this.get(id);

        if(professorEncontrado.getId()!=0 || professorEncontrado.getId()!=null){
            return professorRepository.save(entity);
        }
        else{
            //return null;
            return new Professor();
        }
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)

    public void delete(Integer id) {
        professorRepository.deleteById(id);
    }
}
