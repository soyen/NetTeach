<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 
	<head>
		<title><bean:message key="title"/></title>
		
	    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.3.1.js"></script>	
	</head>
	<body>
<table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
  <tr>
    <td height="40" align="center" bgcolor="#EBEBEB">${notice.title}</td>
  </tr>
  <tr>
    <td align="left" valign="top" bgcolor="#EBEBEB">${notice.content}</td>
  </tr>
  <tr>
    <td height="30" align="center" bgcolor="#EBEBEB"><a  class="but" href="studentNotice.do?method=listNotice&amp;pageNo=${noticeForm.pageNo }&amp;pageSize=${noticeForm.pageSize }">返回</a></td>
  </tr>
</table>
</body>
</html>
