# Agrotoxico API
Comprehensive API for managing pesticides and manufacturers, enabling consultation, creation, updating, and removal of records with various filtering options.

## Configuration
### Installation
1. Cloning:
    ```bash
    git clone https://github.com/marcosguida/agrotoxico-api.git
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
```enum
SOLUCAO,
SUSPENSAO,
EMULSAO,
GRANULADO
```

## Agrotoxico Endpoints
### Retrieve All Pesticides
- **GET `/api/agrotoxico`**
*Response:*
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

### Retrieve Pesticide by ID
- **GET `/api/agrotoxico/{id}`**
*Response:*
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

### Search Pesticides by Commercial Name
- **GET `/api/agrotoxico/nome/{nomeComercial}`**
*Response:*
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

### Search Pesticides by Formulation Type
- **GET `/api/agrotoxico/formulacao/{tipoFormulacao}`**
*Response:*
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

### Create New Pesticide
- **POST `/api/agrotoxico`**
*Request:*
```json
{
  "nomeComercial": "AgroX",
  "tipoFormulacao": "SOLUCAO",
  "fabricanteId": 1
}
```
*Response:*
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

### Update Pesticide
- **PUT `/api/agrotoxico/{id}`**
*Request:*
```json
{
  "nomeComercial": "AgroX Updated",
  "tipoFormulacao": "SUSPENSAO",
  "fabricanteId": 1
}
```
*Response:*
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

### Delete Pesticide
- **DELETE `/api/agrotoxico/{id}`**
*Response:*
``Status code 204 No Content``

## Fabricante (Manufacturer) Endpoints
### Retrieve All Manufacturers
- **GET `/api/fabricante`**
*Response:*
```json
[
  {
    "id": 1,
    "nome": "Fabricante Example",
    "cnpj": "00.000.000/0001-00"
  }
]
```

### Retrieve Manufacturer by ID
- **GET `/api/fabricante/{id}`**
*Response:*
```json
{
  "id": 1,
  "nome": "Fabricante Example",
  "cnpj": "00.000.000/0001-00"
}
```

### Search Manufacturers by Name
- **GET `/api/fabricante/nome/{nome}`**
*Response:*
```json
[
  {
    "id": 1,
    "nome": "Fabricante Example",
    "cnpj": "00.000.000/0001-00"
  }
]
```

### Create New Manufacturer
- **POST `/api/fabricante`**
*Request:*
```json
{
  "nome": "New Fabricante",
  "cnpj": "00.000.000/0001-11"
}
```
*Response:*
```json
{
  "id": 2,
  "nome": "New Fabricante",
  "cnpj": "00.000.000/0001-11"
}
```

### Update Manufacturer
- **PUT `/api/fabricante/{id}`**
*Request:*
```json
{
  "nome": "Updated Fabricante",
  "cnpj": "00.000.000/0001-22"
}
```
*Response:*
```json
{
  "id": 2,
  "nome": "Updated Fabricante",
  "cnpj": "00.000.000/0001-22"
}
```

### Delete Manufacturer
- **DELETE `/api/fabricante/{id}`**
*Response:*
``Status code 204 No Content``

## Validation Constraints
- Commercial Name (Agrotoxico): Cannot be blank
- Formulation Type (Agrotoxico): Cannot be null
- Manufacturer ID (Agrotoxico): Cannot be null
- Manufacturer Name: Cannot be blank
- Manufacturer CNPJ: Cannot be blank

## Author
<table>
    <tr>
        <td align="center">
            <a href="#">
                <img src="https://avatars.githubusercontent.com/u/105091587?s=96&v=4" width="100px;" alt="Marcos Ribeiro Profile Picture"/><br>
                <sub>
                    <b>MARCOS RIBEIRO GUIDA</b>
                </sub>
            </a>
        </td>
    </tr>
</table>
