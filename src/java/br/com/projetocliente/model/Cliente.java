package br.com.projetocliente.model;

public class Cliente extends Pessoa{
    
    // criação de atributos da classe
    private Integer idCliente;
    private String telefoneCliente;
    private Profissao profissaoCliente; // pega uma profissão que já foi criada/cadastrada na classe Profissao

    // metodo construtor vázio
    public Cliente() {
    }

    public Cliente(Integer idCliente, String telefoneCliente, Profissao profissaoCliente) {
        this.idCliente = idCliente;
        this.telefoneCliente = telefoneCliente;
        this.profissaoCliente = profissaoCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public Profissao getProfissaoCliente() {
        return profissaoCliente;
    }

    public void setProfissaoCliente(Profissao profissaoCliente) {
        this.profissaoCliente = profissaoCliente;
    }
}
    