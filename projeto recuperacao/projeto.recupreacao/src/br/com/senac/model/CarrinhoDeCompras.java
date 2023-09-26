package br.com.senac.model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
        private List<ItensPedidoModel> itensDoCarrinho;

        public CarrinhoDeCompras() {
            itensDoCarrinho = new ArrayList<>();
        }

    public void adicionarItemAoCarrinho(int produtoId, int quantidade, double precoUnitario) {
        // Verifique se o item já está no carrinho
        for (ItensPedidoModel item : itensDoCarrinho) {
            if (item.getProdutoid() == produtoId) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return; // O item já está no carrinho, então saia do método
            }
        }

        // Se o item não está no carrinho, crie um novo ItemPedido e adicione ao carrinho
        ItensPedidoModel novoItem = new ItensPedidoModel();
        novoItem.setProdutoid(produtoId); // Define o produtoId usando o setter
        novoItem.setQuantidade(quantidade);
        novoItem.setProcoUnitario(precoUnitario);
        itensDoCarrinho.add(novoItem);
    }
    public void imprimirItensDoCarrinho() {
        for (ItensPedidoModel item : itensDoCarrinho) {
            System.out.println("Produto ID: " + item.getProdutoid());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Preço Unitário: " + item.getProcoUnitario());
            System.out.println("--------------------------");
        }
    }


    public List<ItensPedidoModel> getItensDoCarrinho() {
            return itensDoCarrinho;
         }
}
