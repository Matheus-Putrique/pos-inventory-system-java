public class Produto {
    private int id;
    private String nome;
    private Double preco;
    private int estoque;

    public Produto(){}

    public Produto(int id, String nome, Double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean reduzirEstoque(int quantidade){
        if(this.estoque <= 0 || this.estoque < quantidade){
            return false;
        }
        this.estoque -= quantidade;
        return true;

    }

}
