<!-- 模仿天猫整站ssm 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function() {
        $("#addForm").submit(function() {
            if (!checkEmpty("name", "产品名称"))
                return false;
         	if (!checkEmpty("subTitle", "小标题"))
              	return false;
            if (!checkNumber("orignalPrice", "原价格"))
                return false;
            if (!checkNumber("promotePrice", "优惠价格"))
                return false;
            if (!checkInt("stock", "库存"))
                return false;
            return true;
        });
    });
</script>

<title>产品管理</title>

<div class="workingArea">

	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath}/admin_category_list/1">所有分类</a></li>
		<li><a href="${pageContext.request.contextPath}/admin_product_list/${c.id}/1">${c.name}</a></li>
		<li class="active">产品管理</li>
	</ol>

	<div class="listDataTableDiv">
		<table
				class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
			<tr class="success">
				<th>ID</th>
				<th>图片</th>
				<th>产品名称</th>
				<th>产品小标题</th>
				<th width="53px">原价格</th>
				<th width="80px">优惠价格</th>
				<th width="80px">库存数量</th>
				<th width="80px">图片管理</th>
				<th width="80px">设置属性</th>
				<th width="42px">编辑</th>
				<th width="42px">删除</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ps}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>
							<img width="40px" src="${pageContext.request.contextPath}/img/productSingle/${p.firstProductImage.id}.jpg">
					</td>
					<td>${p.name}</td>
					<td>${p.subTitle}</td>
					<td>${p.orignalPrice}</td>
					<td>${p.promotePrice}</td>
					<td>${p.stock}</td>
					<td><a href="${pageContext.request.contextPath}/admin_productImage_list/${p.id}"><span
							class="glyphicon glyphicon-picture"></span></a></td>
					<td><a href="${pageContext.request.contextPath}/admin_propertyValue_edit?pid=${p.id}"><span
							class="glyphicon glyphicon-th-list"></span></a></td>

					<td><a href="${pageContext.request.contextPath}/admin_product_edit?id=${p.id}&cid=${c.id}"><span
							class="glyphicon glyphicon-edit"></span></a></td>
					<td><a deleteLink="true"
						   href="${pageContext.request.contextPath}/admin_product_delete?id=${p.id}"><span
							class="     glyphicon glyphicon-trash"></span></a></td>

				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
		<%@include file="../include/admin/adminPage.jsp"%>
	</div>

	<div class="panel panel-warning addDiv">
		<div class="panel-heading">新增产品</div>
		<div class="panel-body">
			<form method="post" id="addForm" action="${pageContext.request.contextPath}/admin_product_add">
				<table class="addTable">
					<tr>
						<td>产品名称</td>
						<td><input id="name" name="name" type="text"
								   class="form-control"></td>
					</tr>
					<tr>
						<td>产品小标题</td>
						<td><input id="subTitle" name="subTitle" type="text"
								   class="form-control"></td>
					</tr>
					<tr>
						<td>原价格</td>
						<td><input id="orignalPrice" value="99.98" name="orignalPrice" type="text"
								   class="form-control"></td>
					</tr>
					<tr>
						<td>优惠价格</td>
						<td><input id="promotePrice"  value="19.98" name="promotePrice" type="text"
								   class="form-control"></td>
					</tr>
					<tr>
						<td>库存</td>
						<td><input id="stock"  value="99" name="stock" type="text"
								   class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="cid" value="${c.id}">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</div>

<%@include file="../include/admin/adminFooter.jsp"%>