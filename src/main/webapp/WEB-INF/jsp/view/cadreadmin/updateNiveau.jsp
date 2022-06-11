<%@page import="com.gsnotes.web.models.NiveauModel"%>
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
        <h3>Formulaire de modification d'un niveau</h3>
    </div>
    <c:if test="${not empty msg}">
        <div class="alert alert-success" role="alert">${msg}</div>
    </c:if>

    <div>
        <f:form action="${pageContext.request.contextPath}/cadreadmin/updateNiveau" method="POST" modelAttribute="niveauModel" >
            <f:input path="idNiveau" type="hidden" class="form-control" value="${niveauModel.idNiveau}"/>
            <div class="row">
                <div class="col">
                    <label>Titre de niveau</label>
                    <f:input path="titre" type="text" class="form-control"
                             placeholder="titre" value="${niveauModel.titre}"/>
                    <f:errors path="titre" class="text-danger" />
                </div>
                <div class="col">
                    <label>Alias de niveau</label>
                    <f:input path="alias" type="text" class="form-control"
                             placeholder="code" value="${niveauModel.alias}"/>
                    <f:errors path="alias" class="text-danger" />
                </div>
                <div class="col">
                    <label>Please selectionner le niveau</label>

                    <f:select path="filiere" multiple="false" size="1"
                              class="form-control">
                        <f:options items="${filiereList}" itemValue="idFiliere" itemLabel="titreFiliere" />
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

