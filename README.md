```
# 🍔 Mini-PDV & Totem de Autoatendimento - Lanchonete

Um sistema de Ponto de Venda (PDV) e autoatendimento desenvolvido em **Java**, aplicando conceitos fundamentais de **Programação Orientada a Objetos (POO)** e controle de regras de negócio em memória.

O sistema divide-se em três pilares principais:
1. **Totem de Autoatendimento (Cliente):** Seleção de produtos do cardápio, verificação em tempo real de estoque, montagem de comanda e fechamento de pedidos.
2. **Painel Operacional (Cozinha/Atendimento):** Fila de pedidos pendentes com despacho sequencial para entrega.
3. **Painel Gerencial (Administração):** Gestão completa do cardápio (CRUD de produtos) e ajuste de preços e estoque.

---

## 🛠️ Tecnologias e Conceitos Aplicados

- **Linguagem:** Java (JDK 17+)
- **Paradigma:** Orientação a Objetos (Encapsulamento, Abstração, Composição)
- **Estruturas de Dados:** `ArrayList` dinâmicos (`List<Produto>`, `List<Pedido>`, `List<Funcionario>`)
- **Controle de Acesso:** Enumeração (`enum Cargo`) e autenticação por credencial
- **Interface:** Console interativo via `java.util.Scanner`

---

## 📁 Estrutura de Classes

src/
├── Cargo.java            # Enum com os níveis de permissão (GERENTE, ATENDENTE, COZINHEIRO, etc.)
├── Funcionario.java      # Modelagem do colaborador e método de validação de senha
├── Produto.java          # Entidade de produto com controle e redução de estoque
├── ItemPedido.java       # Composição de produto e quantidade com cálculo de subtotal
├── Pedido.java           # Agrupador do pedido (número sequencial, cliente e cálculo total)
└── Main.java             # Ponto de entrada, loops de menu, roteamento de acesso e persistência em memória

---

## ⚙️ Regras de Negócio e Funcionalidades

### 1. Autoatendimento ao Cliente
- Solicitação de identificação do cliente.
- Exibição dinâmica do cardápio com identificadores, descrições, preços e estoques.
- **Validação de Estoque:** Impede a adição de itens caso a quantidade solicitada exceda a quantidade física disponível em estoque.
- Cálculo de subtotal por item e valor total acumulado da compra.
- Ao finalizar, o pedido gera uma comanda numerada e é despachado automaticamente para a fila da cozinha.

### 2. Controle de Acesso e Permissões
- O sistema autentica o funcionário através de senha cadastrada.
- O roteamento para o menu correto é feito com base no `Cargo`:
  - **Gerente / Chefe:** Acesso ao `menuGerencial`.
  - **Atendente / Cozinheiro:** Acesso ao `menuOperacional`.

### 3. Painel da Cozinha / Operacional
- Listagem dos pedidos em aberto aguardando preparo/entrega.
- Exibição detalhada de cada comanda (número, cliente, produtos e quantidades).
- Baixa/despacho do pedido por número identificador, liberando a fila da cozinha.

### 4. Painel Gerencial
- CRUD completo de produtos (cadastro, atualização de valores/estoque e exclusão).
- Visão gerencial dos itens cadastrados e monitoramento de estoque.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **Java Development Kit (JDK)** versão 17 ou superior instalada.
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code) ou terminal com `javac`.

### Executando pelo Terminal

1. Clone o repositório:
   git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
   cd SEU_REPOSITORIO

2. Compile os arquivos Java:
   javac -d bin src/*.java

3. Execute a aplicação:
   java -cp bin Main

---

## 🧪 Roteiro de Teste do Fluxo

1. **Pedido do Cliente:**
   - Selecione a opção `1` no menu principal.
   - Digite o nome do cliente.
   - Adicione produtos inserindo o código correspondente e a quantidade desejada.
   - Finalize a escolha digitando `0`.

2. **Despacho na Cozinha:**
   - Selecione a opção `2` no menu principal.
   - Digite a senha de um atendente/cozinheiro (ex: `1234`).
   - Acesse a opção `1` para visualizar o pedido na fila.
   - Acesse a opção `2`, digite o número da comanda e conclua o pedido.

3. **Gestão de Produtos:**
   - Acesse a área de colaboradores com a senha de gerente (ex: `admin`).
   - Visualize o estoque atualizado e gerencie os itens do cardápio.

---

## 📄 Licença

Este projeto foi desenvolvido para fins didáticos e de consolidação de fundamentos em desenvolvimento de software com Java. Sinta-se à vontade para utilizá-lo e adaptá-lo!

```
