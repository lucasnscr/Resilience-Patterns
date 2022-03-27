# Concepts and Implementations of Resilience Patterns in Microservice Architecture

Monolithic solutions or solutions where a single point of failure can derail an operation is a big problem. In products and platforms that target availability as an essential feature, this problem ends up creating major engineering challenges. This difficulty can be solved with a Microservices architecture. This architecture aims to: Make processes independent and managed in a unique way and without interdependence, so responsibilities are divided and decentralized, something very common in a distributed computing pattern. Problems happen in isolation and problems are solved.

In technology there is no perfect solution, questions about availability will always be pertinent. Is a microservices architecture fault resilient? In that case the answer is: No, totally.

Migrating between architectures will not guarantee the complete resolution of all your fault tolerance issues, in which case our issues and our solutions change name and address.

A distributed computing architecture can only be called fault tolerant if it has resilience and its patterns as the essence of its construction. We need to note that distributed components can fail, but in that case we will anticipate failures and manage them.

Conceptually, resilience assumes the premise that failures happen at any time and that we must be ready for any scenario. Questions like, Service A communicates with Service B only works through responses from Service C. What are we going to make Service B stop? What fallback treatment plan will we have in this circumstance?

- Work with default values?
- Request information from service C?
- Return an error message?

By applying resilience and its patterns, you will probably know how to act in the best way when idealizing and building a product, a much more favorable scenario than crises in productive environments.



## Faults and Microservice architecture
When you finish a migration between monolith and Microservice, the first thing you'll notice is the number of components that need to be managed. All these interconnected components make up the solution. A good way to compare this architecture to an orchestra. Both need good tuning. In order for the orchestra to reach the audience's ecstasy, the conductor conducts the entire symphony, resilience will be the conductor of our orchestra, promoting discussions such as tolerance and dealing with failures with failures as scenarios and not crises. For our product to perform with mastery, components cannot fail and compromise all our engineering and architecture.

## How to build Resilient services?

**Scenario Identification**

Prior to our delivery to production, we perform integration, performance, unit and architectural tests. All these tests are essential for the perfect functioning of functions and code quality, but they do not mitigate failure scenarios. Mapping failure scenarios is an essential task when designing a solution. Architecture and engineering need to work closely together on the best solution for the business. The business needs to be fully together when deciding how to handle failures. Questions like:

- Are we able to map our risk and crisis scenario?
- Are we ready to support failure across the entire service layer?
- How to recover from failures quickly and with minimal impact?

The perfect scenario to address resilience within agile methodology teams is: Solutions Architects, Tech Leads and Product Owner, need an error mapping process at the time of refinement so that each feature can have its risk map and documentation containing all feature details and solution decisions. This needs to be recorded and made available for the engineering team to consult at the time of construction.

Once we have a failure mitigation plan and an automatic recovery plan, we will introduce a concept popularly known as Chaos Engineering. Where we will test and create engineering situations in which we will follow the behavior of a set of services in a crisis situation and how fault tolerance will behave in scenarios:

- Service A not communicating with other services
- Database unavailability
- Server without Communication
- High response time
- Failure in integrations in general

**Mitigating cascading failures**

Dependencies between services makes the solution prone to cascading errors, a small problem can become a big problem. So that you do not propagate errors, it is necessary to ensure that this type of failure does not occur in order to better manage network resources, using threads is a good way to network, but an essential point is that the failed service recovers from automatically.

**Mitigating single points of failure**

The instant we are designing something, we need to discuss fault tolerance, we need to make sure that we are designing something that is not dependent on a single component. Solutions need to be designed so that single points of failure do not exist, dealing with requests is the technology challenge and ensuring availability of the entire ecosystem is essential. In addition to mapping, recovery strategy is critical to success.

Tolerating failures is our mantra and in case of errors and exceptions we need to deal with them in the best possible way, creating messages or default values ​​for the business, these are types of solutions that we can adopt so that failures and elegance fit in the same sentence.




## Implementing Resilience Patterns

Now that we have defined the concepts of fault tolerance in agile projects, recovery and resilience, we will implement the main resilience patterns. We will go in a conceptual approach with drawings that illustrate the situations, we will make available a project on GitHub that implements all the mentioned patterns so that in addition to the concept we have construction examples. The patterns that will be implemented are:

- Rate Limiter
- Bulkhead
- Circuit Breaker
- Retry
- Timeout

All projects will be built with the following technologies:
- Java 17
- Spring Boot
- Lombok
- Spring Boot Actuator