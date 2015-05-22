<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
	</head>
	<body>
		<form action="studentHomework.do?method=doHomework" method="post" name="answerForm">
		<input type="hidden" name="questionID" value="${questionID}">
		<input type="hidden" name="courseID" value="${courseID}">
	    <table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td width="50" align="right" bgcolor="#EBEBEB"><strong>题目</strong></td>
            <td width="627" bgcolor="#EBEBEB">:
            <input name="title" type="text" value="${questionTitle}" size="75" maxlength="100"/></td>
          </tr>
          <tr>
            <td align="right" bgcolor="#EBEBEB"><strong>解答</strong></td>
            <td bgcolor="#EBEBEB">:
            <textarea name="content" id="content" cols="75" rows="10"></textarea></td>
          </tr>
          <tr>
            <td colspan="2" align="center" bgcolor="#EBEBEB"><input  class="but" type="submit" value="提交"/></td>
          </tr>
        </table>
		</form>
	</body>
</html>
