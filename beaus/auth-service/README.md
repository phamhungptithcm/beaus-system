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

---

# Database Schema

## 1. Permission Table

This table stores different types of permissions that can be assigned to roles.

| Column Name      | Type         | Description                                                 |
| ---------------- | ------------ | ----------------------------------------------------------- |
| id               | SERIAL (PK)  | Unique identifier for each permission.                      |
| name             | VARCHAR(255) | Unique name of the permission (e.g., READ, MODIFY, DELETE). |
| created_date     | TIMESTAMPTZ  | Timestamp when the permission was created.                  |
| created_by       | VARCHAR(255) | The user who created the permission (default is 'system').  |
| modified_date    | TIMESTAMPTZ  | Timestamp when the permission was last modified.            |
| modified_by      | VARCHAR(255) | The user who last modified the permission.                  |
| is_active        | BOOLEAN      | Indicates if the permission is active.                      |
| version          | INT          | Version number for tracking updates.                        |
| deleted_date     | TIMESTAMPTZ  | Timestamp when the permission was deleted (if applicable).  |
| deleted_by       | VARCHAR(255) | The user who deleted the permission.                        |
| reactivated_date | TIMESTAMPTZ  | Timestamp when the permission was reactivated.              |
| reactivated_by   | VARCHAR(255) | The user who reactivated the permission.                    |
| data_source      | VARCHAR(255) | Source of the data (default is 'unknown').                  |

## 2. Module Table

This table represents system modules where permissions apply.

| Column Name      | Type         | Description                                               |
| ---------------- | ------------ | --------------------------------------------------------- |
| id               | SERIAL (PK)  | Unique identifier for each module.                        |
| name             | VARCHAR(255) | Unique name of the module (e.g., Product, Order, Report). |
| created_date     | TIMESTAMPTZ  | Timestamp when the module was created.                    |
| created_by       | VARCHAR(255) | The user who created the module.                          |
| modified_date    | TIMESTAMPTZ  | Timestamp when the module was last modified.              |
| modified_by      | VARCHAR(255) | The user who last modified the module.                    |
| is_active        | BOOLEAN      | Indicates if the module is active.                        |
| version          | INT          | Version number for tracking updates.                      |
| deleted_date     | TIMESTAMPTZ  | Timestamp when the module was deleted.                    |
| deleted_by       | VARCHAR(255) | The user who deleted the module.                          |
| reactivated_date | TIMESTAMPTZ  | Timestamp when the module was reactivated.                |
| reactivated_by   | VARCHAR(255) | The user who reactivated the module.                      |
| data_source      | VARCHAR(255) | Source of the data (default is 'unknown').                |

## 3. Role Table

Defines different roles that users can have in the system.

| Column Name      | Type         | Description                                         |
| ---------------- | ------------ | --------------------------------------------------- |
| id               | SERIAL (PK)  | Unique identifier for each role.                    |
| name             | VARCHAR(255) | Unique role name (e.g., Administrator, Supervisor). |
| created_date     | TIMESTAMPTZ  | Timestamp when the role was created.                |
| created_by       | VARCHAR(255) | The user who created the role.                      |
| modified_date    | TIMESTAMPTZ  | Timestamp when the role was last modified.          |
| modified_by      | VARCHAR(255) | The user who last modified the role.                |
| is_active        | BOOLEAN      | Indicates if the role is active.                    |
| version          | INT          | Version number for tracking updates.                |
| deleted_date     | TIMESTAMPTZ  | Timestamp when the role was deleted.                |
| deleted_by       | VARCHAR(255) | The user who deleted the role.                      |
| reactivated_date | TIMESTAMPTZ  | Timestamp when the role was reactivated.            |
| reactivated_by   | VARCHAR(255) | The user who reactivated the role.                  |
| data_source      | VARCHAR(255) | Source of the data (default is 'unknown').          |

## 4. Role_Permissions Table

Maps roles, permissions, and modules together.

| Column Name      | Type         | Description                                   |
| ---------------- | ------------ | --------------------------------------------- |
| role_id          | INT (FK)     | References role(id).                          |
| permission_id    | INT (FK)     | References permission(id).                    |
| module_id        | INT (FK)     | References module(id).                        |
| created_date     | TIMESTAMPTZ  | Timestamp when the mapping was created.       |
| created_by       | VARCHAR(255) | The user who created the mapping.             |
| modified_date    | TIMESTAMPTZ  | Timestamp when the mapping was last modified. |
| modified_by      | VARCHAR(255) | The user who last modified the mapping.       |
| is_active        | BOOLEAN      | Indicates if the mapping is active.           |
| version          | INT          | Version number for tracking updates.          |
| deleted_date     | TIMESTAMPTZ  | Timestamp when the mapping was deleted.       |
| deleted_by       | VARCHAR(255) | The user who deleted the mapping.             |
| reactivated_date | TIMESTAMPTZ  | Timestamp when the mapping was reactivated.   |
| reactivated_by   | VARCHAR(255) | The user who reactivated the mapping.         |
| data_source      | VARCHAR(255) | Source of the data.                           |

**Primary Key**: (role_id, permission_id, module_id) - Composite key to ensure uniqueness.

## 5. Users Table

Stores user details.

| Column Name      | Type         | Description                                 |
| ---------------- | ------------ | ------------------------------------------- |
| id               | SERIAL (PK)  | Unique identifier for each user.            |
| username         | VARCHAR(255) | Unique username.                            |
| email            | VARCHAR(255) | Unique email address.                       |
| password         | VARCHAR(255) | Hashed password for authentication.         |
| last_login_date  | TIMESTAMPTZ  | The last time the user logged in.           |
| created_date     | TIMESTAMPTZ  | Timestamp when the user was created.        |
| created_by       | VARCHAR(255) | The user who created this account.          |
| modified_date    | TIMESTAMPTZ  | Timestamp when the user was last modified.  |
| modified_by      | VARCHAR(255) | The user who last modified the account.     |
| is_active        | BOOLEAN      | Indicates if the user is active.            |
| version          | INT          | Version number for tracking updates.        |
| deleted_date     | TIMESTAMPTZ  | Timestamp when the user was deleted.        |
| deleted_by       | VARCHAR(255) | The user who deleted the account.           |
| reactivated_date | TIMESTAMPTZ  | Timestamp when the account was reactivated. |
| reactivated_by   | VARCHAR(255) | The user who reactivated the account.       |
| data_source      | VARCHAR(255) | Source of the data.                         |

## 6. User_Roles Table

Maps users to roles.

| Column Name      | Type         | Description                                   |
| ---------------- | ------------ | --------------------------------------------- |
| user_id          | INT (FK)     | References users(id).                         |
| role_id          | INT (FK)     | References role(id).                          |
| created_date     | TIMESTAMPTZ  | Timestamp when the mapping was created.       |
| created_by       | VARCHAR(255) | The user who created the mapping.             |
| modified_date    | TIMESTAMPTZ  | Timestamp when the mapping was last modified. |
| modified_by      | VARCHAR(255) | The user who last modified the mapping.       |
| is_active        | BOOLEAN      | Indicates if the mapping is active.           |
| version          | INT          | Version number for tracking updates.          |
| deleted_date     | TIMESTAMPTZ  | Timestamp when the mapping was deleted.       |
| deleted_by       | VARCHAR(255) | The user who deleted the mapping.             |
| reactivated_date | TIMESTAMPTZ  | Timestamp when the mapping was reactivated.   |
| reactivated_by   | VARCHAR(255) | The user who reactivated the mapping.         |
| data_source      | VARCHAR(255) | Source of the data.                           |

**Primary Key**: (user_id, role_id) - Composite key to ensure uniqueness.

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
