package basic.api.dto;

import basic.api.domain.Regiao;

import javax.validation.constraints.NotEmpty;

public class regiaoDTO {

    private  Integer id;
    @NotEmpty(message = "preenchimento obrigatório")
    private String nome;

    public regiaoDTO(Regiao obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
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
}
