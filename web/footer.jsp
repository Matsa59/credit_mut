<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<div id="signUpModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4>Sign up</h4><br />
                <span>Enter informations required to create a new account</span>
            </div>
            <div class="modal-body">
                <%@include file="WEB-INF/account/forms/register_form.jsp"%>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="signInModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4>Sign in</h4>
                <span>Enter credentials to login in</span>
            </div>
            <div class="modal-body">
                <%@include file="WEB-INF/account/forms/login_form.jsp"%>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</body>
</html>