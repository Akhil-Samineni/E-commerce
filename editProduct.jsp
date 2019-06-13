<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/Template/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>
            <p class="lead">Please update the product information here</p>
        </div>
        <form:form action="${pageContext.request.contextPath}/productInventory/editProduct" method="post" commandName="product"
                   enctype="multipart/form-data">
            <form:hidden path="productId" value="${product.productId}"/>
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="productName" id="name" class="form-Control" value="${product.productName}"></form:input>
            </div>
            <div class="form-group">
                <label for="category">Category</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCategory" id="category" value="instrument" class="form-Control"></form:radiobutton>Instrument
                </label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCategory" id="category" value="record" class="form-Control"></form:radiobutton>Record
                </label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCategory" id="category" value="accessory" class="form-Control"></form:radiobutton>Accessory
                </label>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <form:textarea path="productDescription" id="description" class="form-Control" value="${product.productDescription}"></form:textarea>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <form:input path="productPrice" id="price" class="form-Control" value="${product.productPrice}"></form:input>
            </div>
            <div class="form-group">
                <label for="condition">productCondition</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCondition" id="condition" value="new" class="form-Control"></form:radiobutton>New
                </label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productCondition" id="condition" value="used" class="form-Control"></form:radiobutton>Used
                </label>
            </div>

            <div class="form-group">
                <label for="status">Status</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productStatus" id="status" value="active" class="form-Control"></form:radiobutton>Active
                </label>
                <label class="checkbox-inline">
                    <form:radiobutton path="productStatus" id="status" value="inactive" class="form-Control"></form:radiobutton>InActive
                </label>
            </div>

            <div class="form-group">
                <label for="unitinstock">Unit in stock</label>
                <form:input path="unitInStock" id="unitinstock" class="form-Control" value="${product.unitInStock}"></form:input>
            </div>

            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <form:input path="productManufacturer" id="manufacturer" class="form-Control" value="${product.productManufacturer}"></form:input>
            </div>

            <div class="form-group">
                <label class="control-label" for="productImage">Upload Picture</label>
                <form:input path="productImage" id="productImage" type="file" class="form:input-large"></form:input>
            </div>

            <br><br>

            <input type="submit" value="Submit" class="btn btn-default">
            <a href="<c:url value="/admin/productInventory"/> " class="btn btn-default">Cancel</a>
        </form:form>

    </div>
<%@include file="/WEB-INF/views/Template/footer.jsp"%>