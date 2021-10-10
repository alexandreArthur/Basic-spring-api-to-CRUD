package basic.api.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "habitat")
    private List<regiao> regioes = new ArrayList<>();

    public habitat() {
    }

    public habitat(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<regiao> getRegioes() {
        return regioes;
    }

    public void setRegioes(List<regiao> regioes) {
        this.regioes = regioes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        habitat habitat = (habitat) o;
        return Objects.equals(id, habitat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
