package br.com.projetocliente.model;

public class Profissao {
    private Integer IdProfissao;
    private String nomeProfissao;

    public Profissao() {
    }

    public Profissao(Integer IdProfissao) {
        this.IdProfissao = IdProfissao;
    }

    public Profissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }
    

    public Profissao(Integer IdProfissao, String nomeProfissao) {
        this.IdProfissao = IdProfissao;
        this.nomeProfissao = nomeProfissao;
    }

    public Integer getIdProfissao() {
        return IdProfissao;
    }

    public void setIdProfissao(Integer IdProfissao) {
        this.IdProfissao = IdProfissao;
    }

    public String getNomeProfissao() {
        return nomeProfissao;
    }

    public void setNomeProfissao(String nomeProfissao) {
        this.nomeProfissao = nomeProfissao;
    }
    
    
}
