package br.com.projetocliente.model;

public class Carro {
    
    private Integer idCarro;
    private String marcaCarro;
    private String modeloCarro;
    private Integer anoCarro;
    private String corCarro;  

    public Carro() {
    }

    public Carro(Integer idCarro, String marcaCarro, String modeloCarro, Integer anoCarro, String corCarro) {
        this.idCarro = idCarro;
        this.marcaCarro = marcaCarro;
        this.modeloCarro = modeloCarro;
        this.anoCarro = anoCarro;
        this.corCarro = corCarro;
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public Integer getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(Integer anoCarro) {
        this.anoCarro = anoCarro;
    }

    public String getCorCarro() {
        return corCarro;
    }

    public void setCorCarro(String corCarro) {
        this.corCarro = corCarro;
    }

    public void setAnoCarro(String anoCarro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}