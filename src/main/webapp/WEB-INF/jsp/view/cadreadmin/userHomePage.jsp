<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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





<div class="text-center" style="margin-top: 50px">
	<div class="border border-top" style="font-family: 'Comic Sans MS'">
		<h3>Cadre Admin home page</h3>
		<p>Hello and welcome to your application</p>

		<s:authorize access="isAuthenticated()">
    			You are connected with: 
    			 <s:authentication property="principal.username" /> <br>
			Your Email : <s:authentication property="principal.email" /><br>
			Your First Name : <s:authentication property="principal.firstName" /><br>
			Your Last name : <s:authentication property="principal.LastName" /><br><br>
		</s:authorize>
	</div>
</div>

<jsp:include page="../fragments/userfooter.jsp" />

