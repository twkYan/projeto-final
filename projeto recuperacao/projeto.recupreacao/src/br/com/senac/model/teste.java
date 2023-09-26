package br.com.senac.model;
import br.com.senac.model.CarrinhoDeCompras;

public class teste {
    public static void main(String[] args) {
        CarrinhoDeCompras carrino = new CarrinhoDeCompras();
        carrino.adicionarItemAoCarrinho(1,2,4.0);
        System.out.println(carrino);
    }


}
