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
             <th height="30" align="left" bgcolor="#EBEBEB">内容</th>
             <th height="30" align="left" bgcolor="#EBEBEB">学生姓名</th>
             <th height="30" align="center" bgcolor="#EBEBEB">分数</th>
             
   </tr>
     <c:choose>
        <c:when test="${empty answerSet}">
           <tr>
              <td height="30" colspan="3" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
          </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="answer" items="${answerSet}">
            <tr >
                <td height="30" bgcolor="#EBEBEB">${answer.content }</td>
                <td height="30" bgcolor="#EBEBEB">${answer.student.name }</td>
                <td height="30" align="center" bgcolor="#EBEBEB"><form id="form2" name="form2" method="post" action="teacherQuestion.do?method=score&answerId=${answer.id }">
	                   <input name="score" type="text" id="score" value="${answer.score}" size="4" />		
	                   &nbsp;
	                   <input type="submit" name="Submit" value="评分 "  class="but" />
	                   <input type="hidden" name="questionId" value="${questionId}"/>
              </form></td>
       
              
                        
            </tr>
              
            </c:forEach>
       
        </c:otherwise>
     
     </c:choose>  

</table><br/>


</body>
</html>