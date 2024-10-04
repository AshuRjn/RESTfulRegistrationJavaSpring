# Registration Project

## Overview
This project handles creating, deleting, listing, and updating registrations.

## Technologies Used
- **Framework:** Spring Boot
- **Language:** Java
- **Database:** MySQL
- **Build Tool:** Maven
- **API Documentation:** Postman
- **Others:** AWS, Kafka

## Dependencies Used
The project utilizes various dependencies to achieve its functionality:
- **Spring Boot Starter Data JPA:** Simplifies database access using Spring Data repositories.
- **Spring Boot Starter Web:** Provides support for building web applications, including RESTful APIs.
- **MySQL Connector/J (Runtime Dependency):** The MySQL JDBC driver for connecting to MySQL databases.
- **Project Lombok (Optional):** A library for reducing boilerplate code, such as getters and setters.
- **Spring Boot Starter Test (For Testing):** Provides support for testing Spring Boot applications.

## Installation
1. Extract the provided ZIP file into your IntelliJ IDEA environment.

## Usage
1. Open Postman.
2. Use the URL `/api/v1/registration` to pass the JSON file with the necessary data to use the project features such as create, delete, list, and update registrations.

## Endpoints
- **Create Registration:** `POST /api/v1/registration`
- **Delete Registration:** `DELETE /api/v1/registration/{id}`
- **List Registrations:** `GET /api/v1/registration`
- **Update Registration:** `PUT /api/v1/registration/{id}`

### Example JSON
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "phone": "+123456789"
}

