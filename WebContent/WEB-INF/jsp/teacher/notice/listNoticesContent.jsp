<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="title"/></title>
   
	    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.3.1.js"></script>
	    
</head>
<body>
<table width="700" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="30"><a class="but" href="queryNotice.do">查询</a></td>
  </tr>
  <tr>
    <td><table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
      <thead>
        <tr>
          <th width="157" height="30" align="left" bgcolor="#EBEBEB">公告标题</th>
          <th width="520" height="30" align="left" bgcolor="#EBEBEB">内容</th>
        </tr>
      </thead>
      <c:choose>
        <c:when test="${empty pagemodel.list}">
          <tr>
            <td height="30" colspan="3" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="notice" items="${pagemodel.list}">
            <tr >
              <td height="30" align="left" bgcolor="#EBEBEB"><a href="teacherNotice.do?method=findNotice&id=${notice.id}">${notice.title}</a></td>
              <td height="30" align="left" bgcolor="#EBEBEB">${notice.createTime}</td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
    </table></td>
  </tr>
  <tr>
    <td height="30" align="right"><a class="but" href="teacherNotice.do?method=listNotice&pageNo=${pagemodel.topPageNo}&pageSize=${pagemodel.pageSize}">首页</a>&nbsp;<a class="but" href="teacherNotice.do?method=listNotice&pageNo=${pagemodel.previousPageNo}&pageSize=${pagemodel.pageSize}">前一页</a>&nbsp;<a class="but" href="teacherNotice.do?method=listNotice&pageNo=${pagemodel.nextPageNo}&pageSize=${pagemodel.pageSize}">后一页</a>&nbsp;<a class="but" href="teacherNotice.do?method=listNotice&pageNo=${pagemodel.bottomPageNo}&pageSize=${pagemodel.pageSize}">尾页</a></td>
  </tr>
</table>

</body>
</html>