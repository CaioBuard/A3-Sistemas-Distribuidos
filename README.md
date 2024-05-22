# API de Lista Telefônica

Esta é uma API REST para gerenciar uma lista telefônica.

## Endpoints

### /listaTelefones
- **Método:** GET
- **Descrição:** Retorna todos os registros de telefones presentes no banco de dados.

### /insereTelefone
- **Método:** POST
- **Descrição:** Insere um novo registro de telefone no banco de dados.
- **Corpo da Requisição:** Deve conter os dados do telefone a ser inserido.
```json
    {
        "nome": "",
        "sobrenome": "",
        "ddd": 0,
        "numero": 0
    }
```

### /remover/{id}
- **Método:** DELETE
- **Descrição:** Remove um registro de telefone no banco de dados com base no ID fornecido.
- **Parâmetros da URL:** ID do registro a ser removido.

### /atualizar/{id}
- **Método:** PUT
- **Descrição:** Atualiza um registro de telefone no banco de dados com base no ID fornecido.
- **Parâmetros da URL:** ID do registro a ser atualizado.
- **Corpo da Requisição:** Deve conter os novos dados do telefone.
```json
    {
        "nome": "",
        "sobrenome": "",
        "ddd": 0,
        "numero": 0
    }
```

