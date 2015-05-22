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
<table width="702" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="30"><a class="but" href="addDepartment.do">添加部门</a>&nbsp;<a class="but" href="queryDepartment.do">查询</a>&nbsp;<a class="but" href="adminDepartment.do?method=listDepartment&amp;pageNo=1&amp;pageSize=10&amp;queryStr=">重置</a></td>
  </tr>
  <tr>
    <td><table width="1000" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
         <thead>
          <tr>
             <th width="231" height="30" align="left" bgcolor="#EBEBEB">部门名称</th>
             <th width="500" height="30" align="left" bgcolor="#EBEBEB">部门介绍</th>
			 <th width="200" height="30" bgcolor="#EBEBEB">操作</th>   
           </tr>
        </thead>
     <c:choose>
        <c:when test="${empty pagemodel.list}">
           <tr>
              <td height="30" colspan="3" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="department" items="${pagemodel.list}">
            <tr >
                <td height="30" align="left" bgcolor="#EBEBEB" >${department.departmentName }</td>
                <td height="30" align="left" bgcolor="#EBEBEB" >${department.introduce}</td>
                <td height="30" colspan="4" align="center" bgcolor="#EBEBEB"><a class="but" href="adminDepartment.do?method=findDepartment&id=${department.id }" onClick="return confirm('确认进入编辑？');">编辑</a>&nbsp;<a class="but" href="adminDepartment.do?method=deleteDepartment&id=${department.id }" onClick="return confirm('确认删除？');">删除</a></td>
              </tr>
            </c:forEach>
        </c:otherwise>
     </c:choose>  
</table></td>
  </tr>
  <tr>
    <td height="30" align="right"><a class="but" href="adminDepartment.do?method=listDepartment&pageNo=${pagemodel.topPageNo}&pageSize=${pagemodel.pageSize}">首页</a>&nbsp;<a class="but" href="adminDepartment.do?method=listDepartment&pageNo=${pagemodel.previousPageNo}&pageSize=${pagemodel.pageSize}">前一页</a>&nbsp;<a class="but" href="adminDepartment.do?method=listDepartment&pageNo=${pagemodel.nextPageNo}&pageSize=${pagemodel.pageSize}">后一页</a>&nbsp;<a class="but" href="adminDepartment.do?method=listDepartment&pageNo=${pagemodel.bottomPageNo}&pageSize=${pagemodel.pageSize}">尾页</a></td>
  </tr>
</table>
</body>
</html>