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
<body><h5>${courseName}</h5>
<form id="form2" name="form2" method="post" action="teacherQuestion.do?method=deleteQuestion&id=${question.id}">
 <table width="714" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
   
          <tr>
             <th height="30" align="left" bgcolor="#EBEBEB">题目</th>
             <th height="30" align="left" bgcolor="#EBEBEB">参考答案</th>
             <th height="30" align="left" bgcolor="#EBEBEB">参考分值</th>
			 <th height="30" colspan="2" bgcolor="#EBEBEB">操作</th>     
             
   </tr>
     <c:choose>
        <c:when test="${empty questionSet}">
           <tr>
              <td height="30" colspan="5" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
          </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="question" items="${questionSet}">
            	<tr >
                <td height="30" bgcolor="#EBEBEB">${question.title }</td>
                <td height="30" bgcolor="#EBEBEB">${question.content}</td>
                <td height="30" bgcolor="#EBEBEB">${question.score}</td>
                 <td height="30" align="center" bgcolor="#EBEBEB"><a class="but" href="teacherQuestion.do?method=listAnswer&id=${question.id }">查看作业</a></td>
                 <td height="30" align="center" bgcolor="#EBEBEB">                  		
	                   <input type="submit"  class="but" name="Submit" value="删除" onClick="return confirm('确认删除？');"/>
	                   <input type="hidden" name="courseId" value="${courseId}"/>
              </td>
                        
            </tr>
              
            </c:forEach>
       
        </c:otherwise>
     
     </c:choose>  

</table><br/>
</form>
</body>
</html>