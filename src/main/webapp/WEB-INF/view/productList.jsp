<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="menu.jsp" />

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>List of Product</title>
    </head>
    <body>
        <table style="margin-top:9px" class="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">Product Id</th>
                <th scope="col">Product Name</th>
                <th scope="col">Price</th>
                <th scope="col">ProductExpiryDate</th>
                <th scope="col">ACTION</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${products}" var="product">
              <tr>
              <td><c:out value="${product.prodId}"></c:out></td>
              <td><c:out value="${product.prodName}"></c:out></td>
              <td><c:out value="${product.prodPrice}"></c:out></td>
              <td><c:out value="${product.prodExpDate}"></c:out></td>
               <td><a href="profile?prodId=${product.prodId}">EDIT</a>/<a>DELETE</a></td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
    </body>
</html>