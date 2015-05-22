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

<font color="red">${isDone }</font>
  <table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
    
          <tr>
             <th width="553" height="30" align="left" bgcolor="#EBEBEB">题目</th>
			 <th width="124" height="30" align="center" bgcolor="#EBEBEB">做作业</th>
   </tr>
     <c:choose>
        <c:when test="${empty questionSet}">
           <tr>
              <td height="30" colspan="3" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
          </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="question" items="${questionSet}">
            <form id="form2" name="form2" method="post" action="studentHomework.do?method=beforeDoHomework&questionID=${question.id}">	<tr >
                <td height="30" align="left" bgcolor="#EBEBEB">${question.title}</td>
                
                 <td height="30" align="center" bgcolor="#EBEBEB">             	
	                   <input  class="but" type="submit" name="Submit" value="做作业" />
	                   <input type="hidden" name="courseID" value="${courseID}"/>
	                   <input type="hidden" name="questionTitle" value="${question.title}"/>
              </td>
                                  
            </tr>
              
            </c:forEach>
       
        </c:otherwise>
     
     </c:choose>  

</table><br/>

</body>
</html>