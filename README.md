# Sistema de Reservas de Hotel - Proyecto Integrador (v0.1-propuesta)

Este repositorio contiene el scaffold completo requerido para la entrega `v0.1-propuesta`.
Incluye estructura mínima, migraciones Flyway, Dockerfile, docker-compose, documentación OpenAPI y controladores CRUD básicos.

## Qué incluye
- API REST con endpoints CRUD para Users, Rooms y Reservations.
- Flyway V1 para crear tablas.
- Docker + docker-compose para levantar MySQL y la app.
- OpenAPI en `/docs/openapi.yaml`.
- README, CONTRIBUTING.md, .gitignore, y plantillas en `.github/`.

## Cómo ejecutar (local con Docker)
1. Asegúrate de tener Docker y Docker Compose instalados.
2. Desde la raíz del proyecto:
```bash
docker compose up --build
```
3. La app quedará disponible en `http://localhost:8080` y la UI de OpenAPI en `/swagger-ui.html` (springdoc).

## Notas
- Contraseñas en este scaffold se almacenan en texto para facilitar la entrega. **No** es seguro para producción. Para la versión final añade hashing (BCrypt) y JWT.
- El script Flyway crea las tablas iniciales.

## Tag requerido para la entrega
Crea y sube el tag `v0.1-propuesta` y publica la Release en GitHub/GitLab.

