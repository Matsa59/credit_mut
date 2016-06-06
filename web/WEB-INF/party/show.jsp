<%@ include file="../../header.jsp" %>

<section>
    <div class="container">
        <div class="col-xs-4">
            <h2>Define response : </h2>
            <s:if test="party.usersEntity.id == user.id">
                <s:iterator value="party.choicesPartiesEntity">
                    <a href="<s:url action="define-response"/>?partyId=<s:property value="party.id"/>&choice=<s:property value="id"/>">
                        <s:property value="name" />
                    </a><br />
                </s:iterator>
            </s:if>
        </div>

        <div class="col-xs-8">
            <s:iterator value="party.choicesPartiesEntity">
                <s:if test="isResponse">
                    <s:iterator value="usersEntities">
                        <p style="color: green;"><s:property value="username"/></p>
                    </s:iterator>
                </s:if>
                <s:else>
                    <s:iterator value="usersEntities">
                        <p style="color: red;"><s:property value="username"/></p>
                    </s:iterator>
                </s:else>
            </s:iterator>
        </div>
    </div>
</section>

<%@ include file="../../footer.jsp"%>