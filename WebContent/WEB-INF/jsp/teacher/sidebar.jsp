<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/text.css">
<table align="center">
<tr>
<td height="60"><html:link page="/teacher/notice/teacherNotice.do?method=listNotice&pageNo=1&pageSize=5"><img src="<%=request.getContextPath()%>/images/pic_teacher/1.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/teacher/course/teacherCourse.do?method=listCourse"><img src="<%=request.getContextPath()%>/images/pic_teacher/2.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/teacher/course/teacherCourse.do?method=listStudentCourse"><img src="<%=request.getContextPath()%>/images/pic_teacher/3.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/teacher/source/teacherSource.do?method=listSource&pageNo=1&pageSize=5"><img src="<%=request.getContextPath()%>/images/pic_teacher/4.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/teacher/homework/teacherQuestion.do?method=addListCourse"><img src="<%=request.getContextPath()%>/images/pic_teacher/5.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/teacher/homework/teacherQuestion.do?method=listCourse"><img src="<%=request.getContextPath()%>/images/pic_teacher/6.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/teacher/info/teacherInfo.do?method=find"><img src="<%=request.getContextPath()%>/images/pic_teacher/7.jpg" border="0"/></html:link></td>
</tr>
</table>
