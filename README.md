# Agrotoxico API

API for managing pesticides, enabling the consultation, creation, updating, and removal of records, as well as filtered queries by commercial name and formulation type.

## Configuration

### Installation

1. Cloning:

    ```bash
    git clone [https://github.com/marcosguida/agrotoxico-api.git](https://github.com/marcosguida/agrotoxico-api.git)
    ```

2. Navigate to the project directory:

    ```bash
    cd agrotoxico-api
    ```

3. Compile and run the project:

    ```bash
    mvn clean install
    mvn quarkus:dev
    ```
    
4. Access the API - Quarkus Dev UI http://localhost:8080

## ENUM

### Class TipoFormulação

```ENUM
    SOLUCAO,
    SUSPENSAO,
    EMULSAO,
    GRANULADO
```
## Endpoints

### `GET /api/agrotoxico`

Returns a list of all registered pesticides.

*Response:*

```json
[
  {
    "id": 1,
    "nomeComercial": "AgroX",
    "tipoFormulacao": "SOLUCAO"
  }
]
```

### `GET /api/agrotoxico/{id}`

*Response:*

```JSON

{
  "id": 1,
  "nomeComercial": "AgroX",
  "tipoFormulacao": "SOLUCAO"
}

```

### `GET /api/agrotoxico/nome/{nomeComercial}`

*Response:*

```JSON

[
  {
    "id": 1,
    "nomeComercial": "AgroX",
    "tipoFormulacao": "SOLUCAO"
  }
]
```

### `GET /api/agrotoxico/formulacao/{tipoFormulacao}`

tipoFormulacao: The formulation type (e.g., SOLUCAO, SUSPENSAO).

*Response:*

```JSON

[
  {
    "id": 1,
    "nomeComercial": "AgroX",
    "tipoFormulacao": "SOLUCAO"
  }
]
```
### `POST /api/agrotoxico`

*Request:*

```JSON

{
  "nomeComercial": "AgroX",
  "tipoFormulacao": "SOLUCAO"
}

```
*Response:*

```JSON

{
  "id": 1,
  "nomeComercial": "AgroX",
  "tipoFormulacao": "SOLUCAO"
}
```

### `PUT /api/agrotoxico/{id}`

*Request:*

```JSON

{
  "nomeComercial": "AgroX Updated",
  "tipoFormulacao": "SUSPENSAO"
}
```

*Response:*

```JSON

{
  "id": 1,
  "nomeComercial": "AgroX Updated",
  "tipoFormulacao": "SUSPENSAO"
}
```

### `DELETE /api/agrotoxico/{id}`

*Response:*

``Status code 204 No Content``

<table>
    @Autor
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/105091587?s=96&v=4" width="100px;" alt="Marcos Ribeiro Profile Picture"/><br>
        <sub>
          <b>MARCOS RIBEIRO GUIDA</b>
        </sub>
      </a>
    </td>
