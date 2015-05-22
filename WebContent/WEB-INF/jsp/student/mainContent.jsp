<%@ page contentType="text/html;charset=UTF-8" language="java"  %> 
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="title"/></title>
</head>
<body> 
<table width="764" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">

          <thead>
            <tr>
             <th width="300" height="30" align="left" bgcolor="#EBEBEB">公告标题</th>
            
            </tr>     
        </thead>
     <c:choose>
        <c:when test="${empty noticeList}">
           <tr align="center">
              <td height="30" colspan="3" bgcolor="#EBEBEB">没有符合条件数据</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="notice" items="${noticeList}">
            <tr >
                <td height="30" align="left" bgcolor="#EBEBEB" ><a href="student/notice/studentNotice.do?method=findNotice&id=${notice.id}">${notice.title}</a></td>                                            
              </tr>
            </c:forEach>
        </c:otherwise>
     </c:choose>  
</table>

 
</body>
</html>

