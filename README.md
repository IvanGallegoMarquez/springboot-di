# springboot-di
Spring Boot DI – Product Repository (JSON / In-Memory)

Este proyecto es un ejemplo sencillo de inyección de dependencias en Spring Boot, mostrando cómo trabajar con múltiples implementaciones de un repositorio y seleccionar una como principal usando configuración Java (@Configuration y @Primary).

🧩 Descripción

La aplicación gestiona productos (Product) a través de una interfaz común ProductRepository.
Existen dos implementaciones:

ProductRepositoryImpl
Repositorio en memoria con una lista fija de productos.

ProductRepositoryJson
Repositorio que carga los productos desde un archivo JSON ubicado en el classpath.

La implementación basada en JSON se define como primary mediante AppConfig, por lo que Spring la inyecta por defecto.
