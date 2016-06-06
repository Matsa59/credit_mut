<%@include file="../../header.jsp" %>

<section>
    <div class="container">
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xs-offset-0 col-sm-offset-3 col-md-offset-4 col-lg-offset-4">
            <s:property value="errorMessage" />
            <%@include file="forms/login_form.jsp"%>
        </div>
    </div>
</section>

<%@include file="../../footer.jsp" %>