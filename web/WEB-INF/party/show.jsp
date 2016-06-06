<%@ include file="../../header.jsp" %>

<section>
    <h2>Define response : </h2>
    <s:if test="party.usersEntity.id == user.id">
        <s:iterator value="party.choicesPartiesEntity">
            <a href="<s:url action="define-response"/>?partyId=<s:property value="party.id"/>&choice=<s:property value="id"/>">
                <s:property value="name" />
            </a><br />
        </s:iterator>
    </s:if>
</section>

<%@ include file="../../footer.jsp"%>