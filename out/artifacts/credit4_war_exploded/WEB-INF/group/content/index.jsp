<div class="col-xs-8 col-md-9">
    <s:if test="currentGroup == null">
        <h2 style="text-align: center;">Please choice a group</h2>
        <hr>
    </s:if>

    <s:else>
        <h2 style="text-align: center;">Group : <s:property value="currentGroup.name"/> </h2>
        <hr>

        <h3>Users :</h3>

        <s:iterator value="currentGroup.usersEntities">
            <div class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
                <s:property value="username"/>
            </div>
        </s:iterator>


        <div class="clear"></div>
        <hr>
        <h3>Tournaments :</h3>

        <s:iterator value="currentGroup.tournamentsEntities">
            <div class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
                <s:property value="name"/>
            </div>
        </s:iterator>


        <div class="clear"></div>
        <hr>
        <h3>Parties :</h3>

        <s:iterator value="currentGroup.partiesEntities">
            <div class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
                <s:property value="name"/>
            </div>
        </s:iterator>

        <div class="clear"></div>
        <s:if test="user != null">
            <s:if test="currentGroup.isPublic == 1">
                <a href="<s:url action="join-group"/>?groupId=<s:property value="currentGroup.id"/>" class="btn btn-primary">
                    Join this group
                </a>
            </s:if>
            <s:elseif test="user.groupsEntities.owner.id == user.id">
                <s:form action="invite-group" method="POST">
                    <input type="number" name="groupId" value="<s:property value="currentGroup.id"/>" hidden>
                    <input type="text" name="username" placeholder="Username..." class="field">
                    <input type="submit" value="Add user" class="field submit">
                </s:form>
            </s:elseif>
        </s:if>

    </s:else>
</div>