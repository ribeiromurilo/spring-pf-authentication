package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_Perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_Perfil")
    @SequenceGenerator(
            name = "SQ_Perfil",
            sequenceName = "SQ_Perfil",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_Perfil")
    private Long id;

    @Column(name = "NM_Perfil")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_PERMISSAO_PERFIL",
            joinColumns = {
                    @JoinColumn(
                            name = "PERFIL",
                            referencedColumnName = "ID_PERFIL",
                            foreignKey = @ForeignKey(
                                    name = "FK_PERMISSOES_PERFIL"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PERMISSAO",
                            referencedColumnName = "ID_PERMISSAO",
                            foreignKey = @ForeignKey(
                                    name = "FK_PERFIL_PERMISSOES"
                            )
                    )
            }
    )
    @Builder.Default
    private Set<Permissao> permissoes = new LinkedHashSet<>();
}