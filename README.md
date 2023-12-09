# Simple Ecommerce Application:

This Standalone Spring boot project demonstrates the crud operations on Product services using GraphQL as API.


## 1. In Memory H2 Database is used.
    So you can modify application.properies as per your database. 

## 2. Running as a Packaged Application (Following ways)
    WAY1: java -jar target/springboot-3-graphql-0.0.1-SNAPSHOT.jar
    WAY2: mvn spring-boot:run
    WAY3: docker compose up -d

## 3. Once the application is started you can access http://localhost:11111/graphiql
![GraphiQL](https://raw.githubusercontent.com/daveotengo/springboot-3-graphql/main/screenshots/Screenshot1.png)
![GraphiQL](https://raw.githubusercontent.com/daveotengo/springboot-3-graphql/main/screenshots/Screenshot2.png)
![GraphiQL](https://raw.githubusercontent.com/daveotengo/springboot-3-graphql/main/screenshots/Screenshot3.png)
![GraphiQL](https://raw.githubusercontent.com/daveotengo/springboot-3-graphql/main/screenshots/Screenshot4.png)
![GraphiQL](https://raw.githubusercontent.com/daveotengo/springboot-3-graphql/main/screenshots/Screenshot5.png)
![GraphiQL](https://raw.githubusercontent.com/daveotengo/springboot-3-graphql/main/screenshots/Screenshot6.png)
![GraphiQL](https://raw.githubusercontent.com/daveotengo/springboot-3-graphql/main/screenshots/Screenshot7.png)


## Testing the Application:

## GraphQL

### To retrieve AllProducts:
    ```
    GraphiQL Syntax:

     query GetAllProducts {
            getAllProducts {
                id
                name
                price
                stock
            }
        }
    
    JSON/postman syntax:
        {
            "query":"{getAllProducts{id name price stock {id name price stock} }}"
        }
    ```

### To createProduct:
    ```
    GraphiQL Syntax:
      
    mutation CreateProduct($input: CreateProductInput!) {
        createProduct(input: $input) {
            id
            name
            stock
            price
        }
    
    }

    {
    "input": {
    "name": "Your Product Name",
    "stock": 10,
    "price": 19.99
    }
    }

    ```
### To deleteProduct:

    ```
    mutation DeleteProduct($id: ID!) {
    deleteProduct(id: $id){
      message
      success
    }
    }
        
    {
        "id": "c52e6c2c-b2f7-49d9-90e7-053bb5277f3d"
    }
    ```

### To UpdateProduct:

    ```
       mutation UpdateProduct($input: UpdateProductInput!) {
          updateProduct(input: $input) {
            id
            stock
            price
          }
        }

      {
      "input": {
        "id": "b1c84223-a8f9-41f8-9e94-8e17ba0c7f7d",
        "stock": 50,  
        "price": 29.99  
      }
    }

    ```

### To GetProductById:

    ```
    query GetProductById($id: ID!) {
        getProductById(id: $id) {
            id
            name
            stock
            price
        }
    }

    {
    "id": "663d7c62-f02a-47fe-946b-810e189e08db"
    }
   
### Curl request to graphql:
    
    ```

    curl -X POST \
    -H "Content-Type: application/json" \
    --data '{"query": "query { getAllProducts { id name price stock } }"}' \
    http://localhost:11111/graphql
    ```
### Curl response to graphql:
     ```
    {"data":{"getAllProducts":[{"id":"e7a571a8-1970-497a-b658-5f43468c4d1b","name":"Product A","price":20.0,"stock":50},{"id":"ad726ff2-d9cf-4a77-8954-57fe9ace3c4c","name":"Product B","price":30.0,"stock":30}]}}%   
    
    ```
