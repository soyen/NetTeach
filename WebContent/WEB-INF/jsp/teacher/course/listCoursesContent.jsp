<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
   <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="title"/></title>
</head>
<body>
<html:errors/>
<table width="700" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="30"><a class="but" href="addCourse.do">添加课程</a></td>
  </tr>
  <tr>
    <td><table width="900" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
      <tr>
        <th align="left" bgcolor="#EBEBEB" width="100">课程名称</th>
        <th align="left" bgcolor="#EBEBEB">课程信息</th>
        <th align="left" bgcolor="#EBEBEB" width="150">附件</th>
        <th bgcolor="#EBEBEB" width="200">操作</th>
      </tr>
      <c:choose>
        <c:when test="${empty courseSet}">
          <tr>
            <td colspan="4" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="course" items="${courseSet}">
            <tr >
              <td align="left" bgcolor="#EBEBEB">${course.courseName }</td>
              <td align="left" bgcolor="#EBEBEB">${course.info }</td>
              <c:choose>
                <c:when test="${!empty course.fileContent}">
                  <td align="left" bgcolor="#EBEBEB"><a href="teacherCourse.do?method=download&id=${course.id }">${course.fileName}</a></td>
                </c:when>
                <c:otherwise>
                  <td>无</td>
                </c:otherwise>
              </c:choose>
              <td align="center" bgcolor="#EBEBEB"><a class="but" href="teacherCourse.do?method=findCourse&id=${course.id }" onClick="return confirm('确认进入编辑？');">编辑</a>&nbsp;<a class="but" href="teacherCourse.do?method=deleteCourse&id=${course.id }" onClick="return confirm('确认删除？');">删除</a></td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </table></td>
  </tr>
</table>
</body>
</html>