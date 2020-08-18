<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragment/head.jsp"/>

<body>

<jsp:include page="fragment/navigation.jsp">
    <jsp:param name="pageName" value="Корзина"/>
</jsp:include>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Price</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="prod" items="${requestScope.cart.products}">
                        <tr>
                            <td>
                                <c:out value="${prod.name}"/>
                            </td>
                            <td>
                                <c:out value="${prod.description}"/>
                            </td>
                            <td>
                                    <c:out value="${prod.price}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="fragment/scripts.jsp"/>

</body>
</html>