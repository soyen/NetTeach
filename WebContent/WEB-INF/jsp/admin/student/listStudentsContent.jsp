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
	    <script type="text/javascript">
	      
        </script>
</head>
<body>
<table width="700" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="30"><a class="but" href="adminStudent.do?method=beforeAddStudent">添加学生</a>&nbsp;<a class="but" href="queryStudent.do">查询</a>&nbsp;<a  class="but" href="adminStudent.do?method=listStudent&amp;pageNo=1&amp;pageSize=5&amp;queryStr=">重置</a></td>
  </tr>
  <tr>
    <td><table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">

          <thead>
            <tr>
             <th width="127" height="30" align="left" bgcolor="#EBEBEB">用户名</th>
             <th width="127" height="30" align="left" bgcolor="#EBEBEB">密码</th>
             <th width="127" height="30" align="left" bgcolor="#EBEBEB">学生学号</th>
             <th width="127" height="30" align="left" bgcolor="#EBEBEB">学生姓名</th>
             <th width="127" height="30" align="left" bgcolor="#EBEBEB">性别</th>
             <th width="127" height="30" align="left" bgcolor="#EBEBEB">专业</th>
             <th width="127" height="30" align="left" bgcolor="#EBEBEB">信息</th>
             <th width="127" height="30" bgcolor="#EBEBEB">操作</th>
            </tr>     
        </thead>
     <c:choose>
        <c:when test="${empty pagemodel.list}">
           <tr>
              <td height="30" colspan="8" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="student" items="${pagemodel.list}">
            <tr >
                <td width="127" height="30" align="left" bgcolor="#EBEBEB" >${student.username}</td>
                <td width="127" height="30" align="left" bgcolor="#EBEBEB" >${student.password}</td>
                <td width="127" height="30" align="left" bgcolor="#EBEBEB" >${student.studentNo}</td>
                <td width="127" height="30" align="left" bgcolor="#EBEBEB" >${student.name}</td>
                <td width="127" height="30" align="left" bgcolor="#EBEBEB" >${student.sex}</td>
                <td width="127" height="30" align="left" bgcolor="#EBEBEB" >${student.major}</td>
                <td width="127" height="30" align="left" bgcolor="#EBEBEB" >${student.info}</td>
                
                <td width="127" height="30" bgcolor="#EBEBEB"><a class="but" href="adminStudent.do?method=findStudent&id=${student.id }" onClick="return confirm('确认进入编辑？');">编辑</a>&nbsp;<a class="but" href="adminStudent.do?method=deleteStudent&id=${student.id }" onClick="return confirm('确认删除？');">删除</a></td>
              </tr>
            </c:forEach>
        </c:otherwise>
     </c:choose>  
</table></td>
  </tr>
  <tr>
    <td height="30" align="right"><a class="but" href="adminStudent.do?method=listStudent&pageNo=${pagemodel.topPageNo}&pageSize=${pagemodel.pageSize}">首页</a>&nbsp;<a href="adminStudent.do?method=listStudent&pageNo=${pagemodel.previousPageNo}&pageSize=${pagemodel.pageSize}">前一页</a>&nbsp;<a class="but" href="adminStudent.do?method=listStudent&pageNo=${pagemodel.nextPageNo}&pageSize=${pagemodel.pageSize}">后一页</a>&nbsp;<a class="but" href="adminStudent.do?method=listStudent&pageNo=${pagemodel.bottomPageNo}&pageSize=${pagemodel.pageSize}">尾页</a></td>
  </tr>
</table>
</body>
</html>