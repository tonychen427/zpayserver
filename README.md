
<img src="http://maggie.clientsbox.com/img/zpay.png">

## zPay Server ##
 
Place the zPay QR Code anywhere - Customers scan the QR Code and you're paid in seconds. 
Payments are quick, secure and effortless and you spend less time and money taking payments 
and chasing up invoices. Cash flow improves, sales increase, costs decrease and customers 
enjoy buying from you.

#### zPay - APIProvisioning API ####

GET: localhost:8080/api/APIProvisionings

POST http://localhost:8080/api/APIProvisioning/

```json

    {
        "firstName":"Bill",
        "lastName":"Clinton",
        "phone":"408-555-8888",
        "email":"b.clinton@zpay.com"
    }

```

#### zPay - AccessToken API ####
POST http://localhost:8080/api/requestToken/
Header Content-Type  : application/json  
Header Authorization : <<APIProvisioningKey>>

```json

    {
        "id" : "-KKqnRHJf38NweW1k_x9",
        "fcm_deviceRegId" : "ab4801f0-331d-11e6-bdf4-0852698d45d2"
    }

```


#### zPay - User API ####

Header Content-Type  : application/json  
Header Authorization : Bearer <<accessToken>>

GET: localhost:8080/api/users

GET: localhost:8080/api/user/{id}

DELETE: localhost:8080/api/user/{id}

POST: http://localhost:8080/api/user/
```json

  {
    "firstname": "John",
    "lastname": "Smith",
    "username": "jsmith",
    "password": "welcome123",
    "email": "john.smith@zpay.com",
    "mobile": "408-000-8888",
    "userCategory": "client",
    "fcm_deviceRegId": "ab4801f0-331d-11e6-bdf4-0852698d45d2"
  }

```

PUT: http://localhost:8080/api/user/{id}
```json

  {
    "firstname": "Marry",
    "lastname": "Smith",
    "username": "msmith",
    "password": "welcome123",
    "email": "marry.smith@zpay.com",
    "mobile": "408-000-8888",
    "userCategory": "client",
    "fcm_deviceRegId": "ab4801f0-331d-11e6-bdf4-0852698d45d2"
  }

```

#### zPay - FCM API ####

PUT http://localhost:8080/api/fcm
```json

{
    "fromUserId": "-KKXhVmO_qxQY-xBjsSh",
    "sendUserId": "-KK_TUvvbX3Q78j2JRYM",
    "data": "Whatever you want"
}

```