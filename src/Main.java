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

    private static void exibirCardapio(){
        System.out.println("\n----------------- CARDÁPIO COMPLETO -----------------");
        System.out.printf("%-5s %-25s %-10s %-8s\n", "ID", "NOME", "PREÇO", "ESTOQUE");
        System.out.println("-----------------------------------------------------");
        for (Produto p : cardapio) {
            System.out.printf("%-5d %-25s R$ %-7.2f %-8d\n",
                    p.getId(), p.getNome(), p.getPreco(), p.getEstoque());
        }
        System.out.println("-----------------------------------------------------");
    }

    //Menu que Cozinheiros e Atendentes usam
    private static void menuOperacional(Funcionario funcionario, Scanner scanner){
        boolean executando = true;

        while(executando){
            System.out.println("Menu de operação:");
            System.out.println("Funcionário: " + funcionario.getNome());
            System.out.println("1- Exibir cardápio disponível");
            System.out.println("2- Sair do painel");
            System.out.println("Selecione o opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:
                    exibirCardapio();
                    break;

                case 2:
                    System.out.println("Saindo do sistema... ");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
    // Menu para Gerentes e Chefe
    private static void menuGerencial(Funcionario funcionario, Scanner scanner){
        boolean executando = true;

        while(executando){
            System.out.println("Menu Gerencial:");
            System.out.println("Funcionário: " + funcionario.getNome());
            System.out.println("1- Exibir cardápio disponível");
            System.out.println("2- Repor estoque");
            System.out.println("3- Sair do painel");
            System.out.println("Selecione o opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){

                case 1:
                    exibirCardapio();
                    break;

                case 2:
                    reporEstoque(scanner);
                    break;

                case 3:
                    System.out.println("Saindo do sistema...");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void rotearMenu(Funcionario funcionario, Scanner scanner){
        switch(funcionario.getCargo()){
            case CHEFE:
            case GERENTE:
                menuGerencial(funcionario, scanner);
                break;

            case ATENDENTE:
            case COZINHEIRO:
                menuOperacional(funcionario, scanner);
                break;

            default:
                System.out.println("Perfil não configurado");
        }
    }

    private static void loginFuncionarios(Scanner scanner){
        System.out.println("Tela de Login");
        System.out.println("Matrícula ou nome: ");
        String registro = scanner.nextLine();

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        Funcionario encontrado = null;

        for(Funcionario f : funcionarios){
            if(f.getMatricula().equalsIgnoreCase(registro) || f.getNome().equalsIgnoreCase(registro)){
                encontrado = f;
                break;
            }

        }
        if(encontrado != null && encontrado.autenticar(senha)){
            System.out.println("Bem-vindo " + encontrado.getNome() + " Cargo: " + encontrado.getCargo());

            rotearMenu(encontrado, scanner);
        }
        else{
            System.out.println(" Matrícula/nome ou senha incorretos!");
        }
    }

    private static void reporEstoque(Scanner scanner){
        exibirCardapio();

        System.out.println("Escreva o código que deseja repor: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto produtoEncontrado = buscarProdutoId(codigo);

        if(produtoEncontrado == null){
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.println("Quantidade adicionada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if(produtoEncontrado.adicionarEstoque(quantidade)){

            System.out.println("Quantidade atualizada: " + produtoEncontrado.getNome() + " Estoque: " + produtoEncontrado.getEstoque());
        }
        else{
            System.out.println("Erro!! Quantidade tem que ser maior que 0");
        }
    }

    private static void adicionarProduto(Scanner scanner){
        System.out.println("CADASTRO DE PRODUTO");
        System.out.println("Código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        if(buscarProdutoId(codigo) != null){
            System.out.println("Erro, Código já existente!!");
            return;
        }

        System.out.println("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.println("Preco do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Quantidade adicionada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Produto novoProduto = new Produto(codigo, nome, preco, quantidade);

        cardapio.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void editarProduto(Scanner scanner){
        System.out.println("EDITOR DE PRODUTO");

        exibirCardapio();

        System.out.println("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto produto = buscarProdutoId(codigo);

        if(produto == null){
            System.out.println("Código não encontrado!");
            return;
        }

        System.out.println("O que deseja alterar no produto: ");
        System.out.println("1- Nome do produto");
        System.out.println("2- Preco do produto");
        System.out.println("3- Sair");
        System.out.println("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){

            case 1:
                System.out.println("Digite o novo nome do produto: ");
                String nome = scanner.nextLine();
                produto.setNome(nome);
                break;

            case 2:
                System.out.println("Digite o novo preco do produto: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();
                produto.setPreco(preco);
                break;

            case 3:
                return;

            default:
                System.out.println("Erro!!!");
                break;
        }

    }

    private static void excluirProduto(Scanner scanner){
        System.out.println("EXCLUIR PRODUTO");

        exibirCardapio();

        System.out.println("Digite o código do produto a se deletar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto produtoDeletar =  buscarProdutoId(codigo);

        if(produtoDeletar == null){
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.println("Tem certeza que deseja excluir?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        System.out.println("Opcao: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){

            case 1:
                cardapio.remove(produtoDeletar);
                System.out.println("Produto excluido com sucesso!");
                break;

            case 2:
                System.out.println("Exclusão cancelada!");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



    }

}
