<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/web/css/bootstrap.min.css" />
</head>
<body>

<h1>
<tiles:insertAttribute name="title" />
</h1>
<nav>

<tiles:insertAttribute name="navigation" />
</nav>
<div class="container mb-3">
<tiles:insertAttribute name="content" />
</div>
<script src="/web/js/jquery-3.3.1.js"></script>
	<script src="/web/js/popper.min.js"></script>
	<script src="/web/js/bootsrap.min.js"></script>
</body>
</html>
