<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
	  <html:errors/>
		<form action="teacherCourse.do?method=addCourse" method="post" enctype="multipart/form-data" >
		  <table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
           <tr>
             <td width="88" height="30" align="right" bgcolor="#EBEBEB">课程名称 :             </td>
             <td width="589" height="30" bgcolor="#EBEBEB"><input type="text" name="courseName"/></td>
           </tr>
           <tr>
             <td height="30" align="right" bgcolor="#EBEBEB">信息: </td>
             <td height="30" bgcolor="#EBEBEB"><textarea name="info" cols="75" rows="5"></textarea></td>
           </tr>
           <tr>
             <td height="30" align="right" bgcolor="#EBEBEB">附件:</td>
             <td height="30" bgcolor="#EBEBEB"><input type="file" name="fileContent"/></td>
           </tr>
           <tr>
             <td height="30" colspan="2" align="center" bgcolor="#EBEBEB"><input  class="but" name="submit" type="submit" value="提交"/></td>
            </tr>
         </table>
		</form>
	</body>
</html>
