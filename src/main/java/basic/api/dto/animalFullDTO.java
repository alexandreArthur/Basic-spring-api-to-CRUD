package basic.api.dto;

import javax.validation.constraints.NotEmpty;

public class animalFullDTO {
    @NotEmpty(message = "preenchimento obrigatório")
    private String nome;

    private Integer tipo;

    private Integer habitatID;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getHabitatID() {
        return habitatID;
    }

    public void setHabitatID(Integer habitatID) {
        this.habitatID = habitatID;
    }
}
