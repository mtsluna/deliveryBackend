# Delivery Backend

'Delivery Backend' es una API REST de administración de datos para un sistema de delivery.

## Comunicación con la API

Para utilizar esta API REST realiza una petición a la siguiente URL:

```URL
https://apirestdelivery.herokuapp.com/
```

## Uso

Su uso es muy simple, puedes utilizar los siguientes verbos HTTP:

```
GET, POST, PUT, DELETE
```

En la URL debes indicar la entidad a utilizar. Como por ejemplo:

```
https://apirestdelivery.herokuapp.com/demostracion/
```

Donde 'demostracion' es la entidad a ser utilizada. Ten en cuenta que ante el uso de DELETE, PUT o GET (Unica entidad) debes de utilizar una varible del path. Un ejemplo claro seria:

```
https://apirestdelivery.herokuapp.com/demostracion/{id}
```

## Devoluciones

Toda información devuelta por el servidor es de tipo:

```
application/json
```

Y contendra una estructura similiar a esta:

```json
{
  "demostracion": {
    "id": 1
  }
}
```

## Documentacion de funcionalidades especiales

**Consulta de email**

Petición HTTP:
```
curl -GET https://apirestdelivery.herokuapp.com/api/v1/usuario/existemail/mtsluna@gmail.com
```
Respuesta:
```json
{
  "emailExist": "true"
}
```
En caso de que exista devuelve **true**, caso contrario devuelve **false**

**Obtener usuario cliente por email**

Petición HTTP:
```
curl -GET https://apirestdelivery.herokuapp.com/api/v1/usuariocliente/searchByEmail/mtsluna@gmail.com
```
Respuesta:
```json
{
  "id": 35,
  "email": "mtsluna@gmail.com",
  "dni": "41659894",
  "nombre": "Matías",
  "apellido": "Luna",
  "telefono": 2615109127,
  "password": "mtsluna",
  "domicilio": {
    "id": 10,
    "calle": "Chacabuco",
    "numero": "441",
    "piso": 1,
    "departamento": 24,
    "latitud": -32.877888,
    "longitud": -68.830151,
    "localidad": {
      "id": 12,
      "nombre": null,
      "provincia": {
        "id": 2,
        "nombre": null,
        "pais": null
      }
    },
    "cp": "5500"
  },
  "imagen": {
    "id": 15,
    "url": null
  },
  "fechaNacimiento": "1999-01-18",
  "sexo": "Masculino",
  "comprobantes": []
}
```

**Obtener insumos o no**

Petición HTTP:
```
curl -GET https://apirestdelivery.herokuapp.com/api/v1/articulo/esInsumo/{boolean}
```
Respuesta:
```json
[
  {
    "id": 1,
    "nombre": "Harina 0000",
    "descripcion": "harina tipo 0000 Pureza",
    "precioCompra": 35,
    "stock": 25,
    "stockMinimo": 10,
    "stockMaximo": 50,
    "esInsumo": false,
    "precioVenta": 0,
    "categoria": {
      "id": 7,
      "nombre": "Cereales",
      "descripcion": "Los cereales son plantas de la familia de las poáceas cultivadas "
    },
    "unidadMedida": {
      "id": 1,
      "nombre": "kilo",
      "abreviatura": "KG"
    },
    "imagen": {
      "id": 21,
      "url": "https://geant.vteximg.com.br/arquivos/ids/214995-1000-1000/673705.jpg?v=636564496761500000"
    }
  }
]
```
