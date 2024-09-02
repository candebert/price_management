# Price Management System
This is a test project from GFT.

## MVP
Return information about prices. These prices are getting by a specific date, brand ID and product ID.

## Contract

```
 Method GET: /price_management/get_price?date=${date}&product_id=${product_id}&brand_id=${brand_id}
 
 Response: 
 {
    "product_id": 35455,
    "brand_id": 1,
    "price_list": 1,
    "price": 35.50,
    "currency": "EUR",
    "start_date": "2020-03-04 00:50:00",
    "end_date": "2020-03-04 00:50:00"
 }
 
 Response Errors:
 (404) Brand ID not found
 (404) Product ID not found
 (404) Date not found
 (404) Brand ID + Product ID + Date not found
```

## Run project

### 1. Build Docker image
```
docker build -t price_management .
```

### 2. Run project
```
docker run -p 8080:8080 price_management
```
### 3. [Go to Contract](http://localhost:8080)
