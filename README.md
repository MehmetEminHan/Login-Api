## Database
H2 database used for this project and H2 console link = http://localhost:8080/h2-console                  
UserName=sa       
password=123



## Endpoints

Login endpoint:

```http
POST v1/user/login
```

Logout endpoint:

```http
POST v1/user/logout
```

Register endpoint:

```http
POST v1/user/register
```

| Parameter | Type     | Description             |
|:----------|:---------|:------------------------|
| `UserDTO` | `Object` | **Required**. Login.    |
| `UserDTO` | `Object` | **Required**. Logout.   |
| `UserDTO` | `Object` | **Required**. Register. |


## Example Requests

For login:
```javascript
{
    "email": "EMAIL",
    "password": "PASSWORD"
    
    or

    "userName": "USERNAME",
    "password": "PASSWORD"
}
```

For logout:
```javascript
{
    "email": "EMAIL"
}
```
For register:
```javascript
{
    "email": "foo@gmail.com",
    "userName": "John Doe",
    "password": "111"
}
```
