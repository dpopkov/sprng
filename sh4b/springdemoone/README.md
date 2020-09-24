spring-demo-one
===============

#### Spring Development Process
1. Configure your Spring Beans
2. Create a Spring Container
3. Retrieve Beans from Spring Container

#### Development Process - Constructor Injection

1. Define the dependency interface and class
2. Create a constructor in your class for injections
3. Configure the dependency injection in Spring config file

#### Development Process - Setter Injection

1. Create setter method(s) in your class for injection
2. Configure the dependency injection in Spring config class


Bean Scopes
-----------
* Scope refers to the lifecycle of a baan
* How long does the bean live?
* How many instances are created?
* How is the bean shared?

### What is a Singleton?
* Spring Container creates only one instance of the bean, by default.
* It is cached in memory.
* All requests for the bean will return a SHARED reference to the SAME bean.

### Explicitly Specifying Bean Scope
```XML
<bean id="beanId" class="package.ClassName"
      scope="singleton">
</bean>
```
Spring Bean scopes: singleton, prototype, request, session, global-session.

### Bean lifecycle
```XML
<bean id="beanId" class="package.ClassName"
      init-method="doMyStartupStuff"
      destroy-method="doMyCleanupStuff">
</bean>
```
