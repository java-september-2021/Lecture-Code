<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Welcome To Records dot Com</title>
</head>
<body>
<div class="container">
<h3>Hi ${user.firstName}</h3>
<h1>Welcome To Records dot Com</h1>
<hr>
<a href="/new">Add An Album</a> | <a href="/song/new">Add A New Song</a>
<table class="table table-striped table-dark">
<thead>
<tr>
<th>Number Of Likes</th>
<th>Album Name</th>
<th>Band Name</th>
<th>Year</th>
<th>Action
</tr>
<c:forEach items="${allAlbums}" var="album">
<tr>
<td>${album.likers.size()}</td>
<td><a href="/details/${album.id}">${album.albumName}</a></td>
<td>${album.bandName}</td>
<td>${album.year}</td>
<td>
<c:choose>
<c:when test="${album.likers.contains(user)}">
<a href="/unlike/${album.id}">Unlike</a>
</c:when>
<c:otherwise>
<a href="/like/${album.id}">Like</a>
</c:otherwise>
</c:choose>






</td>
</tr>
</c:forEach>


</thead>

</table>

</div>
</body>
</html>