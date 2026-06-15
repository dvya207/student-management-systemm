Student Management System
A Full Stack Student Management System developed using React.js, Spring Boot, JDBC, and MySQL. This application allows users to manage student records through a user-friendly interface and perform complete CRUD (Create, Read, Update, Delete) operations.

Project Overview
The Student Management System is designed to simplify student record management. Users can add new students, view all records, update existing information, and delete records when required. The frontend communicates with the backend through REST APIs, while MySQL is used for persistent data storage.

Features
Add Student Records
View All Students
Update Student Information
Delete Student Records
REST API Integration
MySQL Database Connectivity
Responsive User Interface
Full CRUD Operations
Technologies Used
Frontend
React.js
JavaScript (ES6)
CSS3
Axios
Backend
Spring Boot
Java
JDBC
Database
MySQL
Development Tools
Visual Studio Code
IntelliJ IDEA / Spring Tool Suite
MySQL Workbench
Git & GitHub
Project Structure


Backend Components
Controller Layer – Handles HTTP requests and responses.
Service Layer – Contains business logic.
Repository Layer – Handles database operations using JDBC.
Model Layer – Represents Student entity.
Config Layer – Handles CORS configuration.
Frontend Components
App.js – Main React component containing UI and API calls.
App.css – Styling for the application.
Axios – Used for communication with Spring Boot REST APIs.
Database Schema
CREATE TABLE students ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100) NOT NULL, grade_level VARCHAR(50), email VARCHAR(100) UNIQUE, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP );

REST API Endpoints
->http

Get All Students
GET /api/students

Get Student By ID
GET /api/students/{id}

Add Student
POST /api/students

Update Student
PUT /api/students/{id}

Delete Student
DELETE /api/students/{id}

Run the Application
Step 1: Clone the Repository
->bash git clone https://github.com/your-username/student-management-system.git

Step 2: Configure MySQL Database
->sql CREATE DATABASE student_management;

Update application.properties: ->properties spring.datasource.url=jdbc:mysql://localhost:3306/student_management spring.datasource.username=root spring.datasource.password=your_password spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

server.port=8080

Step 3: Run Spring Boot Backend
->bash mvn spring-boot:run

Backend URL: http://localhost:8080

Step 4: Run React Frontend
->bash npm install npm start

Frontend URL: http://localhost:3001

Application Screenshots
Home Page
Home Page

Student Records Table
Student Records

Student Details Page
Student Details

MySQL Database Records
Student Details

Concepts Implemented
Layered Architecture
RESTful Web Services
CRUD Operations
Dependency Injection
Constructor Injection
CORS Configuration
React Hooks (useState, useEffect)
Axios API Calls
JDBC Database Connectivity
MySQL Integration
Learning Outcomes
Through this project, I gained hands-on experience in:

Building Full Stack Applications
Developing REST APIs using Spring Boot
Connecting React Frontend with Spring Boot Backend
Working with MySQL Databases
Implementing CRUD Functionality
Managing Application Layers (Controller, Service, Repository)
Using Git and GitHub for Version Control
Understanding communication between React Frontend and Spring Boot Backend using REST APIs
Author
Divya Jain



