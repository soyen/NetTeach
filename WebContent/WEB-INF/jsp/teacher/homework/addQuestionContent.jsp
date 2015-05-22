<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
	
		<form action="teacherQuestion.do?method=addQuestion" method="post" name="homeworkForm">
		<input type="hidden" name="courseID" value="${courseID}">
		<table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
              <tr>
                <td align="right" bgcolor="#EBEBEB">题目:</td>
                <td bgcolor="#EBEBEB"><input type="text" name="title" /></td>
              </tr>
              <tr>
                <td align="right" bgcolor="#EBEBEB">答案:</td>
                <td bgcolor="#EBEBEB"><textarea name="content" id="content" cols="72" rows="5"></textarea></td>
              </tr>
              <tr>
                <td align="right" bgcolor="#EBEBEB">分值:</td>
                <td bgcolor="#EBEBEB"><input type="text" name="score" /></td>
              </tr>
              <tr>
                <td colspan="2" align="center" bgcolor="#EBEBEB"><input  class="but" name="submit" type="submit" value="提交"/></td>
              </tr>
          </table>
		</form>
	</body>
</html>
