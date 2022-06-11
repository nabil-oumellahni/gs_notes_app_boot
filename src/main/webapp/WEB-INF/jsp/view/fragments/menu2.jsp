<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">

        <li class="nav-item"><a class="nav-link active"
                                aria-current="page"
                                href="${pageContext.request.contextPath}/cadreadmin/showHome">Home</a></li>

        <li class="nav-item"><a class="nav-link active"
                                aria-current="page"
                                         href="${pageContext.request.contextPath}/cadreadmin/formFiliere">
            Filieres Management</a></li>

        <li class="nav-item"><a class="nav-link active"
                                aria-current="page"
                                         href="${pageContext.request.contextPath}/cadreadmin/formModule" >
            Modules Management</a></li>

        <li class="nav-item"><a class="nav-link active"
                                aria-current="page"
                                         href="${pageContext.request.contextPath}/cadreadmin/formElement">
            Element Management</a></li>

        <li class="nav-item"><a class="nav-link active"
                                aria-current="page"
                                         href="${pageContext.request.contextPath}/cadreadmin/formNiveau" >
            Niveau Management</a></li>

        <li class="nav-item"><f:form
                action="${pageContext.request.contextPath}/logout" method="POST">

            <button type="submit" class="btn btn-danger">Logout</button>

        </f:form></li>

    </ul>

</div>


