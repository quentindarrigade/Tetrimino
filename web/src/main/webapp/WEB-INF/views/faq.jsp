<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


	<tiles:insertDefinition name="app.layout">
		<tiles:putAttribute name="title" value="Te voilà sur la FAQ" />
		<tiles:putAttribute name="content">
<%-- 			<p>Bonjour ${utilisateur}</p> --%>
<%-- 			<p>Produit ID ${idProduit}</p> --%>
			<p>Bonjour</p>
		</tiles:putAttribute>
	</tiles:insertDefinition>
