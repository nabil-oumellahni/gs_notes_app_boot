<%@page import="com.gsnotes.web.models.FiliereModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
        <h3>Ajouter une Filiere</h3>
    </div>
<div>
 <f:form action="addFiliere" method="POST" modelAttribute="filiereModel" >

        <div class="row">
            <div class="col">
                <label>Titre de Filiere</label>
                <f:input path="titreFiliere" type="text" class="form-control"
                         placeholder="titreFiliere" />
                <f:errors path="titreFiliere" class="text-danger" />
            </div>
                <div class="col">
                    <label>Code de Filiere</label>
                    <f:input path="codeFiliere" type="text" class="form-control"
                             placeholder="codeFiliere" />
                    <f:errors path="codeFiliere" class="text-danger" />
                </div>
        </div>
                <div class="row">
                    <div class="col">
                        <label>Annee d'anneeaccreditation de Filiere</label>
                        <f:input path="anneeaccreditation" type="number" class="form-control"
                                 placeholder="anneeaccreditation" />
                        <f:errors path="anneeaccreditation" class="text-danger" />
                    </div>
                    <div class="col">
                            <label>Annee de fin d'anneeaccreditation de Filiere</label>
                            <f:input path="anneeFinaccreditation" type="number" class="form-control"
                                     placeholder="anneeFinaccreditation" />
                            <f:errors path="anneeFinaccreditation" class="text-danger" />
                        </div>
                    <div class="col">
                        <label>Associer cette filiere a un cordinateur</label>

                        <f:select path="enseignant" multiple="false" size="1"
                                  class="form-control">
                            <f:options items="${enseignantList}" itemValue="idUtilisateur" itemLabel="nom" />
                        </f:select>
                </div>
                    <br>
                    <br>
            <div style="text-align: right">
                <button type="submit" class="btn btn-primary btn-sm">Enregistrer</button>
                <button type="reset" class="btn btn-secondary btn-sm">Annuler</button>
            </div>
            </f:form>
        </div>

        </div>
</div>

<div class="container">

    <div>
        <h3>Liste des Filieres</h3>
    </div>

    <table class="table table-success" style="font-family: 'Comic Sans MS'">
        <thead>
        <tr>
            <th scope="col">Titre </th>
            <th scope="col">Code</th>
            <th scope="col">Année d'accrédation</th>
            <th scope="col">Année de Fin d'accreditation</th>
            <th scope="col">Cordinateur du filiere</th>
            <th>Actions</th>
        </tr>
        </thead>

        <c:forEach items="${filiereList}" var="variable">
            <tr>

                <td><c:out value="${variable.titreFiliere}" /></td>
                <td><c:out value="${variable.codeFiliere}" /></td>
                <td><c:out value="${variable.anneeaccreditation}" /></td>
                <td><c:out value="${variable.anneeFinaccreditation}" /></td>
                <td><c:out value="${variable.enseignant.nom}" /></td>


                <td>
                    <ul>
                        <li><a  href="${pageContext.request.contextPath}/cadreadmin/deleteFiliere/${variable.idFiliere}">
                        <span class="badge bg-warning">Delete</span> </a>
                        </li>
                        <li><a  href="${pageContext.request.contextPath}/cadreadmin/updateFiliereForm/${variable.idFiliere}">
                            <span class="badge bg-success">Update</span></a>
                        </li>
                    </ul>
                </td>
            </tr>

        </c:forEach>

    </table>
</div>
</html>
