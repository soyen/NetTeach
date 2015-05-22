<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
	<html:errors/>
		<form action="teacherSource.do?method=addSource" method="post" enctype="multipart/form-data" name="sourceForm" >
		  <table width="400" height="30" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              <tr>
                <td height="30" align="center" bgcolor="#EBEBEB">资源:
                &nbsp;&nbsp;&nbsp;
                <input type="file" name="fileContent"/>&nbsp;<input  class="but" name="submit" type="submit" value="提交"/></td>
              </tr>
            </table>
		</form>
	</body>
</html>
