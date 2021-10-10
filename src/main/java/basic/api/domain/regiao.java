package basic.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="habitat_id")
    private Habitat habitat;

    public Regiao() {
    }

    public Regiao(Integer id, String nome, Habitat habitat) {
        this.id = id;
        this.nome = nome;
        this.habitat = habitat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regiao regioes = (Regiao) o;
        return Objects.equals(id, regioes.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
