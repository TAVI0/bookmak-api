Bookmak API

  

API REST en Java 17 y Spring Boot 3.2.4 para gestionar marcadores (bookmarks) y categorías, con autenticación JWT y persistencia en PostgreSQL. Incluye contenedores Docker para facilitar el despliegue local y en producción.

Estado: Proyecto en desarrollo. Las rutas y la documentación pueden cambiar sin previo aviso.

✨ Características

CRUD completo de marcadores (titulo, url, descripción, etiquetas, favorito, etc.).

CRUD de carpetas / categorías.

Búsqueda y filtrado por texto completo.

Autenticación y autorización mediante JSON Web Tokens (JWT) (github.com).

Persistencia con Spring Data JPA y PostgreSQL (github.com).

Mapeo DTO ↔ Entidad con MapStruct (github.com).

Generación de imagen Docker lista para producción (github.com).

Orquestación local con docker‑compose (servicio API + base de datos) (github.com).

📂 Estructura

bookmak-api
├── src/main/java/com/tavio/bookmak/  # código fuente
├── src/test/java/                    # tests (WIP)
├── build.gradle                      # dependencias Gradle
├── Dockerfile                        # imagen de la aplicación
├── docker-compose.yml                # stack app + postgres
└── ...

🛠️ Requisitos

Herramienta

Versión mínima

JDK

17

Gradle

Wrapper incluido

Docker

20.10

Docker Compose

1.29

También puedes ejecutar la app sin Docker usando una base de datos local.

🚀 Puesta en marcha rápida

# 1. Clona el repositorio
$ git clone https://github.com/TAVI0/bookmak-api.git
$ cd bookmak-api

# 2. Levanta la pila completa (API + PostgreSQL)
$ docker compose up -d --build  # necesita Docker/Compose

# 3. Comprueba que la API responde
$ curl http://localhost:8080/actuator/health

La base de datos se crea con el usuario/clave y nombre indicados en docker-compose.yml:

POSTGRES_USER: postgres
POSTGRES_PASSWORD: admin
POSTGRES_DB: bookmark

Puedes cambiarlos mediante variables de entorno antes de levantar los contenedores.

⚙️ Configuración local (sin Docker)

PostgreSQL: crea una base bookmark y un usuario con permisos.

Copia .env.example → .env y ajusta las propiedades:

SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/bookmark
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=admin
JWT_SECRET=super‑secret‑key

Arranca la aplicación:

./gradlew bootRun

🔑 Autenticación

La capa de seguridad se basa en JWT. Para obtener un token debes hacer login (endpoint /auth/login, pendiente de documentación) con usuario y clave; la respuesta incluye el token en el header Authorization: Bearer <token> para futuras peticiones.
