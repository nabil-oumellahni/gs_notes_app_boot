<%@page import="com.gsnotes.web.models.ModuleModel"%>
<%@page import="com.gsnotes.web.models.EnseignantModel"%>
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
        <h3>Formulaire de modification d'un module</h3>
    </div>
    <c:if test="${not empty msg}">
        <div class="alert alert-success" role="alert">${msg}</div>
    </c:if>

    <div>
        <f:form action="${pageContext.request.contextPath}/cadreadmin/updateModule" method="POST" modelAttribute="moduleModel" >
            <f:input path="idModule" type="hidden" class="form-control" value="${moduleModel.idModule}"/>
            <div class="row">
                <div class="col">
                    <label>Titre de module</label>
                    <f:input path="titre" type="text" class="form-control"
                             placeholder="titre" value="${moduleModel.titre}"/>
                    <f:errors path="titre" class="text-danger" />
                </div>
                <div class="col">
                    <label>Code de module</label>
                    <f:input path="code" type="text" class="form-control"
                             placeholder="code" value="${moduleModel.code}"/>
                    <f:errors path="code" class="text-danger" />
                </div>
                <div class="col">
                    <label>select Niveau</label>

                    <f:select path="niveau" multiple="false" size="1"
                              class="form-control">
                        <f:options items="${niveauList}" itemValue="idNiveau" itemLabel="titre" />
                    </f:select>
                    <div class="col">
                        <label> select prof</label>
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
</div>
</html>
