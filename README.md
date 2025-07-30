
# Raspberries Seller Service

Simple seller service for marketplace.


## Authentication API

### Get Sellers Page

```http
POST /api/sellers?page=0&size=1
Content-Type: application/json

```


**Response (201 Created):**
```json
{
    "content": [
        {
            "id": 3,
            "logo": null,
            "name": "venom",
            "description": null,
            "taxId": "12345678900",
            "registrationDate": "2025-07-29T20:08:26.253346"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 1,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalElements": 3,
    "totalPages": 3,
    "size": 1,
    "number": 0,
    "first": true,
    "numberOfElements": 1,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "empty": false
}
```
### Get Seller By Id

```http
POST /api/seller/{id}
Content-Type: application/json

```


**Response (201 Created):**
```json
{
    "id": 8,
    "logo": null,
    "name": "venom",
    "description": null,
    "taxId": "12345678900",
    "registrationDate": "2025-07-29T20:17:07.636423"
}
```
### Creating a Seller

The service contains handleSellerRegistrationEvent for creating new registered seller from the **seller-registered** topic (from Auth Service)

### Application Config

src\main\resources\\**application-config.properties** contains the following secret values:
```
spring.datasource.password={password for DB}
spring.datasource.username={username for DB}
```


## Related

Here are other services of my project:

- [**Raspberries Gateway**](https://github.com/rvfw/Raspberries_Gateway)
- [Raspberries Auth Service](https://github.com/rvfw/Raspberries_AuthService)
- [Raspberries User Service](https://github.com/rvfw/Raspberries_UserService)

