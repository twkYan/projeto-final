package br.com.senac.view;

import br.com.senac.DAO.ProdutoDAO;
import br.com.senac.DAO.itenspedidoDAO;
import br.com.senac.DAO.pedidoDAO;
import br.com.senac.model.CarrinhoDeCompras;
import br.com.senac.model.PedidoModel;
import br.com.senac.model.Produtomodel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaCompra {
    private JLabel JLBcarrinho;
    private JTextField tfproduto;
    private JLabel JLB2;
    private JPanel principal;
    private JTextField tfquantidade;
    private JButton ADICIONARButton;
    private JTable table1;
    private JCheckBox cartaoCheckBox;
    private JCheckBox dinheiroCheckBox;
    private JCheckBox pixCheckBox;
    private JButton COMPRARButton;
    private JLabel formalabel;
    private JLabel jlqua;

    private DefaultTableModel modeltable;

    public TelaCompra(){
        modeltable = new DefaultTableModel();
        modeltable.addColumn("id_produto");
        modeltable.addColumn("nome");
        modeltable.addColumn("quantidade");
        modeltable.addColumn("preco_unitario");
        modeltable.addColumn("preco_total");
        ButtonGroup bg = new ButtonGroup();
        bg.add(cartaoCheckBox);
        bg.add(dinheiroCheckBox);
        bg.add(pixCheckBox);

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        ADICIONARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tfproduto.getText());
                int quantidade = Integer.parseInt(tfquantidade.getText());
                double precoUnitarioz;



                try {
                    for (Produtomodel pm: ProdutoDAO.obterProdutos(id)) {
                        precoUnitarioz= pm.getPreco();
                        carrinho.adicionarItemAoCarrinho(pm.getId(),quantidade,precoUnitarioz);
                        carrinho.imprimirItensDoCarrinho();
                        double precoTotal= quantidade*precoUnitarioz;
                        modeltable.addRow(new Object[]{pm.getId(), pm.getDescricao(), quantidade, pm.getPreco(), precoTotal});
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


                table1.setModel(modeltable);
            }
        });
        COMPRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PedidoModel pedido = new PedidoModel();
                String forma="";
                if(bg.getSelection()!= null){
                    if(dinheiroCheckBox.isSelected()){
                    forma = "dinheiro";
                    } else if(cartaoCheckBox.isSelected()){
                    forma = "cartao";
                    }else if(pixCheckBox.isSelected()){
                    forma= "pix";
                    }
                    try {
                        pedidoDAO.criaPedido(forma);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    itenspedidoDAO.salvar(carrinho.getItensDoCarrinho());
                }

            }
        });
    }





    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaCompra");
        frame.setContentPane(new TelaCompra().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
