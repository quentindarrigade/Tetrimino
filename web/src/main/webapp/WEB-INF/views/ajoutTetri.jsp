<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<tiles:insertDefinition name="app.layout">
		<tiles:putAttribute name="title" value="Veuillez ajouter/modifier un Tetrimino:" />
		<tiles:putAttribute name="content">
<link rel="stylesheet" href="/web/css/checkbox.css" />
<div class="container">


<form method="POST" >

<div class="row">
			<div class="col-sm">
			<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="basic-addon1">Nom</span>
				  </div>
				  <input type="text" class="form-control" name="nom" value="${tetrimino.nom}" aria-describedby="basic-addon1">
				</div>
		</div>
		</div>
		<div class="row">
			<div class="col-sm">
			<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="basic-addon1">Couleur</span>
				    </div>
			<select name="couleur">
				  
				  
				 <c:forEach var="i" begin="1" end="5" step="1">
				   <option >Poule Carree</option>
				   </c:forEach>
				   </select>
				   </div>
			</div>
			</div>
			
			
		<div class="row">
			<div class="col-sm" style="margin-bottom:30px">
		<span class="input-group-text" id="basic-addon1">Forme ${max}</span>
		</div>
		</div>
		
		<input type="hidden" value="${max}" name="max"/>
		
		<table>
		<tbody>
			<c:forEach var="y" begin="0" end="${max-1}" step="1">
				<tr>
				<c:forEach var="x" begin="0" end="${max-1}" step="1">
				
				
					<td>
					
					<input type="checkbox" <c:if test="${forme[y][x] == 1}" >checked</c:if> name="box-${x}-${y}" style="height:20px;width:20px;display:none" id="i-${x}-${y}"/> <label for="i-${x}-${y}" class="check"></label>
					
						
					</td>
					
					
					
					</c:forEach>
					
					
				
				</tr>
				
			</c:forEach>
			</tbody>
			
				
				
		</table>
		
		
				  
				  
		
		<div class="row">
			<div class="col-sm">	
		<div class="submit mb-3"><input type="submit" value="Ajouter" onclick="ajouter();return false;" style="margin-top:20px"/></div>
		</div>
		</div>
		
		
		
	</form>

</div>


</tiles:putAttribute>
	</tiles:insertDefinition>