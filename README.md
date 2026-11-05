# User Authentication Service (Login & Register)

A lightweight Spring Boot REST API for user registration and authentication, featuring password hashing with Spring Security BCrypt and data persistence using Spring Data JPA with MySQL.

---

## 🛠 Features

- **User Registration**: Register new users with unique email addresses and BCrypt password encryption.
- **User Authentication**: Securely verify user credentials with encoded password matching.
- **Data Persistence**: Uses Spring Data JPA / Hibernate with a MySQL database.
- **Security**: Spring Security integration with CSRF disabled for API endpoints and BCrypt password hashing.

---

## 💻 Tech Stack

- **Java**: 17+
- **Framework**: Spring Boot 4.x
- **Security**: Spring Security (BCrypt)
- **Database**: MySQL
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Apache Maven (Wrapper included)
- **Boilerplate**: Project Lombok

---

## ⚙️ Prerequisites & Database Setup

1. **Java JDK 17** or later installed.
2. **MySQL Server** installed and running on port `3306`.
3. Create the database in MySQL:

```sql
CREATE DATABASE auth_db_springboot;
```

4. Configure database credentials in `src/main/resources/application.properties` if different from the default:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/auth_db_springboot?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🚀 Running the Application

You can run the application directly using the Maven Wrapper:

### Windows:
```cmd
.\mvnw.cmd spring-boot:run
```

### macOS / Linux:
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

---

## 📡 API Endpoints

### 1. Register User

Registers a new user in the system. The password will be hashed with BCrypt before storing.

- **URL**: `/register`
- **Method**: `POST`
- **Content-Type**: `application/x-www-form-urlencoded`

#### Request:

```bash
curl -X POST http://localhost:8080/register -H "Content-Type: application/x-www-form-urlencoded" -d "email=test@example.com&password=mypassword"
```

#### Responses:

- **200 OK**:
  ```text
  User registered successfully.
  ```

- **400 Bad Request** (e.g. if email already exists):
  ```text
  Email is already in use!
  ```

---

### 2. Login User

Authenticates existing user credentials against the stored hash.

- **URL**: `/login`
- **Method**: `POST`
- **Content-Type**: `application/x-www-form-urlencoded`

#### Request:

```bash
curl -X POST http://localhost:8080/login -H "Content-Type: application/x-www-form-urlencoded" -d "email=test@example.com&password=mypassword"
```

#### Responses:

- **200 OK**:
  ```text
  Login successful.
  ```

- **401 Unauthorized**:
  ```text
  Invalid email or password.
  ```

---

## 📂 Project Structure

```text
login-register/
├── src/
│   ├── main/
│   │   ├── java/com/labs/
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java      # Spring Security & PasswordEncoder bean
│   │   │   ├── controller/
│   │   │   │   └── AuthController.java      # /register and /login endpoints
│   │   │   ├── model/
│   │   │   │   └── User.java                # User JPA Entity (users table)
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.java      # Spring Data JPA Repository
│   │   │   ├── service/
│   │   │   │   └── UserService.java         # Registration and authentication logic
│   │   │   └── LoginRegisterApplication.java # Spring Boot entry point
│   │   └── resources/
│   │       └── application.properties       # DB connection and Hibernate settings
│   └── test/
│       └── java/com/labs/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

