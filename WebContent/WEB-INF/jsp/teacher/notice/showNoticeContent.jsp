<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 
	<head>
		<title><bean:message key="title"/></title>
		
	    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.3.1.js"></script>	
	</head>
	<body>
	
	<table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="title">标题:</label>
              <input name="title" type="text" id="title" value="${notice.title}"/>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="content">内容:</label>
              <textarea name="content" cols="85" rows="30" id="content">${notice.content}</textarea>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><a class="but" href="teacherNotice.do?method=listNotice&amp;pageNo=${noticeForm.pageNo }&amp;pageSize=${noticeForm.pageSize }">返回</a></td>
          </tr>
    </table>
	</body>
</html>
