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

## Technologies Used
- Java 17
- Spring Boot 3.2.2
- Spring Data JPA
- Spring Security
- MySQL
- Mockito
- JUnit
## Setup

### Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 11 or later
- Apache Maven
- MySQL
  
## Configuration

1. Create a MySQL database for the application.
2. Update the `application.properties` file with your database connection details:

```properties
git clone https://github.com/kumarprem66/UserWishList.git
Navigate to the project directory:
cd UserWishList
Update the application.properties file with your MySQL database configuration:
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/WishList
spring.datasource.username=root
spring.datasource.password=premk
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
server.port=8088

```

## Running the Application

# For Maven
mvn clean package

### For Maven
```
mvn spring-boot:run
```
```
The application will start running on http://localhost:8088
```

# Unit Testing
To run the unit tests, execute the following command:

## For Maven
mvn test

# API Endpoints
- POST /api/create-customer: Create customer.
- GET /api/get-customer/{usernameOrEmail}: Retrieves customer details.
- POST /api/wishlists/{usernameOrEmail}: Creates a new wishlist item.
- GET /api/wishlists/{usernameOrEmail}: get customer's wishlist
- DELETE /api/wishlists/{usernameOrEmail}/{id}. deletes the wishlist item

### For detailed API documentation and usage examples, refer to the Swagger UI or OpenAPI documentation.
```
http://localhost:8088/swagger-ui/index.html#/wish-controller
```

## Contributing
Contributions are welcome! Feel free to open issues or submit pull requests for any improvements or fixes.
