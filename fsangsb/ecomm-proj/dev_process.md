Development Process
===================

4 - Search by category (enhanced version) - read categories from db via REST API
--------------------------------------------------------------------------------
1. Modify Spring Boot app - Expose entity ids

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