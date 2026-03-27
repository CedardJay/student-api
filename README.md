# Student API — Spring Boot Backend

A RESTful Web Service for managing student records in a school system, built with Java Spring Boot, Spring Security (JWT), and MySQL.

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 21 | Programming language |
| Spring Boot | 3.3.x | Backend framework |
| Spring Security | 6.x | Authentication & authorization |
| Spring Data JPA | - | Database ORM |
| MySQL | 8.x | Database |
| JWT (jjwt) | 0.11.5 | Token-based authentication |
| Maven | 3.9.x | Build tool |

---

## Project Structure

```
src/main/java/com/school/student_api/
├── controller/
│   ├── AuthController.java        # Login & register endpoints
│   └── StudentController.java     # Student CRUD endpoints
├── model/
│   ├── AuthRequest.java           # Login/register request body
│   ├── AuthResponse.java          # Auth response with JWT token
│   ├── Student.java               # Student entity
│   └── User.java                  # User entity
├── repository/
│   ├── StudentRepository.java     # Student database operations
│   └── UserRepository.java        # User database operations
├── security/
│   ├── CustomUserDetailsService.java  # Loads user from DB for Spring Security
│   ├── JwtFilter.java                 # Validates JWT on every request
│   ├── JwtUtil.java                   # Generates & validates JWT tokens
│   └── SecurityConfig.java            # Spring Security configuration
└── service/
    ├── AuthService.java           # Register & login business logic
    └── StudentService.java        # Student CRUD business logic
```

---

## Prerequisites

Make sure you have the following installed:

- [Java JDK 21](https://adoptium.net)
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/installer) or [WampServer](https://www.wampserver.com/en/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download) (recommended)

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/student-api.git
cd student-api
```

### 2. Create the Database

Open MySQL or phpMyAdmin and run:

```sql
CREATE DATABASE student_db;
```

### 3. Configure `application.properties`

Open `src/main/resources/application.properties` and update:

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=yourpassword

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Server
server.port=8081

# JWT
app.jwt.secret=your_super_secret_key_should_be_very_long_and_secure_123456789
app.jwt.expiration=86400000

# Invite Code
app.invite.code=SCHOOL2024
```

### 4. Run the Application

In IntelliJ, click the **Run** button or run:

```bash
mvn spring-boot:run
```

The API will start at `http://localhost:8081`

---

## API Endpoints

### Authentication

| Method | Endpoint | Access | Description |
|---|---|---|---|
| POST | `/api/auth/register` | Public | Register a new user |
| POST | `/api/auth/login` | Public | Login and get JWT token |

#### Register Request Body
```json
{
  "fullName": "John Doe",
  "email": "john@gmail.com",
  "password": "password123",
  "inviteCode": "SCHOOL2024"
}
```

#### Login Request Body
```json
{
  "email": "john@gmail.com",
  "password": "password123"
}
```

#### Auth Response
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "email": "john@gmail.com",
  "fullName": "John Doe"
}
```

---

### Students

> All student endpoints require a valid JWT token in the `Authorization` header:
> `Authorization: Bearer <your_token>`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get a single student |
| POST | `/api/students` | Create a new student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |

#### Student Request Body
```json
{
  "firstName": "Jane",
  "lastName": "Smith",
  "email": "jane@gmail.com",
  "age": 16,
  "grade": "10th"
}
```

#### Student Response
```json
{
  "id": 1,
  "firstName": "Jane",
  "lastName": "Smith",
  "email": "jane@gmail.com",
  "age": 16,
  "grade": "10th"
}
```

---

## Security

- All student endpoints are **protected** — a valid JWT token is required
- Passwords are hashed using **BCrypt** before storing in the database
- JWT tokens expire after **24 hours**
- Registration requires a valid **invite code** to prevent unauthorized access
- CORS is configured to only allow requests from `http://localhost:3000`

---

## Environment Variables

| Variable | Description | Default |
|---|---|---|
| `spring.datasource.url` | MySQL connection URL | `jdbc:mysql://localhost:3306/student_db` |
| `spring.datasource.username` | MySQL username | `root` |
| `spring.datasource.password` | MySQL password | `` |
| `server.port` | Port the app runs on | `8081` |
| `app.jwt.secret` | Secret key for signing JWT | — |
| `app.jwt.expiration` | Token expiry in milliseconds | `86400000` (24h) |
| `app.invite.code` | Invite code for registration | `SCHOOL2024` |

---

## Related

- **Frontend Repository:** [student-frontend](https://github.com/CedardJay/student-frontend)
- Built with [Spring Initializr](https://start.spring.io)

---

## License

This project is for educational purposes.
