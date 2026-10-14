# 🍔 Burger House - Sistema PDV & Autoatendimento

Sistema de Ponto de Venda (PDV) e Totem de Autoatendimento desenvolvido em **Java puro (Console)**, simulando a operação completa de uma hamburgueria artesanal.

O projeto implementa regras de negócio para venda ao cliente, controle e baixa dinâmica de estoque, fila de preparo para a cozinha e painel administrativo com controle de acesso baseado em cargos (RBAC).

---

## 🚀 Funcionalidades

### 1. 🖥️ Totem de Autoatendimento (Cliente)
* Atendimento interativo com identificação do cliente.
* Consulta dinâmica ao cardápio com exibição de código, nome, preço e disponibilidade.
* Adição contínua de itens e validação de quantidade.
* **Validação de Estoque em Tempo Real:** impede a adição de produtos caso a quantidade solicitada exceda o estoque disponível.
* Geração automática de comanda sequencial com cálculo de subtotais e valor total da compra.
* Despacho automático da comanda para a fila da cozinha.

### 2. 👨‍🍳 Painel Operacional (Cozinha & Atendimento)
* Consulta à fila de pedidos pendentes em tempo real.
* Visualização detalhada de cada comanda (número do pedido, nome do cliente, itens e quantidades).
* Conclusão e entrega de pedidos, removendo-os da fila de produção.

### 3. 👔 Painel Gerencial (Administração)
* Acesso restrito via autenticação de colaboradores.
* **CRUD de Produtos:**
  * Cadastro de novos lanches, acompanhamentos e bebidas.
  * Edição de preços e reposição de estoque.
  * Exclusão e listagem de produtos.

---

## 🏛️ Arquitetura e Modelagem

O sistema foi concebido aplicando princípios fundamentais da **Programação Orientada a Objetos (POO)**:
* **Encapsulamento:** atributos privados protegidos por getters, setters e métodos de negócio.
* **Separação de Responsabilidades:** separação clara entre modelos de dados (`Produto`, `ItemPedido`, `Pedido`, `Funcionario`), regras de negócio e controle de interface de console.
* **Estrutura de Dados em Memória:** gerenciamento de cardápio, colaboradores e pedidos pendentes via `java.util.List` (`ArrayList`).

### Diagrama Conceitual das Classes

```text
       ┌───────────┐         1..* ┌────────────┐         1 ┌─────────┐
       │  Pedido   │◇────────────│ ItemPedido │───────────▶│ Produto │
       └───────────┘              └────────────┘           └─────────┘
             │
             │ (Encaminhado para)
             ▼
     [pedidosPendentes] ◀── [menuOperacional]
                                   │
                             (Autentica)
                                   ▼
                           ┌──────────────┐          ┌─────────┐
                           │ Funcionario  │─────────▶│  Cargo  │ (Enum)
                           └──────────────┘          └─────────┘
```

---

## 🔐 Controle de Acesso (Perfis)

A autenticação direciona dinamicamente a tela conforme o cargo do colaborador:

| Cargo | Permissões | Menu de Acesso |
| :--- | :--- | :--- |
| `GERENTE` / `CHEFE` | Acesso total ao estoque, edição de produtos e visão gerencial | `menuGerencial` |
| `COZINHEIRO` / `ATENDENTE` | Visualização de comandas e baixa de pedidos na fila | `menuOperacional` |

---

## 💻 Pré-requisitos e Execução

### Pré-requisitos
* **Java JDK 17** ou superior instalado.
* IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code) ou terminal com `javac`.

### Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/burger-house-pdv.git
   cd burger-house-pdv
   ```

2. Compile os arquivos Java:
   ```bash
   javac *.java
   ```

3. Execute a aplicação:
   ```bash
   java Main
   ```

---

## 🧪 Roteiro de Demonstração

1. **Faça um pedido:** Selecione a opção `1` no menu inicial, monte uma comanda com itens do cardápio e finalize para conferir a comanda gerada.
2. **Despache na Cozinha:** Acesse a opção `2`, entre com a credencial de cozinheiro/atendente e confira a comanda na fila de pedidos pendentes para despachá-la.
3. **Gestão de Estoque:** Acesse a opção `2` com a credencial gerencial para consultar a dedução automática das quantidades em estoque ou cadastrar novos produtos.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **Paradigma:** Orientação a Objetos (POO)
* **Interface:** Linha de Comando (CLI)

---

## 📄 Licença

Este projeto foi desenvolvido para fins didáticos e práticos de Engenharia de Software e Programação Orientada a Objetos. Sinta-se livre para utilizar, modificar e expandir!