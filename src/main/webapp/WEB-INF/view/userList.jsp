<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="menu.jsp" />

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>List of User</title>
    </head>
    <body>
        <table style="margin-top:9px" class="table table-striped table-dark">
            <thead>
              <tr>
                <th scope="col">User Name</th>
                <th scope="col">Password</th>
                <th scope="col">EmailId</th>
                <th scope="col">Gender</th>
                <th scope="col">Role</th>
                <th scope="col">Question</th>
                <th scope="col">Answer</th>
                <th scope="col">ACTION</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${users}" var="user">
              <tr>
              <td><c:out value="${user.username}"></c:out></td>
              <td><c:out value="${user.password}"></c:out></td>
              <td><c:out value="${user.email}"></c:out></td>
              <td><c:out value="${user.gender}"></c:out></td>
              <td><c:out value="${user.role}"></c:out></td>
              <td><c:out value="${user.question}"></c:out></td>
              <td><c:out value="${user.answer}"></c:out></td>
              <td><a href="profile?username=${user.username}">EDIT</a>/<a>DELETE</a></td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
    </body>
</html>