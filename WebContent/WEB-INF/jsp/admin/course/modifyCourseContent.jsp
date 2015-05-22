<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
<form action="adminCourse.do?method=modifyCourse&id=${course.id}" method="post" enctype="multipart/form-data" name="courseForm"><table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td width="80" align="right" bgcolor="#EBEBEB">课程名称 :</td>
            <td width="597" height="30" align="left" bgcolor="#EBEBEB"><input type="text" name="courseName" value="${course.courseName}"/></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#EBEBEB">信息 :</td>
            <td align="left" bgcolor="#EBEBEB"><textarea name="info" cols="75" rows="5">${course.info}</textarea></td>
          </tr>
          <tr>
            <td height="30" align="right" bgcolor="#EBEBEB">附件:</td>
            <td height="30" align="left" bgcolor="#EBEBEB"><input type="file" name="fileContent"/></td>
          </tr>
          <tr>
            <td height="30" colspan="2" align="center" bgcolor="#EBEBEB"><input class="but" type="submit" value="提交"/></td>
          </tr>
          <tr>
            <td height="30" colspan="2" align="center" bgcolor="#EBEBEB"><a class="but" href="adminCourse.do?method=listCourse&amp;pageNo=${courseForm.pageNo }&amp;pageSize=${courseForm.pageSize }">返回</a></td>
          </tr>
        </table>
</form>
	</body>
</html>
