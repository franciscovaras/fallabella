# Falabella

Microservicio prueba para Falabella. Este microservicio es un CRUD Repository conectado a una base de datos h2 

# Ownership
| Rol               |     Nombre                                        |
|---                |---                                                |
| Arquitecto        |  Francisco Varas                                  |
| Líder técnico     |  Francisco Varas                                  |
| Product Owner     |  Francisco Varas                                  |

# End Points

| Nombre   | Ruta              | Descripción                                                       |
| findAll  | "/product/search" | Busca toda la data existente                                      |
| create   | "/product/create" | Crea un nuevo producto, recibe como parámetro el objeto Producto  |
| findById | "/search/{id}"    | Hace la búsqueda por id (sku) del producto                        |
| delete   | "/delete/{id}"    | Elimina el producto por id (sku)                                  |
| update   | "/update/{id}"    | Actualiza el Producto por id (sku)                                |


#BD
| Environment     |   valor                                                                                  |
| Url             |  http://localhost:8080/h2-console/login.jsp?jsessionid=6a1b5ec3b8668cb4f7ebde87d9cb7516  |
| jdbc URL        |  jdbc:h2:mem:productdb                                                                   |
| User Name       |  francisco                                                                               |
| Password        |  sa                                                                                      |
| puerto          |  8080                                                                                    |
