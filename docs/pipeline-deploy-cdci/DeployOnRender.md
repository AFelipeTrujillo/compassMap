# Spring Boot compassMap depoy pipeline by Docker/Render

> The Spring Boot app lives in the subfolder `compassMap/`, and there is currently **no Dockerfile**. You just need to add one and tell Render where the project root is.

### 1. Create a Dockerfile

Create this file **inside the `compassMap/` folder**:
(i.e. `compassMap/Dockerfile`):

```dockerfile
# ===== Build stage =====
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy Maven wrapper + pom
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (better layer caching)
RUN ./mvnw dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN ./mvnw clean package -DskipTests

# ===== Runtime stage =====
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the generated JAR
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

> This project uses or will use **Java 21** and **Spring Boot 4.1.1** + H2 + Thymeleaf, so the Dockerfile above matches it.

### 2. Commit & push

```bash
cd compassMap
# (create the Dockerfile)
git add Dockerfile
git commit -m "Add Dockerfile for Render deployment"
git push origin master
```

### 3. Deploy on Render

1. Go to [Render Dashboard](https://dashboard.render.com) → **New +** → **Web Service**
2. Connect the repository `AlbertProfe/compassMap`
3. Important settings:

| Setting              | Value                          |
|----------------------|--------------------------------|
| **Name**             | anything (e.g. `compassmap`)   |
| **Runtime**          | **Docker**                     |
| **Branch**           | `master`                       |
| **Root Directory**   | `compassMap`  ← **very important** |
| **Dockerfile Path**  | `Dockerfile` (default is fine) |
| **Instance Type**    | Free (or paid)                 |

4. Optional environment variable (recommended on free tier):
   ```
   JAVA_OPTS=-Xmx400m -Xms200m
   ```

5. Click **Create Web Service**

Render will:
- Use the `compassMap/` folder as the build context
- Build the multi-stage Docker image
- Start the app on port 8080
- Give you a public URL

---

### Quick summary of the two projects

| Repo                    | Location of Spring Boot | Dockerfile needed? | Root Directory on Render |
|-------------------------|--------------------------|--------------------|---------------------------|
| BooksPageable           | root                     | Yes (replace existing) | *(leave empty)*          |
| compassMap              | `/compassMap`            | Yes (create new)   | `compassMap`             |
