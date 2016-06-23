
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

Request    
{
    "firstName":"Bill",
    "lastName":"Clinton",
    "phone":"408-555-8888",
    "email":"b.clinton@zpay.com"
}

Response
{
    "targetURL": "/api/APIProvisioning",
    "apiKey": "9605774e-b76a-48f7-a92a-15b2a2bd0a4b",
    "accessToken": null,
    "data": null,
    "status": "CREATED"
}

```

#### zPay - AccessToken API ####
You should NOT request a new access token for every API call you make,  
each access token is good for every time the device requested and should be reused. 
Making two API calls for every one operation is inefficient and may result in throttling.

Header Content-Type  : application/json  
Header Authorization : << APIProvisioningKey >>  

POST http://localhost:8080/api/requestToken/
```json

Request
{
    "id" : "-KKqnRHJf38NweW1k_x9",
    "fcm_deviceRegId" : "ab4801f0-331d-11e6-bdf4-0852698d45d2"
}

Response
{
    "targetURL": "/api/requestToken",
    "apiKey": "9605774e-b76a-48f7-a92a-15b2a2bd0a4b",
    "accessToken": "1154a33b-bd07-4b6e-80a8-4a35ec199ade",
    "data": "",
    "status": "OK"
}

```


#### zPay - User API ####

Header Content-Type  : application/json  
Header Authorization : Bearer << accessToken >>

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