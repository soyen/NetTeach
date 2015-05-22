<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
		<form action="teacherCourse.do?method=modifyCourse&id=${course.id}" method="post" enctype="multipart/form-data" name="courseForm">
		<table width="500" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td width="71" height="30" align="right" bgcolor="#EBEBEB">课程名称 : </td>
            <td width="406" height="30" bgcolor="#EBEBEB"><input type="text" name="courseName" value="${course.courseName}"/></td>
          </tr>
          <tr>
            <td height="30" align="right" bgcolor="#EBEBEB">信息 :</td>
            <td height="30" bgcolor="#EBEBEB"><textarea name="info" cols="52" rows="5">${course.info}</textarea></td>
          </tr>
          <tr>
            <td height="30" align="right" bgcolor="#EBEBEB">附件:</td>
            <td height="30" bgcolor="#EBEBEB"><input type="file" name="fileContent"/></td>
          </tr>
          <tr>
            <td height="30" colspan="2" align="center" bgcolor="#EBEBEB"><input class="but"  name="submit" type="submit" value="提交"/></td>
          </tr>
          <tr>
            <td height="30" colspan="2" align="center" bgcolor="#EBEBEB"><a href="teacherCourse.do?method=listCourse&amp;pageNo=${courseForm.pageNo }&amp;pageSize=${courseForm.pageSize }">返回</a></td>
          </tr>
        </table>
		</form>
	</body>
</html>
