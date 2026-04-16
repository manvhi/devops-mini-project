# devops-mini-project

- **Feature branches** → Only Build + Test runs
- **Main branch** → Full pipeline including Docker + Deploy

---

## 📦 Run with Docker (Easiest)

No Java or Maven needed — just Docker!
```bash
docker pull manvhipipriya/devops-app:latest
docker run -p 8080:8080 manvhipipriya/devops-app:latest
```

Open browser: [http://localhost:8080](http://localhost:8080)

---

## 💻 Run Locally from Source
```bash
git clone https://github.com/manvhi/devops-mini-project.git
cd devops-mini-project/devops-app
./mvnw spring-boot:run
```

Open browser: [http://localhost:8080](http://localhost:8080)

---

## 🧪 Run Tests
```bash
# Run JUnit API tests
./mvnw test -Dtest=DevopsdemoApplicationTests

# Run Selenium UI tests (requires app running on port 8080)
./mvnw test -Dtest=SeleniumTest
```

---

## 🔌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /tasks | Get all tasks |
| POST | /tasks | Add a new task |
| DELETE | /tasks/{index} | Delete task by index |

---

## 🐳 Docker Hub

Image available at:
👉 [https://hub.docker.com/r/manvhipipriya/devops-app](https://hub.docker.com/r/manvhipipriya/devops-app)

---

## 👩‍💻 Author

**Manvhi Pipriya**
- GitHub: [@manvhi](https://github.com/manvhi)

## 👩‍💻 Contributor

Pranali Nikose
Iqra Shaikh
Apurva Garadkar
