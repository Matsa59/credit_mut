<%@ include file="../../header.jsp" %>

<section>
    <div class="container">
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xs-offset-0 col-sm-offset-3 col-md-offset-4 col-lg-offset-4">
        <s:form action="create-party" method="POST">
            <input type="text" name="party.name" class="field" placeholder="Name...">

            <div class="field">
                <input type="checkbox" name="party.isPublic" value="1">
                <label style="color: white;">Public access </label><br />
            </div>

            <div class="field">
                <label>tournament : </label>
                <select name="tournamentId">
                    <option value="-1">None</option>
                    <s:iterator value="tournaments">
                        <option value="<s:property value="id"/>" selected><s:property value="name"/></option>
                    </s:iterator>
                </select>
            </div>

            <div class="choices">
                <input type="text" name="choice" placeholder="Choice 1" class="field">
                <input type="text" name="choice" placeholder="Choice 2" class="field">
            </div>

            <button type="button" class="field" onclick="addChoice(); return false;">Add choice</button>

            <input type="submit" value="Save new party" class="field submit">
        </s:form>
        </div>
    </div>
</section>


<%@ include file="../../footer.jsp" %>