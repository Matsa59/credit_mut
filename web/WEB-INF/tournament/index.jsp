<%@ include file="../../header.jsp" %>

<section>
    <div class="container">
        <div class="col-xs-12">
            <h2>Public tournament :</h2>
        </div>
        <s:iterator value="tournaments">
            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
                <div class="tournament">
                    <h3><s:property value="name"/></h3>
                    <hr>
                    <div class="content">
                        <s:if test="groupsEntities.size() != 0" >
                            Groups :
                            <ul>
                                <s:iterator value="groupsEntities">
                                    <li><s:property value="name"/></li>
                                </s:iterator>
                            </ul>
                        </s:if>

                        <div class="view-more">
                            <a href="<s:url action="show-tournament"/>?id=<s:property value="id"/>">View more</a>
                        </div>
                    </div>
                </div>
            </div>
        </s:iterator>

        <s:if test="groupsTournaments != null">
            <div class="col-xs-12">
                <h2>Group tournament :</h2>
            </div>

            <s:iterator value="groupsTournaments">
                <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
                    <div class="tournament">
                        <h3><s:property value="name"/></h3>
                        <hr>
                        <div class="content">
                            <div class="view-more">
                                <a href="<s:url action="show-tournament"/>?id=<s:property value="id"/>">View more</a>
                            </div>
                        </div>
                    </div>
                </div>
            </s:iterator>
        </s:if>
    </div>
</section>

<%@ include file="../../footer.jsp" %>
