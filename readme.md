# Clean Architecture - Food Ordering System

This project is a hands-on implementation of microservices using Spring Boot, applying Clean Architecture and Hexagonal Architecture principles, along with DDD, SAGA, Outbox, CQRS, Kafka, Kubernetes, and GKE.

## Table of Contents
- [Description](#description)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Useful Commands](#useful-commands)
- [Resources](#resources)

## Description
This system simulates a food ordering process, split into independent microservices for each domain: customer, restaurant, order, and payment. Each service follows Clean Architecture and DDD principles, making the system scalable and maintainable.

## Architecture
- **Clean Architecture & Hexagonal Architecture**: Clear separation of layers and dependencies.
- **DDD (Domain-Driven Design)**: Rich, business-focused domain modeling.
- **SAGA & Outbox**: Distributed transaction management and eventual consistency.
- **CQRS**: Separation of commands and queries.
- **Kafka**: Asynchronous communication between microservices.
- **Kubernetes & GKE**: Cloud orchestration and deployment.

## Prerequisites
- Java 17+
- Maven 3.8+
- Docker & Docker Compose
- Kubernetes (minikube, kind, or GKE)

## Project Structure
```
food-ordering-system/
  ├── common/
  ├── customer-service/
  ├── infrastructure/
  ├── order-service/
  ├── payment-service/
  └── restaurant-service/
food-ordering-system-infra/
```
Each folder represents a microservice or shared module.

## How to Run
1. Clone the repository:
   ```bash
   git clone <repo-url>
   cd microservices-clean-architecture
   ```
2. Build the artifacts:
   ```bash
   mvn clean install -DskipTests
   ```
3. Start the local infrastructure (Kafka, Postgres, etc):
   ```bash
   cd food-ordering-system/infrastructure/docker-compose
   docker-compose -f common.yml -f zookeeper.yml -f kafka_cluster.yml -f init_kafka.yml up -d
   ```
4. Run the microservices from their respective modules or using Docker/Kubernetes.

## Useful Commands
- Initialize Kafka: `./commands-to-initialize-kafka.sh`
- Create topics: `cd food-ordering-system-infra && ./create-topics.sh`
- Deploy to Kubernetes: See files in `food-ordering-system-infra/`

## Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Kafka](https://kafka.apache.org/)
- [Kubernetes](https://kubernetes.io/)
- [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)

---

> Educational project to learn and practice modern microservices architectures.