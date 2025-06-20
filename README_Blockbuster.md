# 🎬 Blockbuster Fake - Aplicación de Alquiler de Películas

## 📌 Descripción del Proyecto

Aplicación web desarrollada como parte de la evaluación del curso de Lenguaje de Programación 2. Permite registrar, listar, editar y eliminar películas en una base de datos MySQL, utilizando el framework Spring Boot y el motor de plantillas Thymeleaf.


## ⚙️ Configuración de Base de Datos

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/BD_T2_APELLIDO
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## 🧪 Funcionalidades

- Registrar película (`/peliculas/nuevo`)
- Listar películas (`/peliculas`)
- Editar película (`/peliculas/editar/{id}`)
- Eliminar película (`/peliculas/eliminar/{id}`)

## ▶️ Instrucciones de Ejecución

1. Clonar el repositorio porque se esta haciendo personal y no se puede hacer fork.
2. Crear la base de datos `BD_T2_APELLIDO` en MySQL y ejecutar el script SQL.
3. Modificar `application.properties`.
4. Ejecutar `BlockbusterApplication` desde la IDE.

---

© 2025 Maria Elizabeth Torres Soto