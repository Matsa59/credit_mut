<%@ include file="../../header.jsp" %>
<section>
    <div class="first-element"></div>

    <div class="container">
        <s:iterator value="parties">
            <div class="col-lg-4">
                <div class="party">
                    <s:if test="%{tournamentsEntity == null}">
                        <h3>By "<s:property value="usersEntity.username"/>"</h3>
                    </s:if>
                    <s:else>
                        <h3>Tournament : <s:property value="tournamentsEntity.name"/></h3>
                    </s:else>
                    <hr>
                    <p><s:property value="name"/></p>
                </div>
            </div>
        </s:iterator>
    </div>
</section>

<%@ include file="../../footer.jsp"%>