<%@ page import="entities.UsersEntity" %>
<%@ include file="../../header.jsp" %>

<section>
    <div class="container">
        <div class="col-xs-12 col-sm-4 col-md-4 col-lg-3">
            <div class="party">
                <h3>Properties</h3>
                <hr>
                <p>Created by <s:property value="tournament.usersEntity.username"/>.</p>
                <p>
                    This tournament is
                    <s:if test="tournament.isPublic == 1">
                        public
                    </s:if>
                    <s:else>
                        private
                    </s:else>.
                </p>
            </div>

            <div class="party">
                <h3>Group access</h3>
                <hr>
                <ul>
                    <s:iterator value="tournament.groupsEntities">
                        <li><s:property value="name"/></li>
                    </s:iterator>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-8 col-md-4 col-lg-9">
            <s:iterator value="tournament.partiesEntity">
                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4">
                    <div class="party">
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
    </div>
</section>

<%@ include file="../../footer.jsp" %>