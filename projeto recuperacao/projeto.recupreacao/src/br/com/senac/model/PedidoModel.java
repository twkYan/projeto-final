package br.com.senac.model;

import java.util.List;

public class PedidoModel {
    private int id;
    private String formaPag;
    private List<ItensPedidoModel> itens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    public List<ItensPedidoModel> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedidoModel> itens) {
        this.itens = itens;
    }
}
