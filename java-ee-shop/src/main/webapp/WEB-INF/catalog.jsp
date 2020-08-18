<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragment/head.jsp"/>

<body>

<jsp:include page="fragment/navigation.jsp">
    <jsp:param name="pageName" value="Категории"/>
</jsp:include>

<div class="container">
    <div class="row py-2">
            <table class="table table-bordered my-2">
                  <thead>
                  <tr>
                      <th scope="col">Name</th>
                  </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="brand" items="${requestScope.catalog}">
                          <tr>
                              <td>
                                  <c:out value="${prod.name}"/>
                              </td>
                          </tr>
                      </c:forEach>
                  </tbody>
            </table>
    </div>
</div>

<jsp:include page="fragment/scripts.jsp"/>

</body>
</html>