

<%@include file="blocks/header.jsp" %>
<%@include file="blocks/menu.jsp" %>

<%
    String msg="";
    Object regData=request.getParameter("err");
    if(regData!=null){
        msg="Invalid User" ;
    }
    
%>

<div class="tm-section-wrap bg-white">
            <section id="about" class="row tm-section">
                
                <form action="verify" method="post">
                    <div class="row form-group">
                        <h1 class="text-danger bg-dark">User Verification</h1>
                        <hr>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-12">
                            <input type="email" name="email" class="form-control" placeholder="Your Email" required>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-12">
                            <input type="password" name="otp" class="form-control" placeholder="OTP" required>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-6">
                            <button type="submit" class="btb btn-success">Verify</button>
                        </div>
                        <div class="col-lg-6">
                            <b class="text-danger"><%=msg%></b>
                        </div>
                    </div>
                </form>
                
                
<%@include file="blocks/footer.jsp" %>