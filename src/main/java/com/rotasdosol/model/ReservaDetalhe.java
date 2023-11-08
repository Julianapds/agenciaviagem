package com.rotasdosol.model;

public class ReservaDetalhe {
    private int id;
    private String tipo;
    private String descricao;
    private String destino;
    private String status;
    private String imagem;

    public ReservaDetalhe() {
    }

    public ReservaDetalhe(int id, String tipo, String descricao, String destino, String status, String imagem) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.destino = destino;
        this.status = status;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }



    @Override
    public String toString() {
        return "ReservaDetalhe{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", destino='" + destino + '\'' +
                ", status='" + status + '\'' +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}
