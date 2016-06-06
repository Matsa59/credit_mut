<%@ include file="../../header.jsp" %>
<section>
    <div class="container">
        <s:iterator value="parties">
            <div class="col-xd-12 col-sm-6 col-md-4 col-lg-3">
                <div class="party">
                    <s:if test="%{tournamentsEntity == null}">
                        <h3>By "<s:property value="usersEntity.username"/>"</h3>
                    </s:if>
                    <s:else>
                        <h3>Tournament : <s:property value="tournamentsEntity.name"/></h3>
                    </s:else>
                    <hr>
                    <p><s:property value="name"/></p>



                    <p>
                        <a href="<s:url action="define-response"/>?partyId=<s:property value="id"/>">
                        Show more
                        </a>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#party-<s:property value="id"/>">Bet</button>
                    </p>
                </div>
            </div>

            <div id="party-<s:property value="id"/>" class="modal fade" tabindex="-1" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4>Bet !</h4><br />
                            <span>Make your choice</span>
                        </div>
                        <div class="modal-body">
                            <s:iterator value="choicesPartiesEntity">
                                <div class="field choice" id="<s:property value="id"/>">
                                    <s:property value="name"/>
                                </div>
                            </s:iterator>

                            <button class="field submit choice-submit">Bet !</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        </s:iterator>
    </div>
</section>

<%@ include file="../../footer.jsp"%>