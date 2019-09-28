<!-- 模仿天猫整站ssm 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function(){
        $(".addFormSingle").submit(function(){
            if(checkEmpty("filepathSingle","图片文件")){
                $("#filepathSingle").value("");
                return true;
            }
            return false;
        });
        $(".addFormDetail").submit(function(){
            if(checkEmpty("filepathDetail","图片文件"))
                return true;
            return false;
        });
    });

</script>

<title>产品图片管理</title>


<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath}/admin_category_list/1">所有分类</a></li>
		<li><a href="${pageContext.request.contextPath}/admin_product_list/${p.category.id}/1">${p.category.name}</a></li>
		<li class="active">${p.name}</li>
		<li class="active">产品图片管理</li>
	</ol>

	<table class="addPictureTable" align="center">
		<tr>
			<td class="addPictureTableTD">
				<div>
					<div class="panel panel-warning addPictureDiv">
						<div class="panel-heading">新增产品<b class="text-primary"> 单个 </b>图片</div>
						<div class="panel-body">
							<form method="post" class="addFormSingle" action="${pageContext.request.contextPath}/admin_productImage_add" enctype="multipart/form-data">
								<table class="addTable">
									<tr>
										<td>请选择本地图片 尺寸400X400 为佳</td>
									</tr>
									<tr>
										<td>
											<input id="filepathSingle" type="file" name="image" />
										</td>
									</tr>
									<tr class="submitTR">
										<td align="center">
											<input type="hidden" name="type" value="type_single" />
											<input type="hidden" name="pid" value="${p.id}" />
											<button type="submit" class="btn btn-success">提 交</button>
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
					<table class="table table-striped table-bordered table-hover  table-condensed">
						<thead>
						<tr class="success">
							<th>ID</th>
							<th>产品单个图片缩略图</th>
							<th>删除</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${p.productSingleImages}" var="ps">
							<tr>
								<td>${ps.id}</td>
								<td>
									<a title="点击查看原图" href="${pageContext.request.contextPath}/img/productSingle/${ps.id}.jpg"><img height="50px" src="${pageContext.request.contextPath}/img/productSingle/${ps.id}.jpg"></a>
								</td>
								<td><a deleteLink="true"
									   href="${pageContext.request.contextPath}/admin_productImage_delete?id=${ps.id}"><span
										class=" 	glyphicon glyphicon-trash"></span></a></td>

							</tr>
						</c:forEach>
						</tbody>
					</table>

				</div>
			</td>
			<td class="addPictureTableTD">
				<div>

					<div class="panel panel-warning addPictureDiv">
						<div class="panel-heading">新增产品<b class="text-primary"> 详情 </b>图片</div>
						<div class="panel-body">
							<form method="post" class="addFormDetail" action="${pageContext.request.contextPath}/admin_productImage_add" enctype="multipart/form-data">
								<table class="addTable">
									<tr>
										<td>请选择本地图片 宽度790  为佳</td>
									</tr>
									<tr>
										<td>
											<input id="filepathDetail"  type="file" name="image" />
										</td>
									</tr>
									<tr class="submitTR">
										<td align="center">
											<input type="hidden" name="type" value="type_detail" />
											<input type="hidden" name="pid" value="${p.id}" />
											<button type="submit" class="btn btn-success">提 交</button>
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
					<table class="table table-striped table-bordered table-hover  table-condensed">
						<thead>
						<tr class="success">
							<th>ID</th>
							<th>产品详情图片缩略图</th>
							<th>删除</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${p.productDetailImages}" var="pd">
							<tr>
								<td>${pd.id}</td>
								<td>
									<a title="点击查看原图" href="${pageContext.request.contextPath}/img/productDetail/${pd.id}.jpg"><img height="50px" src="${pageContext.request.contextPath}/img/productDetail/${pd.id}.jpg"></a>
								</td>
								<td><a deleteLink="true"
									   href="${pageContext.request.contextPath}/admin_productImage_delete?id=${pd.id}"><span
										class=" 	glyphicon glyphicon-trash"></span></a></td>

							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</td>
		</tr>
	</table>





</div>

<%@include file="../include/admin/adminFooter.jsp"%>
