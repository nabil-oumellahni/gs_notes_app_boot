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
        <h3>Modifier une Filiere</h3>
    </div>
    <c:if test="${not empty msg}">
        <div class="alert alert-success" role="alert">${msg}</div>
    </c:if>

    <div>
        <f:form action="${pageContext.request.contextPath}/cadreadmin/updateFiliere" method="POST" modelAttribute="filiereModel" >
            <f:input path="idFiliere" type="hidden" class="form-control" value="${filiereModel.idFiliere}"/>
            <div class="row">
                <div class="col">
                    <label>Titre </label>
                    <f:input path="titreFiliere" type="text" class="form-control"
                             placeholder="titreFiliere" value="${filiereModel.titreFiliere}"/>
                    <f:errors path="titreFiliere" class="text-danger" />
                </div>
                <div class="col">
                    <label>Code </label>
                    <f:input path="codeFiliere" type="text" class="form-control"
                             placeholder="codeFiliere" value="${filiereModel.codeFiliere}"/>
                    <f:errors path="codeFiliere" class="text-danger" />
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label>Annee d'anneeaccreditation </label>
                    <f:input path="anneeaccreditation" type="number" class="form-control"
                             placeholder="anneeaccreditation" value="${filiereModel.anneeaccreditation}"/>
                    <f:errors path="anneeaccreditation" class="text-danger" />
                </div>
                <div class="col">
                    <label>Annee de fin d'anneeaccreditation </label>
                    <f:input path="anneeFinaccreditation" type="number" class="form-control"
                             placeholder="anneeFinaccreditation" value="${filiereModel.anneeFinaccreditation}"/>
                    <f:errors path="anneeFinaccreditation" class="text-danger" />
                </div>
                <div class="col">
                    <label>Select le coordinateur</label>

                    <f:select path="enseignant" multiple="false" size="1"
                              class="form-control">
                        <f:options items="${enseignantList}" itemValue="idUtilisateur" itemLabel="nom" />
                    </f:select>
                </div>
            </div>
            <div style="text-align: right">
                <button type="submit" class="btn btn-primary">Modifier</button>
                <button type="reset" class="btn btn-secondary">Annuler</button>
            </div>
        </f:form>
    </div>
</div>
</html>
