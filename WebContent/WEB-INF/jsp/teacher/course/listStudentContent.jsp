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


<table width="700" border="0" cellpadding="5" cellspacing="1">
  <tr>
    <td height="30"><a class="but" href="teacherCourse.do?method=listStudentCourse">返回</a></td>
  </tr>
  <tr>
    <td><table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
      <tr>
        <th height="30" align="left" bgcolor="#EBEBEB">学生姓名</th>
        <th height="30" align="left" bgcolor="#EBEBEB">学生学号</th>
        <th height="30" align="left" bgcolor="#EBEBEB">所属班级</th>
      </tr>
      <c:choose>
        <c:when test="${empty studentSet}">
          <tr>
            <td height="30" colspan="3" align="center" bgcolor="#EBEBEB">没有数据</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="student" items="${studentSet}">
            <tr >
              <td height="30" bgcolor="#EBEBEB">${student.name }</td>
              <td height="30" bgcolor="#EBEBEB">${student.studentNo }</td>
              <td height="30" bgcolor="#EBEBEB">${student.classes.className }</td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </table></td>
  </tr>
</table>
</body>
</html>