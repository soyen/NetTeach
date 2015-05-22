<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="title"/></title>
</head>
<body>
<font color="red">${result}</font><table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
<tr>
<td height="30" colspan="2" bgcolor="#EBEBEB"><strong>课程名称</strong></td>
<td width="233" height="30" colspan="1" bgcolor="#EBEBEB"><strong>课程信息</strong></td>
<td width="194" height="30" colspan="1" align="center" bgcolor="#EBEBEB"><strong>操作</strong></td>
</tr>
<c:choose>
<c:when test="${empty courseSet}">
<tr>
<td height="30" colspan="4" align="center" bgcolor="#EBEBEB">没有数据</td>
</tr>
</c:when>
<c:otherwise>
<c:forEach var="course" items="${courseSet}">
<tr >
<td height="30" colspan="2" bgcolor="#EBEBEB">${course.courseName }</td>
<td height="30" colspan="1" bgcolor="#EBEBEB">${course.info }</td>
<td height="30" colspan="1" align="center" bgcolor="#EBEBEB"><a class="but" href="studentCourse.do?method=findCourse&id=${course.id }">查看</a>&nbsp;<a class="but" href="studentCourse.do?method=deleteCourse&id=${course.id }" onClick="return confirm('确认删除？');">删除</a></td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>  
</table>




</body>
</html>