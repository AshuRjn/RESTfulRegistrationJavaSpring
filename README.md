# Registration Project

## Overview
This project handles creating, deleting, listing, and updating registrations.

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
