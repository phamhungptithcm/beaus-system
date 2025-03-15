# 🛡️ Authorization Service

**Authorization Service** is a microservice built with **Spring Boot 3**, **Spring Security**, and **Spring Cloud** to handle authentication and authorization in a microservices architecture. It supports **Single Sign-On (SSO)**, **OAuth2 Social Login (Google, Facebook, Twitter)**, and follows **Clean Architecture** principles.

---

## 🚀 Features

👉 **JWT-Based Authentication**  
👉 **Single Sign-On (SSO)**  
👉 **OAuth2 Social Login** (Google, Facebook, Twitter)  
👉 **Role-Based Access Control (RBAC)**  
👉 **Spring Cloud Integration**  
👉 **OpenAPI Documentation (Swagger UI)**  
👉 **Automated API Testing with CATS**

---

## 📂 **Project Structure**

```
src/main/java/com/auth
│── application
│   ├── service          # Business logic layer
│── domain
│   ├── model            # Entities & domain models
│   ├── repository       # Repository layer
│── infrastructure
│   ├── controller       # API Controllers
│── config
│   ├── SecurityConfig   # Security configuration
│   ├── OpenAPIConfig    # API Documentation setup
│── test
│   ├── service          # Unit tests
│   ├── integration      # Integration tests
```

---

## 🛠️ **Tech Stack**

| Technology                             | Version |
| -------------------------------------- | ------- |
| **Java**                               | 17      |
| **Spring Boot**                        | 3.x     |
| **Spring Security**                    | ✅      |
| **OAuth2 (Google, Facebook, Twitter)** | ✅      |
| **Spring Cloud**                       | ✅      |
| **Springdoc OpenAPI**                  | ✅      |
| **CATS (API Testing)**                 | ✅      |

---

## 🚀 **Setup & Installation**

### **1️⃣ Clone the Repository**

```sh
git clone https://github.com/your-repo/auth-service.git
cd auth-service
```

### **2️⃣ Configure Environment Variables**

Create a `.env` file or update `application.yml`:

```yaml
server:
  port: 8080

spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: your-google-client-id
            client-secret: your-google-client-secret
          facebook:
            client-id: your-facebook-client-id
            client-secret: your-facebook-client-secret
          twitter:
            client-id: your-twitter-client-id
            client-secret: your-twitter-client-secret
```

### **3️⃣ Build and Run**

#### **Using Maven**

```sh
mvn clean install
mvn spring-boot:run
```

#### **Using Docker**

```sh
docker build -t auth-service .
docker run -p 8080:8080 auth-service
```

---

## 🔑 **API Endpoints**

### 👉 **Authentication**

| Method | Endpoint            | Description       |
| ------ | ------------------- | ----------------- |
| `POST` | `/auth/login`       | User login        |
| `POST` | `/auth/signup`      | User registration |
| `GET`  | `/auth/user`        | Get user details  |
| `GET`  | `/oauth2/authorize` | OAuth2 login      |

### 👉 **User Management**

| Method | Endpoint | Description       |
| ------ | -------- | ----------------- |
| `GET`  | `/users` | Get all users     |
| `POST` | `/users` | Create a new user |

### 👉 **Swagger UI**

```sh
http://localhost:8080/swagger-ui/index.html
```

---

## 🧪 **Automated API Testing**

### **1️⃣ Generate OpenAPI Spec**

```sh
curl -o openapi.yaml http://localhost:8080/v3/api-docs
```

### **2️⃣ Run CATS API Tests**

```sh
cats --contract openapi.yaml --server http://localhost:8080
```

✅ CATS automatically detects contract violations and missing parameters.

---

## ✅ **Best Practices Followed**

✔️ **Follows Clean Architecture (Separation of Concerns)**  
✔️ **Uses OpenAPI for API documentation**  
✔️ **Automated testing with CATS**  
✔️ **Secure with OAuth2 and JWT**  
✔️ **Scalable Microservice Architecture**

---

## 🐟 **License**

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## 🤝 **Contributing**

Want to improve this project?  
Fork it, create a feature branch, and submit a **pull request** 🚀.

---

## 📩 **Contact & Support**

👉 GitHub Issues: [Create a Ticket](https://github.com/your-repo/auth-service/issues)  
👉 Email: support@yourdomain.com  
👉 Documentation: [Read the Docs](https://yourdocs.com)

---

🔥 **Star this repo ⭐ to support the project!**
