# 🧑‍🏫 Classroom Management System (Spring Boot + PostgreSQL + JWT)

This is a backend-only CRUD-based project built using **Spring Boot**, **PostgreSQL**, and **JWT Authentication**. It simulates a classroom management system involving Users (Students/Teachers), Classrooms, Assignments, and Enrollments.

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot (Web, JPA)
- PostgreSQL
- JWT (JSON Web Tokens)
- Maven
- RESTful APIs

---

## 📚 What I Learned from This Project

### ✅ Backend Fundamentals with Spring Boot
- Built RESTful CRUD APIs for multiple entities using proper service-controller-repository layers.
- Understood and applied **dependency injection**, **layer separation**, and **entity relationships** using JPA.

### ✅ Database Integration
- Connected and configured **PostgreSQL** with Spring Boot using `application.properties`.
- Learned to define entity relationships like `@OneToMany`, `@ManyToOne`, and manage foreign keys.

### ✅ Clean Architecture
- Organized code following MVC structure with:
  - `entity` for entities
  - `repository` for data access
  - `service` for business logic
  - `controller` for REST APIs

### ✅ User Roles and Access
- Built support for different user roles (`STUDENT`, `TEACHER`).
- Handled user registration and login logic cleanly.

### ✅ Real-World Problem Breakdown
- Learned to divide a backend project into clear steps:
  - Schema design
  - Service layer creation
  - Controllers and API design
  - Authentication and security

### ✅ Testing and Debugging
- Used tools like Postman to test API endpoints.
- Practiced debugging flow across services and data layers.

---

## 📦 Features Implemented

- User Registration and Login (with JWT)
- Role-based logic for `STUDENT` and `TEACHER`
- CRUD for:
  - Classrooms
  - Assignments
  - Enrollment

---

## 🔐 How to Use (For Testing)

1. Run the Spring Boot app.
2. Use Postman to hit:
   - `/api/register` to register a user.
   - `/api/login` to get JWT.
3. Use the token to access secured endpoints with headers:
