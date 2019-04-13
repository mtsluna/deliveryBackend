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
https://apirestdelivery.herokuapp.com/api/v1/usuario/existemail/mtsluna@gmail.com
```
Respuesta:
```json
{
  "emailExist": "true"
}
```
En caso de que exista devuelve **true**, caso contrario devuelve **false**

