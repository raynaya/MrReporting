
 
<%@page import="DatabaseConnection.DbConnection"%>
<%@page import="java.sql.*"%>
<%@page import="Org.MrReporting.Shamik.BeanClass.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>

    <head> <SCRIPT type="text/javascript"   language="javascript">
        function addRow(tableID) {

            var table = document.getElementById(tableID);

            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);

            var colCount = table.rows[0].cells.length;

            for(var i=0; i<colCount; i++) {

                var newcell = row.insertCell(i);

                newcell.innerHTML = table.rows[0].cells[i].innerHTML;
                //alert(newcell.childNodes);
                switch(newcell.childNodes[0].type) {
                    case "text":
                            newcell.childNodes[0].value = "";
                            break;
                    case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                    case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                }
            }
        }

        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;

            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    if(rowCount <= 1) {
                        alert("Cannot delete all the rows.");
                        break;
                    }
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }

            }
            }catch(e) {
                alert(e);
            }
        }
 
    </SCRIPT>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="jqwidgets/styles/jqx.base.css" type="text/css" />
    <script type="text/javascript" src="scripts/gettheme.js"></script>
    <script type="text/javascript" src="scripts/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxmenu.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxcheckbox.js"></script>
     <script type="text/javascript" src="jqwidgets/jqxdatetimeinput.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxcalendar.js"></script>
    <script type="text/javascript" src="jqwidgets/jqxtooltip.js"></script>
    <script type="text/javascript" src="jqwidgets/globalization/jquery.global.js"></script>

    <link href="styles/mrstyles.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        

    
 
    <div id="headerbar">
    <% Mr userInfo= (Mr) request.getSession().getAttribute("UserInfo");
    String hqname="",name="";
    
    hqname =userInfo.getHqName();
    name=userInfo.getFirstName();
    
    DbConnection db = new DbConnection();
            Connection c=db.createConnection();
            Statement s =c.createStatement();
        ResultSet  area =s.executeQuery("select * from AREAMASTER where HQNAME='"+hqname+"'");
       
        %>
        <span id="welcomename" style=" position: absolute; font-weight: 600; color: brown;   margin-left: 20px;  padding-top: 20px " > Hello <%=name%></span>
        <div class="headerbarlist" title="Log Out" id="logout"
             onclick="$.ajax({
  url: 'logout',
  success: function(data) {
    window.location.assign('\login.jsp');

  }
});"  >
            <a></a>
    </div>
    </div>
        
        <script type="text/javascript">
            $(document).ready(function () {
                var theme = getTheme();
                // Create a jqxMenu
                $("#jqxMenu").jqxMenu({ mode:'vertical', width: '150px', height: '200px',autoOpen: false, showTopLevelArrows: true , theme: theme });
                $("#jqxMenu").css('visibility', 'visible');
                $("#disabled").jqxCheckBox({ theme: theme, width: '150px', height: '20px' });
                $("#open").jqxCheckBox({ theme: theme, width: '150px', height: '20px' });
                $("#hover").jqxCheckBox({ theme: theme, width: '150px', height: '20px' });
                $("#topLevelArrows").jqxCheckBox({ theme: theme, width: '200px', height: '20px' });
                $("#animation").jqxCheckBox({ theme: theme, width: '150px', height: '20px' });

                $("#animation").bind('change', function (event) {
                    var value = event.args.checked;
                    // enable or disable the menu's animation.
                    if (!value) {
                        $("#jqxMenu").jqxMenu({ animationShowDuration: 0, animationHideDuration: 0, animationShowDelay: 0 });
                    }
                    else {
                        $("#jqxMenu").jqxMenu({ animationShowDuration: 300, animationHideDuration: 200, animationShowDelay: 200 });
                    }
                });

                $("#disabled").bind('change', function (event) {
                    var value = event.args.checked;
                    // enable or disable the menu
                    if (!value) {
                        $("#jqxMenu").jqxMenu({ disabled: false });
                    }
                    else {
                        $("#jqxMenu").jqxMenu({ disabled: true });
                    }
                });

                $("#hover").bind('change', function (event) {
                    var value = event.args.checked;
                    // enable or disable the menu's hover effect.
                    if (!value) {
                        $("#jqxMenu").jqxMenu({ enableHover: false });
                    }
                    else {
                        $("#jqxMenu").jqxMenu({ enableHover: true });
                    }
                });

                $("#open").bind('change', function (event) {
                    var value = event.args.checked;
                    // enable or disable the opening of the top level menu items when the user hovers them.
                    if (!value) {
                        $("#jqxMenu").jqxMenu({ autoOpen: false });
                    }
                    else {
                        $("#jqxMenu").jqxMenu({ autoOpen: true });
                    }
                });
                $("#topLevelArrows").bind('change', function (event) {
                    var value = event.args.checked;
                    // enable or disable the opening of the top level menu items when the user hovers them.
                    if (!value) {
                        $("#jqxMenu").jqxMenu({ showTopLevelArrows: false });
                    }
                    else {
                        $("#jqxMenu").jqxMenu({ showTopLevelArrows: true });
                    }
                });
            });
        </script>
         <div id='jqxWidget' style='height: 300px; position: relative; top: 100px; left: 80px; '>
            <div id='jqxMenu' style='visibility: hidden; margin-left: 60px;'>
                <ul>
                    <li><a href="/home.jsp">Home</a></li>
                    <li>MrTasks
                        <ul style='width: 250px;'>
                            <li><a href="#">Tour Plan</a></li>
                            <li><a href="/dcrmaintenance.jsp">DCR</a></li>
                            <li><a href="/ccrmaintenance.jsp">ChemistCR</a></li>
                            <li><a href="#">Stockist Sales Position</a></li>
                            <li><a href="#">Expenses</a></li>
                            <li><a href="#">Leave Application</a></li>
                                                    
                        </ul>
                    </li>
                    <li>Products
                        <ul>
                            <li><a href="#PCProducts">PC products</a></li>
                            <li><a href="#MobileProducts">Mobile products</a></li>
                            <li><a href="#AllProducts">All products</a></li>
                        </ul>
                    </li>
                    <li>Support
                        <ul style='width: 200px;'>
                            <li><a href="#SupportHome">Support home</a></li>
                            <li><a href="#CustomerService">Customer Service</a></li>
                            <li><a href="#KB">Knowledge base</a></li>
                            <li><a href="#Books">Books</a></li>
                            <li><a href="#Training">Training and certification</a></li>
                            <li><a href="#SupportPrograms">Support programs</a></li>
                            <li><a href="#Forums">Forums</a></li>
                            <li><a href="#Documentation">Documentation</a></li>
                            <li><a href="#Updates">Updates</a></li>
                        </ul>
                    </li>
                    <li>Communities
                        <ul style='width: 200px;'>
                            <li><a href="#Designers">Designers</a></li>
                            <li><a href="#Developers">Developers</a></li>
                            <li><a href="#Educators">Educators and students</a></li>
                            <li><a href="#Partners">Partners</a></li>
                            <li type='separator'></li>
                            <li>By resource
                                <ul>
                                    <li><a href="#Labs">Labs</a></li>
                                    <li><a href="#TV">TV</a></li>
                                    <li><a href="#Forums">Forums</a></li>
                                    <li><a href="#Exchange">Exchange</a></li>
                                    <li><a href="#Blogs">Blogs</a></li>
                                    <li><a href="#Experience Design">Experience Design</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>Company
                        <ul style='width: 180px;'>
                            <li><a href="#About">About Us</a></li>
                            <li><a href="#Press">Press</a></li>
                            <li><a href="#Investor">Investor Relations</a></li>
                            <li><a href="#CorporateAffairs">Corporate Affairs</a></li>
                            <li><a href="#Careers">Careers</a></li>
                            <li><a href="#Showcase">Showcase</a></li>
                            <li><a href="#Events">Events</a></li>
                            <li><a href="#ContactUs">Contact Us</a></li>
                            <li><a href="#Become an affiliate">Become an affiliate</a></li>
                        </ul>
                    </li>
					

                </ul>
            </div>
            <br />

        </div>


        <%if(request.getSession().getAttribute("message")!=null){%>
        <%=request.getSession().getAttribute("message").toString()%>
            <% request.getSession().removeAttribute("message"); }
    %>

        <div id="container">
 <script type="text/javascript">
            $(document).ready(function () {
                var theme = getTheme(4);
                // Create a jqxDateTimeInput
				$("#jqxWidget1").jqxDateTimeInput({ width: '150px', height: '20px', theme:'darkblue' });
            });

          function getdate(){
			d=$("#jqxWidget1").jqxDateTimeInput('getDate');
				 
				date=d.getDate();
				 month=d.getMonth()+1;
				 year=d.getFullYear();
				 d=date+"."+month+"."+year;
				$("#date").attr('value',d);
                                if(document.getElementById("visitedarea").value=="")
                                   {alert("fill up all the fields");
                                    return false;
                                    }
                                 if(document.getElementById("doctor").value=="")
                                   {alert("fill up all the fields");
                                    return false;
                                    }
                                  

                               return true;

			}

        </script>
            <form method="post"   action="storeDcr" >

<div id='jqxWidget1' >
               Date :
        </div><br>

<br/>
<input id="date" type="hidden" name="date" value="" />
 
        <div ><span >Area:
        <select id="visitedarea" name="area">
            <option value="">Select an area</option>
            <% while(area.next()){ %>
            <option value=<%=area.getString("AREANAME")%> > <%=area.getString("AREANAME")%></option>
    
                <%}%>
        </select></span>

   
	
		    <script type="text/javascript" charset="utf-8">
$(function(){
  $("select#visitedarea").change(function(){
      $("select#product").html("");
    $.getJSON("/selectDoctor",{id: $(this).val(), ajax: 'true'}, function(j){
      var options = '';
     
      for (var i = 0; i < j.length; i++) {
        options += '<option value="' + j[i].optionValue + '">' + j[i].optionDisplay + '</option>';
        
      }
      $("select#doctor").html(options);
      

    })
	
	
  })
})
</script>
		
        <span > Doctors Name :<select id="doctor" name="Dr">
        <option value="">select area first</option>
      
        </select>  </span>
        <span >
        Visit Time:
        <span id="box">
        Morning : <input type="radio" value="M" name="time"/>
        Evening : <input type="radio" value="E" name="time"/>
        </span>

        </span>

        </div>
        <br>
<br>

        <div ><span>

        Visit Status :
        <span id="box">
        ASM <input type="checkbox" value ="A" name="visitstatus"/>
        ZSM<input type="checkbox" value="Z" name="visitstatus"/>
        Other<input type="checkbox" value="O" name="visitstatus"/>
        </span>
         </span>
         <span > Product Status :
         <span id="box">
           Old<input type="radio" value ="O" name="prodstatus"/>
           New<input type="radio" value ="N" name="prodstatus"/>
         </span>
         </span>
         </div>

        <br/>
        <br/>
		<script type="text/javascript" charset="utf-8">
$(function(){
  $("select#doctor").change(function(){
    $.getJSON("/selectMedicine",{id: $(this).val(), ajax: 'true'}, function(j){
      var options = '';
     
      for (var i = 0; i < j.length; i++) {
        options += '<option value="' + j[i].optionValue + '">' + j[i].optionDisplay + '</option>';
        
      }
      $("select#product").html(options);
    })
	
	
  })
})
</script>

    <h4> Products Shown and Quantity given.</h4>
    <TABLE id="dataTable" cellpadding="5px"  rules="all" border="1">

        <tr>
            <td><INPUT type="checkbox" name="chk"/></td>
            <td>  <SELECT id ="product" name="productname">
                    <OPTION value="">select Doctor</OPTION>
                   </SELECT>
            </td>
            <td>
                <input type="text" size="8px"  title="quantity" name="quantity" />
                       
            </td>
        </tr>
    </TABLE><br>
<br>
<input type="submit" onclick="return getdate()" />
            </form>
    <INPUT type="button" value="Add Row" onClick="addRow('dataTable')" />

    <INPUT type="button" value="Delete Row" onClick="deleteRow('dataTable')" />

 </div>
  </body>
</html>
