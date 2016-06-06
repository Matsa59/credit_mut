<%@ include file="../../header.jsp" %>

<section class="group-new">
    <div class="image-filter first-element">
        <div class="container">
            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xs-offset-0 col-sm-offset-3 col-md-offset-4 col-lg-offset-4">
                <s:form action="create-group" method="POST">
                    <input type="text" name="group.name" placeholder="Name..." class="field">
                    <div class="field">
                        <input type="checkbox" name="group.isPublic" value="1"><label>Public access </label>
                    </div>
                    <input type="submit" value="Save" class="field submit">
                </s:form>
            </div>
        </div>
    </div>
</section>

<%@include file="../../footer.jsp"%>