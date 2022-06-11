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
        <h3>Modifier un Element</h3>
    </div>
    <c:if test="${not empty msg}">
        <div class="alert alert-success" role="alert">${msg}</div>
    </c:if>

    <div>
        <f:form action="${pageContext.request.contextPath}/cadreadmin/updateElement" method="POST" modelAttribute="elementModel" >
            <f:input path="idMatiere" type="hidden" class="form-control" value="${elementModel.idMatiere}"/>
            <div class="row">
                <div class="col">
                    <label>Nom</label>
                    <f:input path="nom" type="text" class="form-control"
                             placeholder="titre" value="${elementModel.nom}"/>
                    <f:errors path="nom" class="text-danger" />
                </div>
                <div class="col">
                    <label>Code</label>
                    <f:input path="code" type="text" class="form-control"
                             placeholder="code" value="${elementModel.code}"/>
                    <f:errors path="code" class="text-danger" />
                </div>
                <div class="col">
                    <label>Cofficient </label>
                    <f:input path="currentCoefficient" type="text" class="form-control"
                             placeholder="cofficient" value="${elementModel.currentCoefficient}"/>
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
                <button type="submit" class="btn btn-primary">Modifier</button>
                <button type="reset" class="btn btn-secondary">Annuler</button>
            </div>
        </f:form>
    </div>
</div>


