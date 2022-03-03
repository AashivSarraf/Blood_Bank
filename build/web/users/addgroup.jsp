
<!-- DOUBT NOT SHOWING DATA -->

<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bloodbank.dto.Data"%>
<%@page import="java.util.List"%>
<%@page import="com.bloodbank.dao.DataDao"%>
<%@include file="../blocks/header.jsp" %>
<%@include file="../blocks/afterloginmenu.jsp" %>

<%
    String msg="";
    Object regData=request.getParameter("reg");
    if(regData!=null){
        if(regData.equals("true")){
            msg="Data Saved" ;
        }else{
            msg="Data Not Saved" ;
        }
    }
 
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
    DataDao dao=new DataDao();
    List<Data> lists=dao.listByName(email);
%>

    <div class="tm-section-wrap bg-white">
        <section id="about" class="row tm-section">
            
            <form action="<%=path%>/users/add" method="post">
                <div class="row form-group">
                    <h1 class="text-danger bg-dark">Add Blood Group</h1> 
                </div>
                <div class="row form-group">
                    <div class="col-lg-6">
                        <input type="text" name="userName" class="form-control" placeholder="Your Name" required>
                    </div>
                    <div class="col-lg-6">
                        <input type="email" name="email" class="form-control" placeholder="Your Email" required>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-6">
                        <input type="text" name="phone" class="form-control" placeholder="Contact No." required>
                    </div>
                    <div class="col-lg-6">
                        <input type="text" name="location" class="form-control" placeholder="location" required>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-6">
                        <input type="text" name="group" class="form-control" placeholder="Blood Group" required>
                    </div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-6">
                        <button type="submit" class="btn btn-success">Save</button>
                    </div>
                    <div class="col-lg-6">
                        <b class="text-danger"><%=msg%></b>
                    </div>
                </div>
            </form>
            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Location</th>
                    <th>Blood Group</th>
                    <th>Date</th>
                </tr>
                <% for(Data d : lists){ %>
                <tr>
                    <td><%=d.getUserName()%></td>
                    <td><%=d.getEmail()%></td>
                    <td><%=d.getPhone()%></td>
                    <td><%=d.getLocation()%></td>
                    <td><%=d.getBloodGroup()%></td>
                    <td><%=sdf.format(d.getUploadDate())%></td>
                </tr>
                <% } %>
            </table>
        </section>
    </div>
<%@include file="../blocks/footer.jsp" %>