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


 <table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">

          <tr>
             <th width="232" align="left" bgcolor="#EBEBEB">课程名称</th>
             <th width="289" align="left" bgcolor="#EBEBEB">课程信息</th>
			 <th width="145" bgcolor="#EBEBEB">操作</th>
           
   </tr>
     <c:choose>
        <c:when test="${empty courseSet}">
           <tr>
              <td colspan="3" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
          </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="course" items="${courseSet}">
            <tr >
                <td bgcolor="#EBEBEB">${course.courseName }</td>          
                <td bgcolor="#EBEBEB">${course.info }</td>
                <td colspan="2" align="center" bgcolor="#EBEBEB"><a class="but" href="teacherQuestion.do?method=beforeAddQuestion&courseId=${course.id }">添加作业</a></td>        
            </tr>
              
            </c:forEach>
       
        </c:otherwise>
     
     </c:choose>  

</table><br/>


</body>
</html>