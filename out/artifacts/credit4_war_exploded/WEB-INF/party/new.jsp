<%@ include file="../../header.jsp" %>

<section>
    <div class="first-element"></div>

    <s:form action="create-party" method="POST">
        <input type="checkbox" name="party.isPublic" value="1"><label>Public access </label>
        <input type="text" name="party.name">

        <select name="tournamentId">
            <option value="-1">None</option>
            <s:iterator value="tournaments">
                <option value="<s:property value="id"/>" selected><s:property value="name"/></option>
            </s:iterator>
        </select>

        <input type="text" name="choice" placeholder="Choice 1">
        <input type="text" name="choice" placeholder="Choice 2">

        <input type="submit" value="Save new party">
    </s:form>
</section>

<%@ include file="../../footer.jsp" %>