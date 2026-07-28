# AmanaCover API

A Spring Boot REST API for managing insurance policies with secure user authentication and authorization.

## Features

### Policy Management
- Create Policy
- Get All Policies
- Get Policy By ID
- Search By Policy Number
- Update Policy
- Delete Policy
- Pagination
- Filtering By Status
- Validation

### Security
- User Registration
- User Login
- BCrypt Password Encryption
- JWT Token Generation
- Custom Authentication Error handling

### Backend Features
- DTO Pattern
- Validation
- Global Exception Handling
- PostgreSQL Integration
- Spring Data JPA
- Logging with SLF4J
- 
## Tech Stack
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (JSON Web Tokens)
- Lombok
- Maven
- Git & GitHub
- postman

## Policy Endpoints

### Create Policy

POST

/api/v1/policies

### Get All Policies

GET

/api/v1/policies

### Get Policy By ID

GET

/api/v1/policies/{id}

### Update Policy

PUT

/api/v1/policies/{id}

### Delete Policy

DELETE

/api/v1/policies/{id}

### Search By Policy Number

GET 

/api/v1/policies/search?policyNumber=POL001

### Pagination

GET 

/api/v1/policies?page=0&size=5

### Filter Policies

### Filter By Status
GET

/api/v1/policies/filter?status=ACTIVE

### Authentication Endpoints

### Register User

POST 

/api/auth/register

### Request

{
"email": "user@example.com",
"password": "Password123"
}

### Response

"User registered successfully"

### Login User

POST

/api/auth/login

### Request

{
"email": "user@example.com",
"password": "Password123"
}

### Response 

{
"token": "eyJhbGciOiJIUzI1NiJ9..."
}

### Database
postgreSQL is used as the primary database.
Example entities:
- Users
- Policies

### Security
Passwords are securely stored using BCrypt hashing.
JWT tokens are generated during login and will be used to secure and protect API endpoints.

### Testing
API endpoints were tested using Postman.
Covered scenarios include:
- User Registration
- User login
- Policy creation
- Policy retrieval
- policy updates
- Policy deletion
- Pagination
- Filtering
- Duplicate user validation

### Future Enhancements
- JWT Authorization Filter
- Role-Based Access Control (RBAC)
- Insurance Product management 
- Quote Engine
- Policy Purchase Workflow 
- Payment Confirmation Module
- Unit Testing with JUnit & Mockito
- Spring Webflux & R2DBC
- Docker Containerization
## Author

Margaret Atieno
Intern - Digital & Innovation
CIC Group Ltd