<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">${param.pageName}</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${requestScope.activePage == 'products' ? 'active' : ''}">
                <c:url value="/products" var="productsUrl"/>
                <a class="nav-link" href="${productsUrl}">Products</a>
            </li>
            <li class="nav-item ${requestScope.activePage == 'catalog' ? 'active' : ''}">
                <c:url value="/catalog" var="catalogUrl"/>
                <a class="nav-link" href="${catalogUrl}">Catalog</a>
            </li>
            <li class="nav-item ${requestScope.activePage == 'cart' ? 'active' : ''}">
                <c:url value="/cart" var="cartUrl"/>
                <a class="nav-link" href="${cartUrl}">Cart</a>
            </li>
        </ul>
    </div>
</nav>