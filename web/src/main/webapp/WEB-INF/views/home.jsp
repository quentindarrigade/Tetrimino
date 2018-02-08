<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Bienvenue bande de gland" />
	<tiles:putAttribute name="content">
		<%-- 			<p>Bonjour ${utilisateur}</p> --%>
		<%-- 			<p>Produit ID ${idProduit}</p> --%>
		<div class="input-group mb-3">
			<p>Bonjour</p>
			<p>${admin.login}</p>
		</div>
		<div>Bienvenue sur Tetris SCEP 2018</div>
		<div>
			<p>Un jeu qu'il est bien</p>
		</div>


	</tiles:putAttribute>
</tiles:insertDefinition>



