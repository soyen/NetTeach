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
<table width="772" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td width="762" height="30"><a class="but" href="addNotice.do">添加公告</a>&nbsp;<a class="but" href="queryNotice.do">查询</a>&nbsp;<a class="but" href="adminNotice.do?method=listNotice&amp;pageNo=1&amp;pageSize=5&amp;queryStr=">重置</a></td>
  </tr>
  <tr>
    <td><table width="764" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">

          <thead>
            <tr>
             <th width="192" height="30" align="left" bgcolor="#EBEBEB">公告标题</th>
             <th width="334" height="30" align="left" bgcolor="#EBEBEB">内容</th>
             <th width="204" height="30" align="center" bgcolor="#EBEBEB">操作</th>
            </tr>     
        </thead>
     <c:choose>
        <c:when test="${empty pagemodel.list}">
           <tr align="center">
              <td height="30" colspan="3" bgcolor="#EBEBEB">没有符合条件数据</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="notice" items="${pagemodel.list}">
            <tr >
                <td height="30" align="left" bgcolor="#EBEBEB" >${notice.title}</td>
                <td height="30" align="left" bgcolor="#EBEBEB" >${notice.content}</td>
                
                
               <td height="30" align="center" bgcolor="#EBEBEB"><a class="but" href="adminNotice.do?method=findNotice&id=${notice.id }" onClick="return confirm('确认进入编辑？');">编辑</a>&nbsp;<a class="but" href="adminNotice.do?method=deleteNotice&id=${notice.id }" onClick="return confirm('确认删除？');">删除</a></td>
              </tr>
            </c:forEach>
        </c:otherwise>
     </c:choose>  
</table></td>
  </tr>
  <tr>
    <td height="30" align="right">
	<a class="but" href="adminNotice.do?method=listNotice&pageNo=${pagemodel.topPageNo}&pageSize=${pagemodel.pageSize}">首页</a>&nbsp;<a class="but" href="adminNotice.do?method=listNotice&pageNo=${pagemodel.previousPageNo}&pageSize=${pagemodel.pageSize}">前一页</a>&nbsp;<a class="but" href="adminNotice.do?method=listNotice&pageNo=${pagemodel.nextPageNo}&pageSize=${pagemodel.pageSize}" >后一页</a>&nbsp;<a class="but" href="adminNotice.do?method=listNotice&pageNo=${pagemodel.bottomPageNo}&pageSize=${pagemodel.pageSize}" >尾页</a></td>
  </tr>
</table>
</body>
</html>