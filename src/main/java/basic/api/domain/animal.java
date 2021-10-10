package basic.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nome;

    @OneToOne
    @JoinColumn(name="habitat_id")
    private habitat habitat;

    public animal(){}

    public animal(Integer id, String nome, basic.api.domain.habitat habitat) {
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

    public basic.api.domain.habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(basic.api.domain.habitat habitat) {
        this.habitat = habitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        animal animal = (animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
