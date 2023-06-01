# visibility-algorithm

El proyecto "visibility-algorithm" implementa un algoritmo de filtrado para mostrar productos en una parrilla de comercio electrónico. Filtra los productos según las existencias disponibles en diferentes tallas y considera casos especiales como productos "back soon" y tallas "especiales".

## Requisitos previos

- Java 17
- Maven
- Base de datos H2 (se genera automáticamente)

## Configuración del proyecto

1. Clona el repositorio: `git clone https://github.com/heredikal/visibility-algorithm.git`
2. Navega hasta el directorio del proyecto: `cd visibility-algorithm`

## Configuración del entorno

- Abre el archivo `application.properties` en la carpeta `src/main/resources` para modificar los parámetros de configuración según tus necesidades.
- Asegúrate de tener la configuración correcta para la base de datos H2. Si es necesario, modifica las propiedades de conexión, como la URL, el nombre de usuario y la contraseña.

## Ejecución del proyecto

1. Ejecuta el siguiente comando para compilar y ejecutar el proyecto: `mvn spring-boot:run`
2. El proyecto se ejecutará en `http://localhost:8080`.

## Acceso a Swagger

- Accede a Swagger UI para explorar y probar los endpoints de la API en: `http://localhost:8080/swagger-ui/index.html`

## Acceso a H2 Console

Puedes acceder a H2 Console utilizando la siguiente URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console). Asegúrate de que la aplicación esté en ejecución antes de acceder a la consola.

## Uso

1. El proyecto expone varios endpoints de API para obtener productos filtrados según las existencias.
2. Utiliza el endpoint adecuado según tus necesidades para obtener la lista de productos filtrados.

## Estructura del proyecto

- `src/main/java`: Contiene los archivos fuente de Java del proyecto.
- `src/main/resources`: Contiene los archivos de configuración, como `application.properties`.
- `src/main/resources/db/migration`: Contiene los scripts de migración de Flyway para crear y actualizar la base de datos.

## Dependencias

- Spring Boot
- Spring Data JPA
- H2 Database
- Flyway
- ModelMapper

## Información adicional

Para obtener más información sobre el proyecto, puedes consultar la documentación de Swagger y revisar el código fuente del proyecto.

## Licencia

Este proyecto se distribuye bajo la [Licencia MIT](https://opensource.org/licenses/MIT).
