# Wishlist Management Application

This application provides backend functionality for managing wishlists of users on an e-commerce platform. Users can create and manage their wishlists by adding or removing items.

## Table of Contents

- [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Database Configuration](#database-configuration)
  - [Running the Application](#running-the-application)
- [Unit Testing](#unit-testing)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)

## Setup

### Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 11 or later
- Apache Maven or Gradle build tool (depending on your preference)
- MySQL or another compatible relational database

### Database Configuration

1. Create a MySQL database for the application.
2. Update the `application.properties` file with your database connection details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/WishList
spring.datasource.username=root
spring.datasource.password=root_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```
## Running the Application

Clone this repository to your local machine.
Navigate to the project directory.
Build the application using Maven or Gradle:

# For Maven
mvn clean package

### For Maven
mvn spring-boot:run

The application will start running on http://localhost:8080

# Unit Testing
To run the unit tests, execute the following command:

## For Maven
mvn test

# API Endpoints
- POST /wish/create-customer: Create customer.
- GET /wish/get-customer/{usernameOrEmail}: Retrieves customer details.
- POST /wish//create-wishlist/{usernameOrEmail}: Creates a new wishlist item.
- GET /wish/get-wishList/{usernameOrEmail}: get customer's wishlist
- DELETE /wish/delete-wishlistItem/{usernameOrEmail}/{wishId}. deletes the wishlist item

### For detailed API documentation and usage examples, refer to the Swagger UI or OpenAPI documentation (if available).

## Contributing
Contributions are welcome! Feel free to open issues or submit pull requests for any improvements or fixes.
