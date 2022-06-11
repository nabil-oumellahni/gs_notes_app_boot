<%@page import="com.gsnotes.web.models.ElementModel"%>
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
        <h3>Ajouter un Element</h3>
    </div>
    <div>
        <f:form action="addElement" method="POST" modelAttribute="elementModel">
            <div class="row">
                <div class="col">
                    <label>Titre </label>
                    <f:input path="nom" type="text" class="form-control"
                             placeholder="nom" />
                    <f:errors path="nom" class="text-danger" />
                </div>
                <div class="col">
                    <label>Code </label>
                    <f:input path="code" type="text" class="form-control"
                             placeholder="code Module" />
                    <f:errors path="code" class="text-danger" />
                </div>
                <div class="col">
                    <label>Cofficient </label>
                    <f:input path="currentCoefficient" type="text" class="form-control"
                             placeholder="current Coefficient" />
                    <f:errors path="currentCoefficient" class="text-danger" />
                </div>
                <div class="col">
                    <label>select le Module</label>
                    <f:select path="module" multiple="false" size="1"
                              class="form-control">
                        <f:options items="${moduleList}" itemValue="idModule" itemLabel="titre" />
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

<div>

    <div class="container">
        <div>
            <h3>Liste des Elements</h3>
        </div>
    <table class="table table-success" style="font-family: 'Comic Sans MS'">
        <thead>
        <tr>
            <th scope="col">Nom Element</th>
            <th scope="col">Code Element</th>
            <th scope="col">Cofficient Element</th>
            <th scope="col">Module</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <c:forEach items="${elementList}" var="e">
            <tr>
                <td><c:out value="${e.nom}" /></td>
                <td><c:out value="${e.code}" /></td>
                <td><c:out value="${e.currentCoefficient}" /></td>
                <td><c:out value="${e.module.titre}" /></td>
                <td>
                    <ul>
                        <li><a
                                href="${pageContext.request.contextPath}/cadreadmin/deleteElement/${e.idMatiere}">
                            <span class="badge bg-warning">Delete</span></a></li>

                        <li><a
                                href="${pageContext.request.contextPath}/cadreadmin/updateElementForm/${e.idMatiere}/">
                            <span class="badge bg-success">Update</span></a></li>
                    </ul>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
</div>

