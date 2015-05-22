<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
	    <table width="460" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td align="center" valign="middle" bgcolor="#EBEBEB"><form action="studentNotice.do?method=listNotice&amp;pageNo=1&pageSize=10" name="noticeForm" method="post">
		    <strong>标题 :</strong> &nbsp;&nbsp;&nbsp;
		    <input type="text" name="queryStr"/>
		    &nbsp;&nbsp;&nbsp;&nbsp;
		    <input  class="but" type="submit" value="查询"/>
		    </form></td>
          </tr>
    </table>
	</body>
</html>
