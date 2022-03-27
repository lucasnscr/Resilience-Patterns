# Circuit Breaker Pattern

This Project implementing **Circuit Breaker** one of the Microservice Resilience Pattern using:

- Resilience4j
- Spring Boot
- Java

## Explaining Circuit Breaker Pattern

Great for preventing a service failure that could lead to cascading failures throughout the application. A Microservice must request another Microservice through a proxy that works similarly to an Electrical Circuit Breaker. The proxy should count the number of recent failures that have occurred and use that to decide whether to allow the operation to continue or simply return an exception immediately.

The circuit have three states: **Closed, Open and Half-Open**

**Closed**
The Circuit Breaker forwards requests to the Microservice and counts the number of failures in a given period of time. If the number of failures in a given period of time exceeds a threshold, it trips and goes into the open state.

**Open**
the microservice request fails immediately and an exception is returned. After a timeout, the circuit breaker goes into a half-open state.

**Half-Open**
Only a limited number of Microservice requests are allowed to pass and invoke the operation. If these requests are successful, the circuit breaker will enter the Closed state. If any request fails, the circuit breaker goes into the Open state.

**Strong**

- Improve fault tolerance and resilience of microservices architecture.
- Stops the cascade of failures for other microservices.

**Weak**
- Needs sophisticated exception handling.

## When to use this pattern
- Incremental migration of a large Backend Monolithic application to Microservices.
- In large corporations, API Gateway is mandatory to centralize cross-cutting and security concerns.

## When not to use Circuit Breaker
- Loosely coupled, event-driven microservices architecture.