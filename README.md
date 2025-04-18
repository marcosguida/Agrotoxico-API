# Agrotoxico API
API de E-commerce agrotoxicos.

## Configuração
### Instalação
1. **Clonando o repositório:**
    ```bash
    git clone https://github.com/marcosguida/agrotoxico-api.git
    ```
2. **Navegue até o diretório do projeto:**
    ```bash
    cd agrotoxico-api
    ```
3. **Compile e execute o projeto:**
    ```bash
    mvn clean install
    mvn quarkus:dev
    ```
4. **Acesse a API:**  
    - Quarkus Dev UI: [http://localhost:8080](http://localhost:8080)

## ENUM
### Classe TipoFormulação
```plaintext
SOLUCAO,
SUSPENSAO,
EMULSAO,
GRANULADO
```

## Endpoints de Agrotoxico
### Recuperar Todos os Pesticidas
- **GET `/agrotoxico`**
  *Resposta:*
    ```json
    [
      {
        "id": 1,
        "nomeComercial": "AgroX",
        "tipoFormulacao": "SOLUCAO",
        "fabricante": {
          "id": 1,
          "nome": "Fabricante Example",
          "cnpj": "00.000.000/0001-00"
        }
      }
    ]
    ```

### Recuperar Pesticida por ID
- **GET `/agrotoxico/{id}`**
  *Resposta:*
    ```json
    {
      "id": 1,
      "nomeComercial": "AgroX",
      "tipoFormulacao": "SOLUCAO",
      "fabricante": {
        "id": 1,
        "nome": "Fabricante Example",
        "cnpj": "00.000.000/0001-00"
      }
    }
    ```

### Pesquisar Pesticidas por Nome Comercial
- **GET `/agrotoxico/nome/{nomeComercial}`**
  *Resposta:*
    ```json
    {
      "id": 1,
      "nomeComercial": "AgroX",
      "tipoFormulacao": "SOLUCAO",
      "fabricante": {
        "id": 1,
        "nome": "Fabricante Example",
        "cnpj": "00.000.000/0001-00"
      }
    }
    ```

### Pesquisar Pesticidas por Tipo de Formulação
- **GET `/agrotoxico/formulacao/{tipoFormulacao}`**
  *Resposta:*
    ```json
    [
      {
        "id": 1,
        "nomeComercial": "AgroX",
        "tipoFormulacao": "SOLUCAO",
        "fabricante": {
        "id": 1,
        "nome": "Fabricante Example",
        "cnpj": "00.000.000/0001-00"
        }
      }
    ]
    ```

### Criar Novo Pesticida
- **POST `/agrotoxico`**
  *Requisição:*
    ```json
    {
      "nomeComercial": "AgroX",
      "tipoFormulacao": "SOLUCAO",
      "fabricanteId": 1
    }
    ```
  *Resposta:*
    ```json
    {
      "id": 1,
      "nomeComercial": "AgroX",
      "tipoFormulacao": "SOLUCAO",
      "fabricante": {
        "id": 1,
        "nome": "Fabricante Example",
        "cnpj": "00.000.000/0001-00"
      }
    }
    ```

### Atualizar Pesticida
- **PUT `/agrotoxico/{id}`**
  *Requisição:*
    ```json
    {
      "nomeComercial": "AgroX Updated",
      "tipoFormulacao": "SUSPENSAO",
      "fabricanteId": 1
    }
    ```
  *Resposta:*
    ```json
    {
      "id": 1,
      "nomeComercial": "AgroX Updated",
      "tipoFormulacao": "SUSPENSAO",
      "fabricante": {
        "id": 1,
        "nome": "Fabricante Example",
        "cnpj": "00.000.000/0001-00"
      }
    }
    ```

### Excluir Pesticida
- **DELETE `/agrotoxico/{id}`**
  *Resposta:*
    ```
    Status code 204 No Content
    ```

## Endpoints de Fabricante
### Recuperar Todos os Fabricantes
- **GET `/fabricante`**
  *Resposta:*
    ```json
    [
      {
        "id": 1,
        "nome": "Fabricante Example",
        "cnpj": "00.000.000/0001-00"
      }
    ]
    ```

### Recuperar Fabricante por ID
- **GET `/fabricante/{id}`**
  *Resposta:*
    ```json
    {
      "id": 1,
      "nome": "Fabricante Example",
      "cnpj": "00.000.000/0001-00"
    }
    ```

### Pesquisar Fabricantes por Nome
- **GET `/fabricante/nome/{nome}`**
  *Resposta:*
    ```json
    [
      {
        "id": 1,
        "nome": "Fabricante Example",
        "cnpj": "00.000.000/0001-00"
      }
    ]
    ```

### Criar Novo Fabricante
- **POST `/fabricante`**
  *Requisição:*
    ```json
    {
      "nome": "New Fabricante",
      "cnpj": "00.000.000/0001-11"
    }
    ```
  *Resposta:*
    ```json
    {
      "id": 2,
      "nome": "New Fabricante",
      "cnpj": "00.000.000/0001-11"
    }
    ```

### Atualizar Fabricante
- **PUT `/fabricante/{id}`**
  *Requisição:*
    ```json
    {
      "nome": "Updated Fabricante",
      "cnpj": "00.000.000/0001-22"
    }
    ```
  *Resposta:*
    ```json
    {
      "id": 2,
      "nome": "Updated Fabricante",
      "cnpj": "00.000.000/0001-22"
    }
    ```

### Excluir Fabricante
- **DELETE `/fabricante/{id}`**
  *Resposta:*
    ```
    Status code 204 No Content
    ```

## Restrições de Validação
- Nome Comercial (Agrotoxico): `Não pode estar em branco`
- Tipo de Formulação (Agrotoxico): `Não pode ser nulo`
- ID do Fabricante (Agrotoxico): `Não pode ser nulo`
- Nome do Fabricante: `Não pode estar em branco`
- CNPJ do Fabricante: `Não pode estar em branco`

## Endpoints de Estoque
### Recuperar Todos os Registros de Estoque
- **GET `/estoque`**
  *Resposta:*
    ```json
    [
      {
        "id": 1,
        "agrotoxicoId": 1,
        "quantidade": 100,
        "dataValidade": "2025-12-31"
      }
    ]
    ```

### Recuperar Registro de Estoque por ID
- **GET `/estoque/{id}`**
  *Resposta:*
    ```json
    {
      "id": 1,
      "agrotoxicoId": 1,
      "quantidade": 100,
      "dataValidade": "2025-12-31"
    }
    ```

### Pesquisar Registros de Estoque por ID do Pesticida
- **GET `/estoque/agrotoxico/{agrotoxicoId}`**
  *Resposta:*
    ```json
    [
      {
        "id": 1,
        "agrotoxicoId": 1,
        "quantidade": 100,
        "dataValidade": "2025-12-31"
      }
    ]
    ```

### Criar Novo Registro de Estoque
- **POST `/estoque`**
  *Requisição:*
    ```json
    {
      "agrotoxicoId": 1,
      "quantidade": 100,
      "dataValidade": "2025-12-31"
    }
    ```
  *Resposta:*
    ```json
    {
      "id": 1,
      "agrotoxicoId": 1,
      "quantidade": 100,
      "dataValidade": "2025-12-31"
    }
    ```

### Atualizar Registro de Estoque
- **PUT `/estoque/{id}`**
  *Requisição:*
    ```json
    {
      "agrotoxicoId": 1,
      "quantidade": 150,
      "dataValidade": "2026-01-31"
    }
    ```
  *Resposta:*
    ```json
    {
      "id": 1,
      "agrotoxicoId": 1,
      "quantidade": 150,
      "dataValidade": "2026-01-31"
    }
    ```

### Excluir Registro de Estoque
- **DELETE `/estoque/{id}`**
  *Resposta:*
    ```
    Status code 204 No Content
    ```

## Endpoints de Fornecedor
### Recuperar Todos os Fornecedores
- **GET `/fornecedor`**
  *Resposta:*
    ```json
    [
      {
        "id": 1,
        "nome": "Fornecedor Example",
        "cnpj": "00.000.000/0001-01"
      }
    ]
    ```

### Recuperar Fornecedor por ID
- **GET `/fornecedor/{id}`**
  *Resposta:*
    ```json
    {
      "id": 1,
      "nome": "Fornecedor Example",
      "cnpj": "00.000.000/0001-01"
    }
    ```

### Pesquisar Fornecedores por Nome
- **GET `/fornecedor/nome/{nome}`**
  *Resposta:*
    ```json
    [
      {
        "id": 1,
        "nome": "Fornecedor Example",
        "cnpj": "00.000.000/0001-01"
      }
    ]
    ```

### Criar Novo Fornecedor
- **POST `/fornecedor`**
  *Requisição:*
    ```json
    {
      "nome": "New Fornecedor",
      "cnpj": "00.000.000/0001-12"
    }
    ```
  *Resposta:*
    ```json
    {
      "id": 2,
      "nome": "New Fornecedor",
      "cnpj": "00.000.000/0001-12"
    }
    ```

### Atualizar Fornecedor
- **PUT `/fornecedor/{id}`**
  *Requisição:*
    ```json
    {
      "nome": "Updated Fornecedor",
      "cnpj": "00.000.000/0001-23"
    }
    ```
  *Resposta:*
    ```json
    {
      "id": 2,
      "nome": "Updated Fornecedor",
      "cnpj": "00.000.000/0001-23"
    }
    ```

### Excluir Fornecedor
- **DELETE `/fornecedor/{id}`**
  *Resposta:*
    ```
    Status code 204 No Content
    ```

## Autor
Marcos Ribeiro Guida
