# Prospecta

Prospecta is a Spring Boot application designed to interact with public APIs by fetching information based on categories and simulating the addition of new API entries. This project aims to demonstrate the consumption and provision of RESTful services using Spring Boot.

## Features

- **Fetch API Data by Category**: Allows users to retrieve a list of public APIs filtered by a specific category.
- **Add New API Entries**: Simulates the addition of new API entries to the system. (Note: This feature does not actually post data to the public APIs database).

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following installed:

- JDK 1.8 or later
- Maven 3.2 or higher
- Spring Boot 2.x

### Installation

No specific installation steps required beyond setting up your development environment with the prerequisites listed above.

## Usage

### 1. Fetching APIs by Category

To retrieve a list of APIs by a specific category, use the following endpoint:

```http
GET http://localhost:8080/byCategory?category=finance
```

### 2. Adding a New API Entry
To simulate the addition of a new API entry, use the following endpoint:

```http
POST [/saveEntry](http://localhost:8080/saveEntry)
Content-Type: application/json

{
  "API": "Example API",
  "Description": "This is just a sample API entry for demonstration."
}
```

Note: It is running on 8080 server port so change it accordingly

Built With
- Spring Boot: The web framework used for building RESTful applications.
- Maven: Dependency management tool used for managing project dependencies.
