<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


	<tiles:insertDefinition name="app.layout">
		<tiles:putAttribute name="title" value="" />
		<tiles:putAttribute name="content">
<div class="container">


<form method="get" action="ajouter" >
		<div class="row">
			<div class="col-sm">
			<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="basic-addon1">Taille voulue:</span>
				  </div>
				  <input type="text" class="form-control" name="taille"  aria-describedby="basic-addon1">
				</div>
		</div>
		</div>
		
			
			
			
		<div class="submit mb-3"><input type="submit" value="Valider" onclick="ajouter();return false;"/></div>
		
	
		
	</form>

</div>
		</tiles:putAttribute>
	</tiles:insertDefinition>