<%-- 
    Document   : Dashboard
    Created on : Mar 20, 2015, 6:50:38 AM
    Author     : raakesh-pt503
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
       .login input[type=submit]{
	width: 200px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: black;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
    }
.body{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(http://www.visitdenmark.co.uk/sites/default/files/styles/galleries_ratio/public/vdk_images/Attractions-Activities-interest-accommodation-people-geo/Shopping/shopping-boejler.jpg?itok=8VTpUFnv);
	background-size: cover;
	-webkit-filter: blur(5px);
	z-index: 0;
}
        </style>
        
    </head>
    <body background="http://www.visitdenmark.co.uk/sites/default/files/styles/galleries_ratio/public/vdk_images/Attractions-Activities-interest-accommodation-people-geo/Shopping/shopping-boejler.jpg?itok=8VTpUFnv" style="background-repeat:no-repeat;background-size:cover;">
       
        <div class="login" >
            <form action="getParameters.jsp" method="post">
            <input type="submit" value="Enter Size" style="float: right;"/>
        </form>
        <br>
        <form action="Controller" method="POST">
        <div style="width: 1500px;">
            <div style="float: left; width: 200px;height:200px;margin-top: 200px;margin-left: 30px;background: #FFFBFB">
                <img src="http://anf.scene7.com/is/image/anf/anf_70793_01_prod1?$productMagnify-anf$" style="width: 200px;height: 200px"/>
                <input type="submit" name="book1" value="book"/>
            </div>
            <div style="float: left; width: 200px;height:200px;margin-top: 200px;margin-left: 30px;background: #FFFBFB">
                 <img src="http://images.mitre.com/images/mitre-polarize-t-shirt-p177-1103_image.jpg" style="width: 200px;height: 200px"/>
                 <input type="submit" name="book2" value="Book"/>
            </div>
            <div style="float: left; width: 200px;height:200px;margin-left: 30px;margin-top: 200px;background: #FFFBFB">
                 <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1Hl0jr_uu0euFlHZ3RN7ZP7GfOYf-2ocE_LpbZM9SH0j6JAg1" style="width: 200px;height: 200px"/>
                 <input type="submit" name="book3" value="Book"/>
            </div>  
            <div style="float: left; width: 200px;height:200px;margin-left: 30px;margin-top: 200px;background: #FFFBFB">
                 <img src="http://brentcriticalreview.weebly.com/uploads/2/3/5/6/23568872/4748206_orig.jpg" style="width: 200px;height: 200px"/>
                 <input type="submit" name="book4" value="Book"/>
            </div> 
            <div style="float: left; width: 200px;height:200px;margin-left: 30px;margin-top: 200px;background: #FFFBFB">
                 <img src="http://anf.scene7.com/is/image/anf/anf_70793_01_prod1?$productMagnify-anf$" style="width: 200px;height: 200px"/>
                 <input type="submit" name="book5" value="Book"/>
            </div> 
            </div>
        </form>
 <br style="clear: left;" />
</div>
 <br style="clear: left;" />
</div>
        
        <%
        HttpSession session1=request.getSession();
        String username=session1.getAttribute("username").toString();
        if(username.equals("") || username==null){
            response.sendRedirect("index.jsp?msg=Session Expired");
        }
        %>
    </body>
</html>
