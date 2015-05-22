<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
		
		<form action="adminClasses.do?method=listClasses&amp;pageNo=1&pageSize=10" name="classesForm" method="post"><table width="387" height="30" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
  <tr>
<td height="30" align="center" bgcolor="#EBEBEB">
		    班级名称 : &nbsp;
		    <input type="text" name="queryStr"/>
		    &nbsp;
         <input class="but" type="submit" value="查询"/>
	</td>
  </tr>
</table></form>

	</body>
</html>
