package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*lombok*/
@Data //lomok ajuda com os métodos: get,set,tostring, @equals
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*lombok*/
/*jpa/hibernate*/
@Entity
@Table(name = "ALUNO")
/*jpa/hibernate*/
public class Aluno {


    /**
     * @see <a href="https://en.wikipedia.org/wiki/Fluent_interface">Interface Fluent</a>
     */
    public void interfaceFluente(){
        Aluno xpto = Aluno.builder().nome("").endereco("").telefone("").build();
    }

    //@Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@Getter
    //@Setter
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    private String endereco;

    private String telefone;

    private boolean ativo;

}
