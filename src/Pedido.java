import java.util.ArrayList;
import java.util.List;

public class Pedido{
    private int numero;
    private String cliente;
    private List<ItemPedido> itens;

    public Pedido(int numero, String cliente, List<ItemPedido> itens) {
        this.numero = numero;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }
    public boolean adicionarItem(ItemPedido item){
        boolean estoqueQuantidade = item.getProduto().reduzirEstoque(item.getQuantidade());

        if(!estoqueQuantidade){
            System.out.println("Estoque insuficiente para: " + item.getProduto().getNome());
            System.out.println("Quantidade existente: " + item.getProduto().getEstoque());
            return false;
        }

         this.itens.add(item);
        return true;
    }
    public double calcularTotal(){
        double total = 0;
        for(ItemPedido item : this.itens){
            total += item.subTotal();
        }
        return total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}