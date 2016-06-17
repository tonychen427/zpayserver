## zPay Server ##
 
Place the zPay QR Code anywhere - Customers scan the QR Code and you're paid in seconds. 
Payments are quick, secure and effortless and you spend less time and money taking payments 
and chasing up invoices. Cash flow improves, sales increase, costs decrease and customers 
enjoy buying from you.



#### zPay - User API ####

Header Content-Type  : application/json  
Header Authorization : 9605774e-b76a-48f7-a92a-15b2a2bd0a4b

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