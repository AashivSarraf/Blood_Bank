
<%@include file="../blocks/header.jsp" %>
<%@include file="../blocks/afterloginmenu.jsp" %>


<script>
    function search(bloodGroup){
        if(bloodGroup.length==0){
            return;
        }
        else{
            var request=new XMLHttpRequest();
            var url="<%=path%>/users/search?txt="+bloodGroup;
            request.open("GET",url);
            request.onreadystatechange=function(){
                if(request.readyState==4 && request.status==200){
                    var data=request.responseText;
                    var obj=JSON.parse(data);
                    console.log(obj);
                    var finalData="";
                    for(var x=0;x<obj.length;x++){
                        var ob=obj[x];
                        var tr="<tr>";
                        tr += "<td>"+ob.userName+"</td>";
                        tr += "<td>"+ob.email+"</td>";
                        tr += "<td>"+ob.phone+"</td>";
                        tr += "<td>"+ob.location+"</td>";
                        tr += "<td>"+ob.bloodGroup+"</td>";
                        tr += "</tr>";
                        
                        finalData += tr;
                    }
                    document.getElementById("tb").innerHTML=finalData;
                }
            }
        }
        request.send();
    }
</script>

 <div class="tm-section-wrap bg-white">
     <section id="about" class="row tm-section">
         
         <div class="row form-group" align="center">
             <div class="col-lg-12">
                 <h1 class="text-danger bg-dark">Search Blood Group</h1>    
             </div>
         </div>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
         <div>
             <input type="text" onkeyup="search(this.value)" placeholder="Search Blood Group">
         </div>    
         
          <table class="table table-hover" border="2" cellpadding="20" cellspacing="30">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Location</th>
                    <th>Blood Group</th>
                </tr>
                <tbody id="tb">

                </tbody>
          </table>
                 
   
     </section>
 </div>

<%@include file="../blocks/footer.jsp" %>