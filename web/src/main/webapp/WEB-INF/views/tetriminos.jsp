<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="app.layout">
		<tiles:putAttribute name="title" value="Liste des tetriminos" />
		<tiles:putAttribute name="content">

	<div class="container">
	
		<div class="row">
		<table class="table table-bordered">
		<thead class="thead-dark">
			<th>ID</th>
			<th>Nom</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${tetriminos}" var="tetrimino">
				
				<tr>
				
					<td>
						${tetrimino.id } 
						
					</td>
					
					<td>
						${tetrimino.nom } 
						
					</td>
					
					<td>
					
						<a href="editer?idTetrimino=${tetrimino.id}" class="btn btn-secondary" >Editer Tetrimino </a>
						<a href="supprimer?idTetrimino=${tetrimino.id}" class="btn btn-danger" >Supprimer Tetrimino </a>
					
					</td>
					
					
				
				</tr>
				
			</c:forEach>
			</tbody>
			
				
				
		</table>
		</div>
		<div class="row">
		<div class="col-">
		<a href="ajouter" class="btn btn-primary" >Ajouter Tetrimino </a>
		</div>
		</div>
		
		
		
	</div>
	

</tiles:putAttribute>
	</tiles:insertDefinition>