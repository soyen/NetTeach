<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
		<form action="adminStudent.do?method=listStudent&amp;pageNo=1&pageSize=10" name="studentForm" method="post">
		    <table width="400" height="30" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
           <tr>
             <td align="center" bgcolor="#EBEBEB">学生姓名 : 
               <input type="text" name="queryStr"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <input  class="but" type="submit" value="查询"/></td>
           </tr>
         </table>
		</form>
	</body>
</html>
