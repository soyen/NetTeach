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
<table width="776" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td width="747" height="30"><a class="but" href="queryCourse.do">查询</a>&nbsp;<a class="but" href="adminCourse.do?method=listCourse&amp;pageNo=1&amp;pageSize=5&amp;queryStr=">重置</a></td>
  </tr>
  <tr>
    <td><table width="772" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">

          <tr>
             <th width="153" align="left" bgcolor="#EBEBEB">课程名称</th>
             <th width="94" align="left" bgcolor="#EBEBEB">课程信息</th>
             <th width="153" align="left" bgcolor="#EBEBEB">所属教师</th>
             <th width="121" align="left" bgcolor="#EBEBEB">附件</th>
			 <th width="195" bgcolor="#EBEBEB">操作</th>
   </tr>
     <c:choose>
        <c:when test="${empty pagemodel.list}">
           <tr align="left">
              <td colspan="5" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
          </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="course" items="${pagemodel.list}">
            <tr >
                <td align="left" bgcolor="#EBEBEB">${course.courseName }</td>
                <td align="left" bgcolor="#EBEBEB">${course.info }</td>
                <td align="left" bgcolor="#EBEBEB">${course.teacher.name }</td>
              <c:choose>
                <c:when test="${!empty course.fileContent}">
                 <td align="left" bgcolor="#EBEBEB"><a href="adminCourse.do?method=download&id=${course.id }">${course.fileName}</a></td>
                </c:when>
                 <c:otherwise>                 </c:otherwise>
              </c:choose> 
                 <td align="center" bgcolor="#EBEBEB"><a class="but" href="adminCourse.do?method=findCourse&id=${course.id }" onClick="return confirm('确认进入编辑？');">编辑</a>&nbsp;<a class="but" href="adminCourse.do?method=deleteCourse&id=${course.id }" onClick="return confirm('确认删除？');">删除</a></td>
              </tr>
            </c:forEach>
        </c:otherwise>
     </c:choose>  
</table></td>
  </tr>
  <tr>
    <td height="30" align="right"><a class="but" href="adminCourse.do?method=listCourse&pageNo=${pagemodel.topPageNo}&pageSize=${courseForm.pageSize}">首页</a>&nbsp;<a class="but" href="adminCourse.do?method=listCourse&pageNo=${pagemodel.previousPageNo}&pageSize=${courseForm.pageSize}">前一页</a>&nbsp;<a class="but" href="adminCourse.do?method=listCourse&pageNo=${pagemodel.nextPageNo}&pageSize=${courseForm.pageSize}">后一页</a>&nbsp;<a class="but" href="adminCourse.do?method=listCourse&pageNo=${pagemodel.bottomPageNo}&pageSize=${courseForm.pageSize}">尾页</a></td>
  </tr>
</table>
</body>
</html>