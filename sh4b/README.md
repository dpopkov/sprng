sh4b - Spring & Hibernate for Beginners
=======================================

### 25 - [spring-crm-rest](springcrmrestdemo)

#### CRM REST Application
* Add configuration, DAO and Service. 
* Create REST Controller.
* Get list of customers, get a single customer.
* Add exception handling.

### 24 - [spring-rest-demo](sprinrestdemo)

#### Spring REST
* Simple REST Controller using @RestController annotation.
* Use Postman for testing.
* Retrieve POJO as JSON - implement REST Controller returning list of students.
* Use @PathVariable for REST endpoints.
  
#### Sprint REST Exception Handling
* Spring REST exception handling using @ExceptionHandler annotation.
* Add generic exception handler.
* Implement global exception handling using @ControllerAdvice.

### 23 - [jackson-databind-json-demo](jacksondatabindjsondemo)

#### JSON Data Binding
* Read JSON to POJO.
* Process nested objects and arrays.
* Ignore unknown JSON properties.

### 22 - [spring-security-demo-08-jdbc-plain](springsecuritydemo08jdbcplain)

#### JDBC Database Authentication
* Create sql schema, add db properties.
* Use @PropertySource annotation and org.springframework.core.env.Environment to read properties.  
* Define and configure DataSource.
* Update Spring Security Configuration to use JDBC.
* Apply Password Encryption.

### 21 - [spring-security-demo-07-user-roles](springsecuritydemo07userroles)

#### User Roles
* Display user IDs and Roles.
* Restrict access based on Roles.
* Add custom 'Access Denied' page.
* Display content based on Roles.

### 20 - [spring-security-demo-06-csrf](springsecuritydemo06csrf)

#### Spring Security - CSRF
* Manually Add CSRF Tokens.

### 19 - [spring-security-demo-02-basic](springsecuritydemo02basic)

#### Spring Security - Create Security Initializer, Login/Logout
* Spring Security config with AbstractSecurityWebApplicationInitializer.
* Add Custom Login Form.
* Show Login Error Message.
* Add Bootstrap CSS to Login Form.
* Add Logout support.

### 18 - [spring-security-demo](springsecuritydemo)

#### Spring Security - Getting Started
* Use Java Configuration with AbstractAnnotationConfigDispatcherServletInitializer (no web.xml).

### 17 - [web-customer-tracker-aop](webcustomertrackeraop)

#### Add AOP logging to Spring MVC App
* Use @Before to add logging to application flow.
* Use @AfterReturning to add logging.

### 16 - [spring-demo-aop-around](springdemoaoparound)

#### @Around
* Use @Around Advice.
* Resolve Print Order Issue - use same logger output.
* @Around Advice - handle exceptions.
* @Around Advice - rethrowing exceptions.

### 15 - [spring-demo-aop-after-returning](springdemoaopafterreturning)\

#### @AfterReturning, @AfterThrowing, @After (finally)
* @AfterReturning Advice.
* Use @AfterReturning for post-processing data.
* Use @AfterThrowing Advice for processing exceptions.
* @After (finally) Advice.

### 14 - [spring-demo-aop-order-aspects](springdemoaoporderaspects)

### Spring AOP Aspects Ordering
* Control Aspect Order using @Order annotation.
* Read method signature and arguments with Joinpoints.

### 13 - [spring-demo-aop-pointcut-declarations](springdemoaoppointcutdeclarations)

#### Spring AOP Pointcut declarations
* Use Pointcut declarations.
* Combine Pointcuts using logical operators (&&, ||, !).

### 12 - [spring-demo-aop](springdemoaop)

#### Spring AOP Example Project
* Create basic demo w/o AOP
* Create an Aspect with @Before advice.
* Use Pointcut expressions matching any class.
* Use Pointcut expressions with wildcards.
* Use Pointcut expressions with parameters.
* Use Pointcut expressions for package.

### 11 - [web-customer-tracker](webcustomertracker)

#### Spring MVC and Hibernate Project
* Configure database dataSource / connection pool.
* Test Basic Spring MVC Controller.
* Create Entity. Define Data Access Object (DAO). Use @Repository and @Transactional annotations. 
* Implement Listing Customers.
* Add CSS and redirect from the index.jsp to controller.
* Use @GetMapping and @PostMapping instead of @RequestMapping.
* Add a Service Layer - define Service with @Service annotation.
* Create form and processing for Adding Customer to service and DAO.
* Add sorting in list of customers.
* Create a link and processing for Updating Customer.
* Create a link and processing for Deleting Customer.

### 10 - [hb-06-many-to-many](hb06manytomany)

#### ManyToMany Mapping
* Use @ManyToMany, @JoinTable and @JoinColumn annotations.
* Delete Entities in ManyToMany without cascading.

### 9 - [hb-05-one-to-many-uni](hb05onetomanyuni)

#### Hibernate uni-directional OneToMany Mapping
* Use @OneToMany and @JoinColumn annotations.
* Use cascading Saving, Getting and Deletion.

### 8 - [hb-04-eager-vs-lazy-demo](hb04eagervslazydemo)

#### Eager vs Lazy Loading (closing Session issue)
* Get Lazy Entities before closing session.
* Use HQL JOIN FETCH.

### 7 - [hb-03-one-to-many](hb03onetomany)

#### Hibernate bi-directional OneToMany Mapping
* Use @OneToMany, @ManyToOne, and @JoinColumn annotations.
* Delete Entities without cascading.

### 6 - [hb-02-one-to-one-bi](hb02onetoonebi)

#### Hibernate bi-directional OneToOne Mapping
* Use bi-directional @OneToOne.
* Delete bi-directional @OneToOne Entity.
* Delete only one Entity from bi-directional @OneToOne Entities.

### 5 - [hb-01-one-to-one-uni](hb01onetooneuni)

#### Hibernate OneToOne Mapping
* Use uni-directional @OneToOne and @JoinColumn annotations for linking relative Entity.
* Delete @OneToOne Entities.

### 4 - [hibernate-tutorial](hibernatetutor)

#### Hibernate
* Setup and test JDBC connection.
* Create configuration file - hibernate.cfg.xml.
* Use Annotations for mapping, Create and Save Entities.
* Retrieve Entities using the primary key.
* Query Entities using HQL.
* Update and Delete Entities.
* Handle Dates with Hibernate.

### 3 - [spring-mvc-demo](springmvcdemo)

#### Spring MVC - Building Spring Web Apps
* Configure a dispatcher servlet and contextConfigLocation in web.xml.
* Enable Component Scanning in context config file (context:component-scan).
* Configure Spring Bean for view resolver.
* Creating Controllers and Views.
* Reading Form Data.
* Adding Data to Model.
* Binding Request Parameters with @RequestParam annotation.
* Controller Request Mapping.
* Use Form Text Fields and Data Binding with @ModelAttribute annotation.
* Use Form Drop-Down Lists, RadioButtons and Checkboxes.
* Spring MVC Form Validation - applying Hibernate Validator and @InitBinder annotation.
* Validating Number Ranges using @Min, @Max annotations.
* Validating with Regular Expressions using @Pattern annotation.
* Make Integer field required, add custom messages.
* Creating Custom Validation Rule Annotation.

### 2 - [spring-demo-annotations](springdemoannotations)

#### Spring Inversion of Control - Configuration with Java Annotations
* Enable Component Scanning in config file.
* Add @Component annotation with bean-id to bean classes.
* Using Default Component names.
* Autowiring for Constructor injection.
* Autowiring for Setter (or any method) injection.
* Autowiring for Field injection.
* Autowiring using @Qualifier annotation.
* Using @Scope annotation (singleton, prototype).
* Using Bean Lifecycle Method annotations (@PostConstruct, @PreDestroy).
* Spring config with Java code (no XML).
* Defining Spring Beans with Java code (no XML).
* Injecting Values from Properties files using @PropertySource and @Value annotations.

### 1 - [spring-demo-one](springdemoone)

#### Spring Inversion of Control - XML Configuration
* Use XML configuration - ClassPathXmlApplicationContext.
* Configure Spring logging level using custom LoggerConfig bean.
* Use Constructor Injection.
* Use Setter Injection.
* Injecting Literal Values.
* Injecting values from a properties file.
* Setup bean scope (singleton or prototype).
* Bean Lifecycle (init-method, destroy-method).
