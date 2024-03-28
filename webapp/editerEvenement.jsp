<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Evenements</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Modification des Evenements
</div>
<div class="card-body">
<form action="update.do" method="post">
<div class="form-group">
<div hidden class="form-group" >
 <label class="control-label">ID Evenement :</label>
 <input type="text" name="id" class="form-control" value="${evenement.idEvenement}"/>
</div>
</div>
<div class="form-group">
<label class="control-label">Nom Produit :</label>
<input type="text" name="nom" class="form-control"
value="${evenement.nomEvenement}"/>
</div>
<div class="form-group">
<label class="control-label">Date Evenement :</label>
<input type="date" name="date" class="form-control" value="${evenement.getDateEvenement()}"/>
</div>
<div class="form-group"> 
 <select name="type" class="form-control">
 <option value="${evenement.type.idType}"
selected>${evenement.type.nomType}</option>
 <c:forEach items="${typeModel.types}" var="ty"> 
 <c:if test="${ty.idType != evenement.type.idType}"> 
 <option value="${ty.idType}">${ty.nomType}</option>
 </c:if>
 </c:forEach>
 </select>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form> 
</div>
</div>
</div>
</body>
</html>