<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/text.css">
<table align="center">
<tr>
<td height="55"><html:link page="/student/notice/studentNotice.do?method=listNotice&pageNo=1&pageSize=5&queryStr="><img src="<%=request.getContextPath()%>/images/pic_student/1.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="55"><html:link page="/student/source/studentSource.do?method=listSource&pageNo=1&pageSize=5&queryStr="><img src="<%=request.getContextPath()%>/images/pic_student/2.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="55"><html:link page="/student/course/listAllCourse.do"><img src="<%=request.getContextPath()%>/images/pic_student/3.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="55"><html:link page="/student/course/studentCourse.do?method=listCourse"><img src="<%=request.getContextPath()%>/images/pic_student/4.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="55"><html:link page="/student/homework/studentHomework.do?method=listCourse"><img src="<%=request.getContextPath()%>/images/pic_student/5.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="55"><html:link page="/student/homework/studentHomework.do?method=listAnswer"><img src="<%=request.getContextPath()%>/images/pic_student/6.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="55"><html:link page="/student/info/studentInfo.do?method=find"><img src="<%=request.getContextPath()%>/images/pic_student/7.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="55"><html:link page="/student/demo/listDemo.do"><img src="<%=request.getContextPath()%>/images/pic_student/8.jpg" border="0"/></html:link></td>
</tr>
</table>
 