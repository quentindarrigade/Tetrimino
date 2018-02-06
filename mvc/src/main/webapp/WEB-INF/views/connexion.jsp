<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="app.layout">
	<tiles:putAttribute name="title" value="Connexion à la SCEP" />
	<tiles:putAttribute name="content">
	<p>Rentrez vos informations de connexion</p>
		<form:form method="POST" modelAttribute="login">
			<div class="form-group">
				<form:label path="libelle">Libellé :</form:label>
				<form:input path="libelle" type="text" class="form-control"
					name="libelle" aria-describedby="Help" placeholder="Libellé"
					value="${produit.libelle}" />
				<form:errors path="libelle" element="div"
					cssClass="alert alert-danger" />

			</div>
			<div class="form-group">
				<form:label path="prix">Prix :</form:label>
				<form:input path="prix" type="number" class="form-control"
					name="prix" id="exampleInputPassword1" placeholder="Prix"
					value="${produit.prix }" />
				<form:errors path="prix" element="div" cssClass="alert alert-danger" />
			</div>

			<div class="form-group row">
				<label for="prix" class="col-sm-2 col-form-label">Fournisseur
					:</label>
				<div class="col-sm-10>">
					<form:select path="fournisseur.id" items="${fournisseurs}"
						itemLabel="societe" itemValue="id" cssClass="form-control" />
				</div>
			</div>

			<button type="submit" class="btn btn-danger">Ajouter</button>



		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>