<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
		<form action="adminDepartment.do?method=addDepartment" method="post" name="departmentForm">
<table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
                        <tr>
                          <td width="82" align="right" bgcolor="#EBEBEB">部门名称:</td>
                          <td width="595" bgcolor="#EBEBEB"><input type="text" name="departmentName"/></td>
                        </tr>
                        <tr>
                          <td align="right" bgcolor="#EBEBEB">部门介绍 :</td>
                          <td bgcolor="#EBEBEB"><textarea name="introduce" cols="75" rows="5"></textarea></td>
                        </tr>
                        <tr>
                          <td colspan="2" align="center" bgcolor="#EBEBEB"><input class="but" type="submit" value="提交"/></td>
                        </tr>
          </table>
		</form>
	</body>
</html>
