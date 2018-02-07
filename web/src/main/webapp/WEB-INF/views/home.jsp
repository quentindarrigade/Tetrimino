<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


	<tiles:insertDefinition name="app.layout">
		<tiles:putAttribute name="title" value="Bienvenue bande de gland" />
		<tiles:putAttribute name="content">
<%-- 			<p>Bonjour ${utilisateur}</p> --%>
<%-- 			<p>Produit ID ${idProduit}</p> --%>
			<p>Bonjour</p>
			<p>Produit</p>
		</tiles:putAttribute>
	</tiles:insertDefinition>



