public class Funcionario {
    private String matricula;
    private String nome;
    private String senha;
    private Cargo cargo;

    public Funcionario(){}

    public Funcionario(String matricula, String nome, String senha, Cargo cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.cargo = cargo;
    }

    public boolean autenticar(String tentativaSenha){
        return this.senha.equals(tentativaSenha);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
