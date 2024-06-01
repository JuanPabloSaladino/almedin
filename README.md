# AlMedin
El siguiente proyecto se presenta como resolución al trabajo práctico propuesto por la academia Java-React (UMSA).

### Requisitos ❗❗
- Java 17
- Maven 3.9.5
- Base de Datos MySQL (es necesario que crear una Base de Datos MySQL con nombre "almedin")
- Es fundamental actualizar las propiedades ***quarkus.datasource.username*** y ***quarkus.datasource.password*** en la sección de conexión a la Base de Datos del archivo ***application.properties*** con las credenciales de nuestro MySQL Workbench local
  
### ¿Cómo levantar el proyecto de manera local? 🛠
1) mvn clean installl -DskipTests
2) mvn clean compile -DskipTests
3) mvn quarkus:dev
