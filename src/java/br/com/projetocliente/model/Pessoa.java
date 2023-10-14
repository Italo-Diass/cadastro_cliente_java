package br.com.projetocliente.model;


public class Pessoa {
    
    private Integer idPessoa;
    private String nomePessoa;
    private String enderecoPessoa;
    private String cidadePessoa;
    private String estadoPessoa;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nomePessoa, String enderecoPessoa, String cidadePessoa, String estadoPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.enderecoPessoa = enderecoPessoa;
        this.cidadePessoa = cidadePessoa;
        this.estadoPessoa = estadoPessoa;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public String getCidadePessoa() {
        return cidadePessoa;
    }

    public void setCidadePessoa(String cidadePessoa) {
        this.cidadePessoa = cidadePessoa;
    }

    public String getEstadoPessoa() {
        return estadoPessoa;
    }

    public void setEstadoPessoa(String estadoPessoa) {
        this.estadoPessoa = estadoPessoa;
    }
    
    
    
}
