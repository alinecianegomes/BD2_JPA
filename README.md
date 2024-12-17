
# 📚 Bem-vindo

Bem-vindo ao repositório **ExemploTransacoesHibernate**! Este projeto demonstra o uso de múltiplas unidades de persistência com JPA e Hibernate. O objetivo é fornecer um exemplo prático de como gerenciar transações, isolar dados e utilizar estratégias de carregamento (eager e lazy loading) em Java.

## 🛠️ Funcionalidades

- **Gerenciamento de Transações**: Demonstra como iniciar, comitar e fazer rollback de transações.
- **Múltiplas Unidades de Persistência**: Exemplo de configuração e uso de diferentes unidades de persistência para entidades distintas.
- **Carregamento Eager e Lazy**: Implementação de estratégias de carregamento para otimizar o desempenho do sistema.
- **Isolamento de Dados**: Exemplos de como manter a integridade e consistência dos dados em diferentes contextos de persistência.

## 📂 Estrutura do Projeto

- **br.com.AulaJPA**
  - `Comercio.java`
  - `Servico.java`
  - `Aluguel.java`
  - `Avaliacao.java`
  - `Post.java`
  - `Comentario.java`
  - `Main.java`

## 🚀 Como Usar

1. **Clone o Repositório**:
    ```sh
    git clone git@github.com:MarcilioFreiitas/gerenciador-de-trasacao-banco-de-dados.git
    ```

2. **Importe o Projeto**:
    - Abra o projeto em sua IDE Java favorita (como IntelliJ IDEA ou Eclipse).

3. **Configure o Banco de Dados**:
    - O projeto está configurado para usar o banco de dados H2 em memória. Nenhuma configuração adicional é necessária.

4. **Execute a Classe `Main`**:
    - A classe `Main` contém exemplos de criação e persistência de entidades, bem como demonstrações de gerenciamento de transações.

## 📝 Exemplos de Uso

- **Criar e Persistir Entidades**:
    ```java
    // Criar instâncias de entidades e persistir
    Comercio comercio = new Comercio();
    comercio.setNome("La Bella");
    comercio.setCategoria("Restaurante");
    // ... mais configurações

    em.persist(comercio);
    ```

- **Gerenciamento de Transações**:
    ```java
    em.getTransaction().begin();
    try {
        // Operações de banco de dados
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
    }
    ```


