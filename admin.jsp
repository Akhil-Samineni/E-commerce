<%--
  Created by IntelliJ IDEA.
  User: akhil
  Date: 2/26/2019
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/Template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>
            <p class="lead">This is a administrator page</p>

        </div>
        <a href="<c:url value="/admin/productInventory"> </c:url>" >Product Inventory</a>
        <%@include file="/WEB-INF/views/Template/footer.jsp"%>
