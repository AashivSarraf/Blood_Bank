
<%@include file="blocks/header.jsp" %>
<%@include file="blocks/menu.jsp" %>


<%
    String msg="";
    Object ob=request.getParameter("reg");
    if(ob!=null){
        if(ob.equals("true")){
            msg="User Registration Successfully Done" ;
        }else{
            msg="User Registration Failed" ;
        }
    }
%>

<div class="tm-section-wrap bg-white">
            <section id="about" class="row tm-section">
                
                
                <form action="register" method="post">
                    <div class="row form-group" align="center">
                        <h1 class="text-danger bg-dark">User Registration</h1>
                        <hr>
                        <br><br>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-6" >
                            <input type="text" name="userName" class="form-control" placeholder="Your Name" required>
                        </div>
                        
                        <div class="col-lg-6" >
                            <input type="email" name="email" class="form-control" placeholder="Your Email" required>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-6">
                            <input type="password" name="password" class="form-control" placeholder="Password" required>
                        </div>
                        <div class="col-lg-6">
                            <input type="password" class="form-control" placeholder="Confirm Password" required>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-6">
                            <button type="submit" class="btn btn-success">Register</button>
                        </div>
                        <div class="col-lg-6">
                            <b class="text-danger"><%=msg%></b>
                        </div>
                    </div> 
                </form>
                
<%@include file="blocks/footer.jsp" %>