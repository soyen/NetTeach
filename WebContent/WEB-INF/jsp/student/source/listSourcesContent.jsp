<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="title"/></title>
</head>
<body>

<table width="701" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
	
	<table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">

          <tr>
             <td height="30" bgColor="#EBEBEB" ><strong>资源名称</strong></td>  
   </tr>
     <c:choose>
        <c:when test="${empty pagemodel.list}">
           <tr>
              <td height="20" colspan="3" bgcolor="#EBEBEB">没有符合条件数据</td>
          </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="source" items="${pagemodel.list}">
            <tr >
                <td height="20" bgcolor="#EBEBEB"><a href="studentSource.do?method=download&id=${source.id}">${source.fileName }</a></td>
            </tr>
            </c:forEach>
        </c:otherwise>
     </c:choose>  
</table>	</td>
  </tr>
  <tr>
    <td height="30" align="right"><a class="but" href="studentSource.do?method=listSource&pageNo=${pagemodel.topPageNo}&pageSize=${sourceForm.pageSize}">首页</a>&nbsp;<a class="but" href="studentSource.do?method=listSource&pageNo=${pagemodel.previousPageNo}&pageSize=${sourceForm.pageSize}">前一页</a>&nbsp;<a class="but" href="studentSource.do?method=listSource&pageNo=${pagemodel.nextPageNo}&pageSize=${sourceForm.pageSize}">后一页</a>&nbsp;<a class="but" href="studentSource.do?method=listSource&pageNo=${pagemodel.bottomPageNo}&pageSize=${sourceForm.pageSize}">尾页</a></td>
  </tr>
</table>


</body>
</html>