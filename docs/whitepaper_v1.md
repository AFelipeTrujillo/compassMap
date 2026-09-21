# Whitepaper: Generador de Roadmaps Personalizados

## 1. Objetivo del Proyecto

El proyecto consiste en el desarrollo de una plataforma inteligente para la creación y gestión de **roadmaps de aprendizaje personalizados** orientados a programación y arquitectura de software. 

Basándose en una matriz de perfiles estructurada a partir de dos variables clave (*sabe programar* y *quiere aprender a programar*), el sistema identifica las necesidades exactas del usuario para ofrecer rutas formativas adaptadas a diferentes perfiles:

* **Pujar de nivell (Sabe: true / Quiere aprender: true):** Dirigido a desarrolladores con experiencia que buscan profundizar en arquitectura, DDD (Domain-Driven Design), buenas prácticas y el uso de Inteligencia Artificial como acelerador controlado.
* **Usar AI per crear projectes (Sabe: true / Quiere aprender: false):** Enfocado en profesionales que ya programan pero priorizan la velocidad y productividad, buscando generar proyectos rápidamente mediante herramientas de IA sin profundizar en conceptos teóricos complejos.
* **Començar de 0 (Sabe: false / Quiere aprender: true):** Diseñado para principiantes absolutos que desean aprender los fundamentos de la programación desde cero: lógica, algoritmos y pensamiento computacional.
* **Curs introductori d'arquitectura (Sabe: false / Quiere aprender: false):** Pensado para Product Managers, diseñadores, empresarios o estudiantes de otras áreas que necesitan adquirir una base conceptual para "hablar el mismo idioma" que los equipos técnicos.

---

## 2. Flujo de Trabajo en Git

Para garantizar un desarrollo colaborativo ordenado y seguro en el repositorio, el equipo de desarrollo sigue estrictamente el flujo de trabajo ilustrado en el siguiente diagrama de Mermaid:

```mermaid
workflow
    direction TB
    RepoPrincipal["Repositorio Principal (Remote)"]
    ForkDev["Fork en Repo Local / Remoto del Dev"]
    RamaMaster["Rama Master (Local)"]
    RamaDevelop["Rama Develop (Local)"]
    Cambios["Desarrollo de Cambios"]
    PullMaster["Pull de Cambios Remotos a Master"]
    MergeDev["Merge de Develop a Master"]
    PR["Pull Request hacia Master Remoto"]

    RepoPrincipal -->|1. Fork| ForkDev
    ForkDev -->|2. Clonar / Configurar| RamaMaster
    RamaMaster -->|3. Crear rama| RamaDevelop
    RamaDevelop -->|4. Codificar| Cambios
    Cambios -->|5. Registrar commits| RamaDevelop
    RepoPrincipal -->|6. Actualizar| PullMaster
    PullMaster -->|7. Sincronizar| RamaMaster
    RamaDevelop -->|8. Fusionar| MergeDev
    MergeDev -->|9. Enviar PR| PR
```

### Descripción detallada de los pasos:

1. **Fork:** El desarrollador realiza un *fork* del repositorio principal para obtener su propia copia de trabajo.
2. **Creación de Rama Develop:** En su entorno local, a partir de la copia, crea una rama exclusiva denominada `develop` sin alterar la rama `master`.
3. **Desarrollo:** El programador implementa las nuevas funcionalidades o ajustes correspondientes al sistema de roadmaps directamente en la rama `develop`.
4. **Pull de Actualización:** Antes de integrar nada, realiza un `pull` para incorporar los cambios más recientes que existan en la rama `master` remota y evitar conflictos.
5. **Merge Local:** Una vez comprobado el correcto funcionamiento, se realiza el *merge* de la rama `develop` hacia `master` en local.
6. **Pull Request (PR):** El proceso concluye enviando un *Pull Request* desde el repositorio del desarrollador hacia el repositorio principal `master` para su revisión final e integración.
