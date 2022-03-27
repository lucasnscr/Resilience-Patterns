# Timeout Pattern

This Project implementing **Timeout** one of the Microservice Resilience Pattern using:

- Resilience4j
- Spring Boot
- Java

## Explaining Timeout Pattern
In microservice architecture, one service (A) depends on the other service (B), sometimes due to some network issue, Service B might not respond as expected. This slowness could affect Service A as well as A is waiting for the response from B to proceed further. As it is not uncommon issue, It is better to take this service unavailability issue into consideration while designing your microservices.

The timeout pattern is pretty straightforward and many HTTP clients have a default timeout configured. The goal is to avoid unbounded waiting times for responses and thus treating every request as failed where no response was received within the timeout.

Timeouts are used in almost every application to avoid requests getting stuck forever. Dealing with timeouts is not trivial, however. Imagine an order placement timing out in an online shop. You cannot be sure if the order was placed successfully but the response timed out if the order creation was still in progress, or the request was never processed. If you combine the timeout with a retry, you might end up with a duplicate order. If you mark the order as failed, the customer might think the order didn’t succeed but maybe it did and they will get charged.
## Advantages in use this pattern
- Make the core services work always even when the dependent services are not available
- We do not want to wait indefinitely
- We do not want to block any threads
- To handle network related issues and make the system remain functional using some cached responses.

