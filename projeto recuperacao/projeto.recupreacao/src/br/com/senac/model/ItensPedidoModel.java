package br.com.senac.model;

public class ItensPedidoModel {
    int id;
    PedidoModel Pedidoid;
    int produtoid;
    int quantidade;
    double procoUnitario;

    public double getProcoUnitario() {
        return procoUnitario;
    }

    public void setProcoUnitario(double procoUnitario) {
        this.procoUnitario = procoUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PedidoModel getPedidoid() {
        return Pedidoid;
    }

    public void setPedidoid(PedidoModel pedidoid) {
        Pedidoid = pedidoid;
    }

    public int getProdutoid() {
        return produtoid;
    }

    public void setProdutoid(int produtoid) {
        this.produtoid = produtoid;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
