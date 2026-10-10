import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{

    private static List<Produto> cardapio = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();

    private static void carregarDadosInicias(){
        cardapio.add(new Produto(101, "Smash Clássico", 24.90, 15));
        cardapio.add(new Produto(102, "Double Cheddar Bacon", 34.50, 10));
        cardapio.add(new Produto(103, "Gorgonzola Crispy", 36.00, 8));
        cardapio.add(new Produto(104, "Barbecue Melt", 31.00, 12));
        cardapio.add(new Produto(105, "Smash Salad", 26.50, 6));

        //Acompanhamentos
        cardapio.add(new Produto(201, "Batata Rústica", 16.00, 20));
        cardapio.add(new Produto(202, "Onion Rings", 18.50, 10));
        //Bebidas
        cardapio.add(new Produto(301, "Refrigerante Lata", 7.00, 30));
        cardapio.add(new Produto(302, "Suco Lata", 6.00, 30));

        //Funcionários

        funcionarios.add(new Funcionario("C01", "Roberto Junior", "1234", Cargo.CHEFE));
        funcionarios.add(new Funcionario("F01", "João Mario", "2456", Cargo.ATENDENTE));
        funcionarios.add(new Funcionario("F02", "Ana Maria", "4569", Cargo.ATENDENTE));
        funcionarios.add(new Funcionario("G01", "Marta Robert", "9542", Cargo.GERENTE));
        funcionarios.add(new Funcionario("CO01", "Cleber Ariano", "1127", Cargo.COZINHEIRO));

    }
    private static Produto buscarProdutoId(int id){
        for(Produto p : cardapio){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    private static Produto buscarProdutoNome(String nome){
        for(Produto p : cardapio){
            if(p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
    }
    private static Funcionario buscarFuncionarioMatricula(String matricula){
        for(Funcionario f : funcionarios){
            if(f.getMatricula().equalsIgnoreCase(matricula)){
                return f;
            }
        }
        return null;
    }
    private static Funcionario buscarFuncionarioNome(String nome){
        for(Funcionario f : funcionarios){
            if(f.getNome().equalsIgnoreCase(nome)){
                return f;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



    }

}
