<%--
  Created by IntelliJ IDEA.
  User: akhil
  Date: 2/26/2019
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/Template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory</h1>
            <p class="lead">Checkout all the awesome products inventory available now</p>

        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>

                    <td><img src="<c:url value="/resources/images/${product.productId}.png"></c:url>" alt="image"
                    style="width: 100%;"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <!--
                <c:url var="id" value="/productList/viewProduct"> <c:param name="id" value="${product.productId}"/></c:url>
                <td><a href="${id}"><span class="glyphicon glyphicon-info-sign"></span></a>
                </td>-->

                    <td><a href="<spring:url value="/productList/viewProduct/${product.productId}" />" >
                        <span class="glyphicon glyphicon-info-sign"></span></a>


                   <a href="<spring:url value="/productList/deleteProduct/${product.productId}" />" >
                        <span class="glyphicon glyphicon-remove"></span></a>

                        <a href="<spring:url value="/productInventory/editProduct/${product.productId}" />" >
                            <span class="glyphicon glyphicon-pencil"></span></a>

                    </td>

                </tr>

            </c:forEach>
        </table>
        <a href="<c:url value="/productInventory/addProduct"/>" class="btn btn-primary">Add Product</a>

        <%@include file="/WEB-INF/views/Template/footer.jsp"%>
