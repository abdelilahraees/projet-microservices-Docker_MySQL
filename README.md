# Architecture Microservices avec Spring Boot et Docker

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.3-green)
![Docker](https://img.shields.io/badge/Docker-20.10+-important)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2024.0.0-brightgreen)

## Table des matières
- [Architecture](#-architecture)
- [Services](#-services)
- [Technologies](#-technologies)
- [Prérequis](#-prérequis)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Déploiement](#-déploiement)
- [API](#-api)
- [Base de données](#-base-de-données)
- [Tests](#-tests)
- [Contributions](#-contributions)

##  Architecture
graph TD
    A[Client] --> B[API Gateway]
    B --> C[Service Commande]
    B --> D[Service Client]
    B --> E[Service Inventaire]
    C --> F[Service Discovery]
    D --> F
    E --> F
    F --> G[Config Server]
    C --> H[MySQL]
    D --> H
    E --> H
