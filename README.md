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
