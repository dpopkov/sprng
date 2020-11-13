Development Process
===================

19 - Checkout Form - Custom Validation
--------------------------------------
1. Define custom validator rule
2. Specify custom validator rule for the form controls
3. Update HTML template to display error messages

18 - Checkout Form - Validation
-------------------------------
1. Specify validation rules for the form controls
2. Define Getter methods to access form controls
3. Update HTML template to display error messages
4. Add event handler to check validation status when submit button clicked

17 - Checkout Form - Populate Countries and States: Frontend
------------------------------------------------------------
1. Create TypeScript classes for Country and State
2. Add methods to the form service for countries and states
3. Update checkout component to retrieve the countries from service
4. Update HTML template to populate dropdown lists for countries
5. Add event handler for checkout component for retrieving list of states based on country

16 - Checkout Form - Populate Countries and States
--------------------------------------------------
1. Create database tables
2. Develop JPA Entities (Country, State)
3. Create Spring Data Repositories
4. Update Spring Data REST Configs

15 - Checkout Form - Dropdown Lists - Populate Credit Card expiration dates
---------------------------------------------------------------------------
1. Generate form service: ShopFormService
2. Add methods to the form service for months and years
3. Update checkout component to retrieve the months and years from service
4. Update HTML template to populate drop-down lists for months and years
5. Use dependent fields for expiration year and month

14 - Checkout Form - Layout
---------------------------
1. Generate the checkout component
2. Add a new route for checkout component
3. Create a new checkout button and link to checkout component
4. Add support for reactive forms
5. Define form in component .ts file
6. Layout form controls in HTML template
7. Add event handler for form submission
8. Add for code and input for Shipping Address, Billing Address, and Credit Card
9. Review your order

13 - Cart Details Page: add / remove items
------------------------------------------
1. Modify CartDetailsComponent HTML template (add increment buttons)
2. Add click handler for the "increment" button
3. Add click handler for the "decrement" button on HTML template
4. Update CartDetailsComponent with click handler method
5. Modify CartService with supporting method
6. Repeat process for "Remove" button

12 - Cart Details Page: list the items in the cart
--------------------------------------------------
1. Create new component: CartDetailsComponent
2. Add new route for CartDetailsComponent to app.module.ts
3. Update link for Shopping Cart icon
4. Modify CartDetailComponent to retrieve cart items
5. Add HTML template for CartDetails Component
6. Handle an empty cart

11 - Add Cart Status Component: on main page, display total price and quantity
------------------------------------------------------------------------------
1. Create new component: CartStatusComponent
2. Add HTML template for CartStatusComponent
3. Add click handler for "Add to cart" button
4. Update ProductListComponent with click handler method
5. Create model class: CartItem
6. Develop CartService
7. Modify ProductListComponent to call CartService
8. Enhance CartStatusComponent to subscribe to CartService
9. Update CartStatusComponent HTML to display cart total price and quantity
10. Add to Cart from Details View

10 - Pagination for keyword search
----------------------------------
1. Add pagination support to ProductService
2. Update ProductListComponent to handle pagination

8 - Pagination - Selecting Page size
------------------------------------
1. Add drop-down list for page size to HTML template
2. Update ProductListComponent for setting page size
3. Add parameters for setting Max Size and Boundary Links 

7 - Add pagination support for products
---------------------------------------
1. Install ng-bootstrap (ng add @ng-bootstrap/ng-bootstrap)
2. Refactor(update) the interface GetResponseProducts in products.service
3. Add pagination support to ProductService
4. Update ProductListComponent to handle pagination
5. Enhance HTML template to use ng-bootstrap pagination component

6 - Product Master-Detail View
------------------------------
1. Create new component for product details
2. Add new Angular route for product details
3. Add router links to the product-list-grid HTML page
4. Enhance ProductDetailsComponent to retrieve product from ProductService
5. Update ProductService to call URL on Spring Boot app
6. Update HTML page for ProductDetailsComponent to display product details

5 - Search for products by text box (by keyword)
------------------------------------------------
1. Modify Spring Boot app - Add a new search method findByNameContaining
2. Create new component for search
3. Add new Angular route for searching
4. Update the new SearchComponent to send data to search route
5. Enhance ProductListComponent to search for products with ProductService
6. Update ProductService to call URL on Spring Boot app

4 - Search by category (enhanced version) - read categories from db via REST API
--------------------------------------------------------------------------------
1. Modify Spring Boot app - Expose entity ids
2. Create a class: Product Category
3. Create new component for menu
4. Enhance menu component to read data from product service
5. Update product service to call URL on Spring Boot app

3 - Search for Products by Category
-----------------------------------
1. Define routes
2. Configure Router based on the routes
3. Define the Router Outlet
4. Set upt Router Links to pass category id param
5. Enhance ProductListComponent to read category id param
6. Modify Spring Boot app - REST Repository needs new query method
7. Update Angular Service to call new URL on Spring Boot app

2 - Online Shop Template Integration
------------------------------------
1. Download the HTML template starter files
2. Install Bootstrap CSS styles locally using npm: `npm install bootstrap` and delete the link from index.html
3. Install FontAwesome locally using npm: `npm install @fortawesome/fontawesome-free`
4. Add global CSS styles to angular.json file
5. Add local custom CSS styles to Angular src/styles.css file
6. Integrate template files into Angular app
7. Add support for icons and logos
8. Add support for product grid
9. Enhance the application with product images (not committing real images in src/assets/images/products)

1 - Add Angular Front End for Product List
------------------------------------------
1. Create Angular project: `ng new angular-ecomm`
2. Create Angular component for product-list: `ng generate component component/product-list`
3. Develop TypeScript class for Product: `ng generate class common/product`
4. Create Angular service to call REST API: `ng generate service services/product`
5. Update Angular component to subscribe to data from Angular service
6. Display the data in an HTML page
7. Add CrossOrigin support to Spring Boot app
