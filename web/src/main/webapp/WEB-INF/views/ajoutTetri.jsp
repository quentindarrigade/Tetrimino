<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<tiles:insertDefinition name="app.layout">
		<tiles:putAttribute name="title" value="Veuillez ajouter un nouveau Tetrimino:" />
		<tiles:putAttribute name="content">

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
				  <input type="text" class="form-control" name="couleur" value="${tetrimino.couleur }" aria-describedby="basic-addon1">
				</div>
			</div>
			</div>
			
			
		<div class="row">
			<div class="col-sm">
		<span class="input-group-text" id="basic-addon1">Forme</span>
		</div>
		</div>
		
		<div class="row">
			<div class="col-sm">
			<div class="input-group mb-3">
				  				  <input type="checkbox" style="height:20px;width:20px;display:none" id=1/> <label for=1 class="check"></label>
				  				  <input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/>

				</div>
				<div class="input-group mb-3">
				 				  <input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/>

				    
				  </div>
				  <div class="input-group mb-3">
				 				  <input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/>

				  </div>
				  <div class="input-group mb-3">
				  <input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/><input type="checkbox" style="height:20px;width:20px"/>
				    
				  </div>
				  </div>
				  </div>
				  
				  
		
		<div class="row">
			<div class="col-sm">	
		<div class="submit mb-3"><input type="submit" value="Ajouter" onclick="ajouter();return false;"/></div>
		</div>
		</div>
		
		
		
	</form>

</div>


</tiles:putAttribute>
	</tiles:insertDefinition>