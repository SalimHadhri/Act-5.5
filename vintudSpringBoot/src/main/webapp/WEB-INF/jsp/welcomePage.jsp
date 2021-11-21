<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
     <title>Welcome page</title>
     <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
    <div>
        <div>
            <h1>WELCOME TO VENTUD APPLICATION</h1>
            <h2>${message}</h2>
             
            CLICK ON THIS <strong><a href="ListCategory">LINK</a></strong> TO VISIT OUR CATEGORY PAGE
        </div>
    </div>
</body>
</html>