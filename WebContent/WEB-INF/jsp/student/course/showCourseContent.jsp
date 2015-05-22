<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	
	
<body>


<table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#999999">
  <tr>
    <td width="100" height="30" align="right" bgcolor="#EBEBEB"><strong>课程名称</strong></td>
    <td width="600" height="30" bgcolor="#EBEBEB"><label>${course.courseName}</label></td>
  </tr>
  <tr>
    <td width="100" height="30" align="right" bgcolor="#EBEBEB"><strong>信息</strong></td>
    <td width="600" height="30" bgcolor="#EBEBEB"><textarea name="info" cols="70" rows="5">${course.info}</textarea></td>
  </tr>
  <tr>
    <td width="100" height="30" align="right" bgcolor="#EBEBEB"><strong>附件</strong></td>
    <td width="600" height="30" bgcolor="#EBEBEB"><a href="studentCourse.do?method=download&id=${course.id}">${course.fileName}</a></td>
  </tr>
  <tr>
    <td height="30" colspan="2" align="center" bgcolor="#EBEBEB"><a class="but" href="studentCourse.do?method=listCourse">返回</a></td>
  </tr>
</table>
</body>
</html>
