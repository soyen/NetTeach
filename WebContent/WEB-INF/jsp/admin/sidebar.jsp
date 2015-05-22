<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/text.css">
<table align="left">
<tr>
<td height="60"><html:link page="/admin/notice/adminNotice.do?method=listNotice&amp;pageNo=1&amp;pageSize=5&amp;queryStr="><img src="<%=request.getContextPath()%>/images/pic_admin/1.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/admin/course/adminCourse.do?method=listCourse&pageNo=1&pageSize=3&amp;queryStr="><img src="<%=request.getContextPath()%>/images/pic_admin/2.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/admin/source/adminSource.do?method=listSource&pageNo=1&pageSize=10&amp;queryStr="><img src="<%=request.getContextPath()%>/images/pic_admin/3.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/admin/department/adminDepartment.do?method=listDepartment&pageNo=1&pageSize=2&amp;queryStr="><img src="<%=request.getContextPath()%>/images/pic_admin/4.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/admin/classes/listClass.do"><img src="<%=request.getContextPath()%>/images/pic_admin/5.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/admin/teacher/listTeacher.do"><img src="<%=request.getContextPath()%>/images/pic_admin/6.jpg" border="0"/></html:link></td>
</tr>
<tr>
<td height="60"><html:link page="/admin/student/listStudent.do"><img src="<%=request.getContextPath()%>/images/pic_admin/7.jpg" border="0"/></html:link></td>
</tr>
</table>