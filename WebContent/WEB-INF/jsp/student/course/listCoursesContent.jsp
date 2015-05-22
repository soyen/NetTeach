<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><bean:message key="title"/></title>
  <script type='text/javascript' src="<%=request.getContextPath()%>/dwr/engine.js"> </script>
  <script type='text/javascript' src="<%=request.getContextPath()%>/dwr/util.js"> </script>
  <script type='text/javascript' src="<%=request.getContextPath()%>/dwr/interface/DwrService.js"> </script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/netTeach.js"></script> 
</head>

<body onLoad="fillDepartment();">



 <table width="402" height="32" border="0" align="left" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
   <tr>
     <td width="100" height="30" bgcolor="#EBEBEB">请选择部门:</td>
     <td width="100" height="30" bgcolor="#EBEBEB"><select id="selectDept" onChange="displayTeacher(this)"></select></td>
     <td width="100" height="30" bgcolor="#EBEBEB">请选择教师:</td>
     <td width="100" height="30" bgcolor="#EBEBEB"><select id="selectTeacher" onChange="displayCourse(this)"></select> </td>

   </tr>
</table>

 <br>
 <br>
 <br>
 <table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
   <thead>
          <tr>
             <th width="243" height="20" align="left" bgcolor="#EBEBEB">课程名称</th>
             <th width="311" height="20" align="left" bgcolor="#EBEBEB">课程信息</th>
			 <th width="136" height="20" bgcolor="#EBEBEB">操作</th>            
     </tr>
   </thead>
  <tbody id="coursebody">
    <tr id="pattern" style="display:none;">
      <td height="20" align="left" bgcolor="#EBEBEB">
        <span id="tableCourseName">courseName</span>      </td>
      <td height="20" align="left" bgcolor="#EBEBEB"><span id="tableInfo">Info</span></td>
      <td height="20" align="center" bgcolor="#EBEBEB">
      <input id="add"  class="but" type="button" value="添加" onClick="addCourseClicked(${sessionScope.studentId},this.id)"/>      </td>
    </tr>
  </tbody>
</table>
</body>
</html>