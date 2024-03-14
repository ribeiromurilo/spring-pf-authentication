package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SISTEMA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISTEMA")
    @SequenceGenerator(
            name = "SQ_SISTEMA",
            sequenceName = "SQ_SISTEMA",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_SISTEMA")
    private Long id;

    @Column(name = "NM_SISTEMA")
    private String nome;

    @Column(name = "SGL_SISTEMA")
    private String sigla;

}