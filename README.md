# Wishlist Management Application

This application provides backend functionality for managing wishlists of users on an e-commerce platform. Users can create and manage their wishlists by adding or removing items.

## Table of Contents

- [Setup](#setup)
  - [Prerequisites](#prerequisites)
  - [Database Configuration](#database-configuration)
  - [Running the Application](#running-the-application)
- [Unit Testing](#unit-testing)
- [Deployment Considerations](#deployment-considerations)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

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
spring.datasource.url=jdbc:mysql://localhost:3306/wishlist_db
spring.datasource.username=root
spring.datasource.password=root_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```
### Running the Application

Clone this repository to your local machine.
Navigate to the project directory.
Build the application using Maven or Gradle:

# For Maven
mvn clean package

# For Maven
mvn spring-boot:run

The application will start running on http://localhost:8080

### Unit Testing
To run the unit tests, execute the following command:

# For Maven
mvn test

# Deployment Considerations
Configure environment-specific properties in application.properties for deployment environments (e.g., production, staging).
Use environment variables or secure configuration management systems for sensitive information such as database credentials and API keys.
Set up continuous integration/continuous deployment (CI/CD) pipelines for automated testing and deployment.

# API Endpoints
- GET /api/wishlists: Retrieves the user's wishlist.
- POST /api/wishlists: Creates a new wishlist item.
- DELETE /api/wishlists/{id}: Removes a wishlist item by ID.

# For detailed API documentation and usage examples, refer to the Swagger UI or OpenAPI documentation (if available).

## Contributing
Contributions are welcome! Feel free to open issues or submit pull requests for any improvements or fixes.

## License
This project is licensed under the MIT License.
