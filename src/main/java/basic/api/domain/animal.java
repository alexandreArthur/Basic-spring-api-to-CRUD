package basic.api.domain;

import basic.api.enums.Tipo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nome;
    private  Integer tipo;

    @OneToOne
    @JoinColumn(name="habitat_id")
    private Habitat habitat;


    public Animal(){}

    public Animal(Integer id, String nome, Habitat habitat, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.habitat = habitat;
        this.tipo = (tipo==null) ? null : tipo.getCod();

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

    public Tipo getTipo() {
        return Tipo.toEnum(tipo);
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
