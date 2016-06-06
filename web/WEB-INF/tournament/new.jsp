<%@ include file="../../header.jsp" %>

<section class="tournament-new">
    <div class="image-filter first-element">
        <div class="container">
            <s:form action="create-tournament" method="POST">
                <div class="col-xs-12 col-md-6">
                    <h2>Basic informations</h2>
                    <hr>
                    <input type="text" name="tournament.name" placeholder="name" class="field"><br />
                    <input type="checkbox" name="tournament.isPublic" value="1" class="list"><label>Public access</label>
                </div>
                <%/*<s:iterator value="groups">
                    <input type="checkbox" name="groups" value="<s:property value="id"/>">

                    <label><s:property value="name"/></label>
                </s:iterator>*/%>

                <div class="col-xs-12 col-md-6">
                    <h2>Groups : </h2>
                    <hr>
                    <s:checkboxlist list="groups" name="finalGroups.id" listKey="id" listValue="name" class="list"/>
                </div>

                <%/*<input name="tournament.beginAt" format="dd/MM/yyyy"/>

                <input name="tournament.endAt" format="dd/MM/yyyy"/>*/%>

                <div class="col-xs-12">
                    <hr>
                </div>
                <div class="col-xs-offset-10 col-xs-2">
                    <input type="submit" value="Save" class="btn btn-primary">
                </div>
            </s:form>
        </div>
    </div>
</section>

<%@ include file="../../footer.jsp" %>
