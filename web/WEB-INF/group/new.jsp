<%@ include file="../../header.jsp" %>

<section>
    <div class="container">
        <s:form action="create-group" method="POST">
            <input type="text" name="group.name" placeholder="Name...">
            <input type="checkbox" name="group.isPublic" value="1"><label>Public access </label>

            <input type="submit" value="Save" class="field submit">
        </s:form>
    </div>
</section>

<%@include file="../../footer.jsp"%>