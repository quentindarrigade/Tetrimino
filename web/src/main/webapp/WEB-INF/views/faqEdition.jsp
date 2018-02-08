<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Ajout d'une question/réponse" />
	<tiles:putAttribute name="content">
	
 		<form:form method="POST" modelAttribute="faqAttribute">
		
			<div class="form-group">
				<form:label path="questions">Questions :</form:label>
				<form:input path="questions" type="text" class="form-control"
					name="questions" aria-describedby="Help" placeholder="Questions"
					value="${faq.questions}" />
				<form:errors path="questions" element="div"
					cssClass="alert alert-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="reponses">Reponses :</form:label>
				<form:input path="reponses" type="text" class="form-control"
					name="reponses" aria-describedby="Help" placeholder="Reponses"
					value="${faq.reponses}" />
				<form:errors path="reponses" element="div"
					cssClass="alert alert-danger" />
			</div>


			<button type="submit" class="btn btn-danger">Ajouter</button>

<img src="C:\Users\ajc\Desktop\Tetris\Tetrimino\mvc\src\main\webapp\WEB-INF\leaderboard.jpeg" style="text-align: right" class="homme"/>

		</form:form> 
	</tiles:putAttribute>
</tiles:insertDefinition> 