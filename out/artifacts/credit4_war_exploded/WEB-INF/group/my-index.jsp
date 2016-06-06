<%@ include file="../../header.jsp" %>

<section>
    <div class="container">
        <div class="col-xs-4 col-md-3">
            <h2>Groups list :</h2>
            <hr>
            <ul>
                <s:iterator value="groups">
                    <li>
                        <a href="<s:url value="my-groups.action"/>?groupId=<s:property value="id"/>">
                            <s:property value="name"/>
                        </a>
                    </li>
                </s:iterator>
            </ul>
        </div>

        <%@ include file="content/index.jsp" %>
    </div>
</section>

<%@ include file="../../footer.jsp" %>