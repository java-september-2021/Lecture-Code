<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<p>Hi ${user.firstName} ${user.lastName}</p>
<form:form method="POST" action="/thought/newThought" modelAttribute="thought">
<form:label path="content">Post a Great Thought here!</form:label>
<form:errors path="content"/>
<form:textarea path="content"/>
<button>Add Thought</button>
</form:form>
<hr>
<a href="/thought/dashboard/high">Sort Thoughts By Likes</a>
<p></p><c:forEach items="${allThoughts}" var="thought">

<c:choose>
<c:when test="${thought.likers.contains(user)}">
<a href="/thought/unlike/${thought.id}">Unlike</a>
</c:when>
<c:otherwise>
<a href="/thought/like/${thought.id}">Like</a>
</c:otherwise>
</c:choose>


<p>${thought.author.firstName} says: ${thought.content}</p>
<p>Posted: ${thought.createdAt}</p>
<p>${thought.likers.size()} people have liked this</p>
<c:if test="${user == thought.author}">
<a href="/thought/delete/${thought.id}">Delete</a>
</c:if>
</c:forEach>


</body>
</html>