package basic.api.dto;

import javax.validation.constraints.NotEmpty;

public class animalNEWDTO {

    @NotEmpty(message = "preenchimento obrigatório")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
