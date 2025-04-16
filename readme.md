# Beverage Distributor API

This repository contains the implementation of a Beverage Distributor API system. 

## Brainstorm Summary

I have chosen the common layered architecture with controller, service, and repository to decouple the domain and make it more maintainable.

This project has one controller for each use-case, I configured a swagger to better view the solution-specification.
I used built-in validation annotations for entities, and custom exceptions to handle biz logic and maintain code organization.

The fallback It uses the Retry from Spring Retry, and after it fails three times it persist a pending record for later reprocess.

Future improvements:
 - The fallback solution is not a one-size-fits-all, we can implement circuit-breaker pattern and asynchronous MQs.
 - The response from the API could be customized to have a better presentation with RestControllerAdvice.
 - I just attend the use-cases, but we could have implemented all the other endpoints to GET and PATCH our data.
 - We could add an observability tool to monitor the Fornecedor API and have more control over the low availability times.
 - Implement unit tests and e2e tests using JUnit or Mockito.

## 📚 [API Use Cases](docs/use-cases.md)

## 🔧 Current Project Stack

- **Java 24**
- **Spring Boot (Web, JPA, Validation)** 3.4.4
- **Spring Retry** 2.0.11
- **H2 Database** 2.3.232
- **Lombok** 1.18.36
- **Maven** 4.0.0
- **Springdoc** 2.8.6