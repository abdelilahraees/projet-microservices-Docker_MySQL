# Microservices Architecture Project

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-green)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2024-brightgreen)
![Docker](https://img.shields.io/badge/Docker-Containerization-blue)

A scalable e-commerce platform built with microservices architecture.

## 📦 Services Overview

| Service            | Description                          | Port  |
|--------------------|--------------------------------------|-------|
| config-service    | Centralized configuration server    | 8888  |
| discovery-service | Service registry (Eureka)           | 8761  |
| gateway-service   | API Gateway (Spring Cloud Gateway)  | 8080  |
| customer-service  | Handles customer data               | 8081  |
| product-service   | Manages product catalog             | 8082  |

## 🛠️ Technologies

- **Core**: Java 21, Spring Boot 3.4, Spring Cloud 2024
- **Communication**: OpenFeign (REST), Spring Cloud Gateway (Routing)
- **Infrastructure**: Eureka (Service Discovery), Config Server
- **Database**: MySQL (Relational)
- **Resilience**: Circuit Breaker (Resilience4j)
- **Containerization**: Docker

## 🚀 Quick Start

### Prerequisites

- JDK 21+
- Maven 3.9+
- MySQL 8.0+
- Docker & Docker Compose

### Installation

#### Clone the project
```sh
git clone https://github.com/abdelilahraees/first_project_spring_boot_micro_services.git
