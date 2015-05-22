<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
		<form action="teacherNotice.do?method=listNotice&amp;pageNo=1&pageSize=10" name="noticeForm" method="post">
		  <table width="400" height="30" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
           <tr>
             <td align="center" bgcolor="#EBEBEB">标题 :
             &nbsp;&nbsp;&nbsp;&nbsp;
             <input type="text" name="queryStr"/>&nbsp;<input  class="but" name="submit" type="submit" value="查询"/></td>
           </tr>
         </table>
		</form>
	</body>
</html>
