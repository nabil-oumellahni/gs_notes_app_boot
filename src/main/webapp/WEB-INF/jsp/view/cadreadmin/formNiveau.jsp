<%@page import="com.gsnotes.web.models.FiliereModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/adminHeader.jsp" />

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <jsp:include page="../fragments/menu2.jsp" />
        </div>
    </nav>

    <div>
        <h3>Ajouter un Niveau</h3>
    </div>
    <div>
        <f:form action="addNiveau" method="POST" modelAttribute="niveauModel" >
            <div class="row">
                <div class="col">
                    <label>Titre </label>
                    <f:input path="titre" type="text" class="form-control"
                             placeholder="Titre" />
                    <f:errors path="titre" class="text-danger" />
                </div>
                <div class="col">
                    <label>Alias </label>
                    <f:input path="alias" type="text" class="form-control"
                             placeholder="Alias" />
                    <f:errors path="alias" class="text-danger" />
                </div>
                <div class="col">
                    <label>Associer niveau a une filiere</label>

                    <f:select path="filiere" multiple="false" size="1"
                              class="form-control">
                        <f:options items="${filiereList}" itemValue="idFiliere" itemLabel="titreFiliere" />
                    </f:select>


                </div>
            </div>
            <div style="text-align: right">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <button type="reset" class="btn btn-secondary">Annuler</button>
            </div>
        </f:form>
    </div>
</div>


<div class="container">
    <div>
        <h3>Liste des Niveaux</h3>
    </div>
    <table class="table table-success" style="font-family: 'Comic Sans MS'">
        <thead>
        <tr>
            <th scope="col">Titre </th>
            <th scope="col">Alias </th>
            <th scope="col">Filiere de Niveau</th>
            <th>Actions</th>
        </tr>
        </thead>

        <c:forEach items="${niveauList}" var="elm">
            <tr>
                <td><c:out value="${elm.titre}" /></td>
                <td><c:out value="${elm.alias}" /></td>
                <td><c:out value="${elm.filiere.titreFiliere}" /></td>
                <td>

                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/cadreadmin/deleteNiveau/${elm.idNiveau}">
                                <span class="badge bg-warning">Delete</span>
                            </a>
                        </li>
                        <li>
                             <a href="${pageContext.request.contextPath}/cadreadmin/updateNiveauForm/${elm.idNiveau}/">
                                 <span class="badge bg-success">Update
                                 </span>
                             </a>
                        </li>
                    </ul>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>