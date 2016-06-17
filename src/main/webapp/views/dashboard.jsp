<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>zPay API Console - Sandbox</title>
        <style>
            .vendorAPIWrapper{
                width: 100%;
            }
            .vendorAPIWrapper thead tr > th {
                text-align: left;
            }
            .GCMWrapper {
                width: 100%;
            }
            .GCMWrapper .gcmValue {
                width: 100%;
            }
        </style>
    </head>
    <body>


        <br>

        <table class="vendorAPIWrapper">            
                <tr>
                    <th>QR Code</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone #</th>
                    <th>API</th>
                </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <tr>            
                    <td><img src="/qrcode/${user.id}"></td>                    
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.email}</td>

 
                </tr>                
            </c:forEach>
            </table>
</body>
</html>
