<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 

       <!-- <link href="<%=request.getContextPath()%>/style/style.css" rel="stylesheet" type="text/css" /> --> 
	    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.3.1.js"></script>
<table width="726" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td width="716" height="30"><a class="but" href="adminClasses.do?method=beforeAddClasses">添加班级</a>&nbsp;<a class="but" href="queryClasses.do">查询</a></td>
  </tr>
  <tr>
    <td><table width="721" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">

          <thead>
            <tr>
             <th width="248" align="left" bgcolor="#EBEBEB">班级名称</th>
			 <th width="233" align="left" bgcolor="#EBEBEB">班级人数</th>
			 <th width="185" bgcolor="#EBEBEB">操作</th>
            </tr>     
        </thead>
     <c:choose>
        <c:when test="${empty pagemodel.list}">
           <tr>
              <td colspan="3" align="center" bgcolor="#EBEBEB">没有符合条件数据</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="classes" items="${pagemodel.list}">
            <tr >
                <td align="left" bgcolor="#EBEBEB" >${classes.className}</td>
                <td align="left" bgcolor="#EBEBEB" >${classes.capacity}</td>
                <td colspan="4" align="center" bgcolor="#EBEBEB"><a  class="but" href="adminClasses.do?method=findClasses&id=${classes.id }" onclick="return confirm('确认进入编辑？');">编辑</a>&nbsp;<a  class="but" href="adminClasses.do?method=deleteClasses&id=${classes.id }" onclick="return confirm('确认删除？');">删除</a></td>
              </tr>
            </c:forEach>
        </c:otherwise>
     </c:choose>  
</table></td>
  </tr>
  <tr>
    <td align="right"><a class="but" href="adminClasses.do?method=listClasses&pageNo=${pagemodel.topPageNo}&pageSize=${pagemodel.pageSize}">首页</a>&nbsp;<a class="but" href="adminClasses.do?method=listClasses&pageNo=${pagemodel.previousPageNo}&pageSize=${pagemodel.pageSize}">前一页</a>&nbsp;<a class="but" href="adminClasses.do?method=listClasses&pageNo=${pagemodel.nextPageNo}&pageSize=${pagemodel.pageSize}">后一页</a>&nbsp;<a class="but" href="adminClasses.do?method=listClasses&pageNo=${pagemodel.bottomPageNo}&pageSize=${pagemodel.pageSize}">尾页</a>&nbsp;<a class="but" href="listClass.do">返回</a></td>
  </tr>
</table>
       