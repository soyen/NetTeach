<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
		<form action="adminDepartment.do?method=modifyDepartment&id=${department.id}" name="departmentForm" method="post">
		<table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td width="80" align="right" bgcolor="#EBEBEB">部门名称 :</td>
            <td width="597" bgcolor="#EBEBEB"><input type="text" name="departmentName" value="${department.departmentName}"/></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#EBEBEB">部门介绍 : </td>
            <td bgcolor="#EBEBEB"><textarea name="introduce" cols="75" rows="5">${department.introduce}</textarea></td>
          </tr>
          <tr>
            <td colspan="2" align="center" bgcolor="#EBEBEB"><input class="but" type="submit" value="提交"/></td>
          </tr>
          <tr>
            <td colspan="2" align="center" bgcolor="#EBEBEB"><a class="but" href="adminDepartment.do?method=listDepartment&amp;pageNo=${departmentForm.pageNo }&amp;pageSize=${departmentForm.pageSize }">返回</a></td>
          </tr>
        </table>
		</form>
	</body>
</html>
