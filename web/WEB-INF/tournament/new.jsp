<%@ include file="../../header.jsp" %>

<section>
    <div class="first-element"></div>

    <s:form action="create-tournament" method="POST">
        <input type="text" name="tournament.name" placeholder="name">
        <input type="checkbox" name="tournament.isPublic" value="1"><label>Public access</label>

        <%/*<s:iterator value="groups">
            <input type="checkbox" name="groups" value="<s:property value="id"/>">

            <label><s:property value="name"/></label>
        </s:iterator>*/%>

        <s:checkboxlist list="groups" name="finalGroups.id" listKey="id" listValue="name"  />

        <%/*<input name="tournament.beginAt" format="dd/MM/yyyy"/>

        <input name="tournament.endAt" format="dd/MM/yyyy"/>*/%>

        <input type="submit" value="Save">
    </s:form>
</section>

<%@ include file="../../footer.jsp" %>
