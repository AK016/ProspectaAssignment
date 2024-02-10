# Prospecta

## Features

- Fetch API data by category
- Add new API entries (Note: This feature is simulated and does not actually post data to the public APIs database)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them.

- JDK 1.8 or later
- Maven 3.2+
- Spring Boot 2.x


##Usage
1. Fetching APIs by Category
To get a list of APIs by category:
GET /byCategory?category=Animals

2. Adding a New API Entry
To add a new API entry (note: this is a simulated operation):
POST /saveEntry
Content-Type: application/json

{
  "API": "Example API",
  "Description": "This is just a sample API entry for demonstration."
}

Built With
Spring Boot - The web framework used
Maven - Dependency Management
