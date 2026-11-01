# Expense Tracker API

A RESTful Expense Tracker API built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL.

This project allows users to manage their daily expenses through RESTful APIs, perform CRUD operations, filter expenses by category, and retrieve records using pagination and sorting.

## Technologies Used

- Java 25
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- MySQL
- Maven
- Lombok
- Postman
- Git & GitHub

## Features

- Create a new expense
- Retrieve all expenses
- Retrieve an expense by ID
- Update existing expenses
- Delete expenses
- Filter expenses by category (case-insensitive)
- Pagination and sorting
- Input validation using Jakarta Validation
- Global exception handling
- Custom error responses
- Proper HTTP status codes

## Project Structure

```text
src/main/java/com/jasveer/Expense_Tracker/
│
├── Entity/
│   └── Expense.java
│
├── Repository/
│   └── ExpenseRepository.java
│
├── Service/
│   └── ExpenseService.java
│
├── controller/
│   └── ExpenseController.java
│
├── exception/
│   ├── ErrorResponse.java
│   ├── ExpenseNotFoundException.java
│   └── GlobalExceptionHandler.java
│
└── ExpenseTrackerApplication.java
```

## REST API Endpoints

Base URL: `/api/expenses`

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/api/expenses` | Create an expense |
| GET | `/api/expenses` | Get all expenses |
| GET | `/api/expenses/{id}` | Get expense by ID |
| PUT | `/api/expenses/{id}` | Update an expense |
| DELETE | `/api/expenses/{id}` | Delete an expense |

Additional functionality: category filtering, pagination, and sorting.

## Expense JSON Example

```json
{
  "title": "Lunch",
  "amount": 150.00,
  "category": "Food",
  "expenseDate": "2026-10-26"
}
```

## Database Configuration

This project uses MySQL.

1. Create a MySQL database named `expense_tracker`.
2. Copy `src/main/resources/application.properties.example` to `application.properties`.
3. Update your database username and password in `application.properties`.
4. Run the application.

**Note:** Never upload actual database credentials or passwords to GitHub.

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/developerjasveersingh03/Expense-Tracker-API.git
```

2. Open the project in IntelliJ IDEA.

3. Configure your MySQL database.

4. Run `ExpenseTrackerApplication.java`.

5. Test the APIs using Postman.

## Exception Handling & Validation

- Custom exception for expense not found.
- Global exception handling using `@RestControllerAdvice`.
- Request validation using `@Valid`.
- Handles invalid input and returns appropriate HTTP status codes.

## Author

**Jasveer Singh**

GitHub: [developerjasveersingh03](https://github.com/developerjasveersingh03)

---

*This project was developed to strengthen practical knowledge of Java backend development, Spring Boot, REST APIs, database operations, and exception handling.*
