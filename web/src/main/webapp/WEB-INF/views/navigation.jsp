<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<tiles:insertDefinition name="app.layout">
		<tiles:putAttribute name="navigation">
				<a href="/web/home" class="btn btn-primary" >Home  </a>
				<a href="/web/connexion" class="btn btn-primary" >Se connecter </a>
				
				<a href="/web/faq" class="btn btn-primary" >FAQ  </a>
				<a href="/web/tetriminos/liste" class="btn btn-primary" >Pièces  </a>
				
				<a href="/web/deconnecter"><button type="button"
						class="btn btn-success">Se déconnecter</button></a>
			
		</tiles:putAttribute>
	</tiles:insertDefinition>
