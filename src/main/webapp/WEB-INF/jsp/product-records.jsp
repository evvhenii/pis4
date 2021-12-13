<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Record</title>
</head>
<body>
<h1>List of all items:</h1>
<table style="border: 1px solid black;">
    <thead>
    <tr>
        <th style="border: 1px solid black;">#   </th>
        <th style="border: 1px solid black;">          Name               </th>
        <th style="border: 1px solid black;">Quantity      </th>
        <th style="border: 1px solid black;">Price      </th>
        <th style="border: 1px solid black;">Code                                  </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productRecords}">
        <tr style="border: 1px solid black;">
            <td style="border: 1px solid black;"></td>
            <td style="border: 1px solid black;"><strong>${product.name}</strong></td>
            <td style="border: 1px solid black;">${product.quantity}</td>
            <td style="border: 1px solid black;">${product.price}</td>
            <td style="border: 1px solid black;">${product.code}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--<form action='product-creation.jsp'><input type='submit' value='Add an item' /></form>--%>
<%--<jsp:forward page="product-creation.jsp" />--%>
<%--<a href="WEB-INF/jsp/product-creation.jsp">Add an item</a>--%>

<h1>Add a new item</h1>
<form action="/products" method="post">
    <table style="width: 25%">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="number" name="quantity" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price" /></td>
        </tr>
    </table>
    <input type="submit" value="Add" />
</form>


</body>
</html>