# My Spring Boot Application

This project is a Spring Boot application that requires Java 21 and Docker to run.

## 🚀 Prerequisites
- **Java 21** installed ([Download Here](https://adoptium.net/))
- **Maven** installed ([Maven Installation Guide](https://maven.apache.org/install.html))
- **Docker & Docker Compose** installed ([Docker Installation Guide](https://docs.docker.com/get-docker/))

## 🛠️ How to Run Locally

1. **Clone the Repository**
   ```sh
   git clone https://github.com/dhinupriya/springbolt-service.git
   cd your-repo
   ```

2. **Build the Project**
   ```sh
   mvn clean install
   ```

3. **Start the Application with Docker**
   ```sh
   docker compose up --build
   ```

4. **Access the Application**
    - The app should now be running at:
      ```
      http://localhost:8080
      ```

## 🛑 Stopping the Application
To stop and remove the running containers, use:
```sh
docker compose down
```
