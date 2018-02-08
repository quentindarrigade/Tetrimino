<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>



<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Te voilà sur la FAQ" />
	<tiles:putAttribute name="content">
		<%-- 			<p>Bonjour ${utilisateur}</p> --%>

		<p>Faq</p>

		<c:if test="${ admin.login != null}">
			<div>
				<a href="/web/ajouter"><button type="button"
						class="btn btn-success">Ajouter</button></a>
			</div>
		</c:if>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>Questions pour les nuls</th>
					<th>Réponses des génies de la SCEP</th>
					<c:if test="${ admin.login != null}">
						<th>Actions</th>
					</c:if>

				</tr>
			</thead>
			<c:forEach items="${faqAttribute}" var="faq">
				<tr>
					<td>${faq.questions }</td>
					<td>${faq.reponses }</td>
					<c:if test="${ admin.login != null}">
						<td><a href="/web/editer?id=${faq.id }"><button
									type="button" class="btn btn-outline-primary">modifier</button></a>
							<a href="/web/supprimer?id=${faq.id }"><button type="button"
									class="btn btn-danger">X</button></a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>

	</tiles:putAttribute>
</tiles:insertDefinition>
