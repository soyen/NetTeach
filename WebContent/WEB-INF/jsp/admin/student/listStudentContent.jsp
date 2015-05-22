<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   <script type="text/javascript">
  function check5()
  {
  document.getElementById("editStudent").style.display="block";
  }
  </script>
</head>
<body onLoad="fillDepartment();">
<table width="700" border="0" cellpadding="5" cellspacing="0">
       <tr>
         <td><a class="but" href="adminStudent.do?method=beforeAddStudent">添加学生</a>&nbsp;
<a class="but" href="queryStudent.do">查询</a></td>
       </tr>
       <tr>
         <td>请选择部门:<select id="selectDept" onChange="displayClassList(this)"></select>
           &nbsp;&nbsp;&nbsp;

请选择班级:
<select id="selectClass" onChange="displayStudentTable(this)"></select></td>
       </tr>
       <tr>
         <td><table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" >
          <tr>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>用户名</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>密码</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>学生学号</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>学生姓名</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>性别</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>专业</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>信息</strong></td>
             <td height="30" align="center" bgcolor="#EBEBEB"><strong>操作</strong></td>
       </tr>
           
  <tbody id="studentbody">
    <tr id="pattern" style="display:none;">
      <td height="30" align="left" bgcolor="#EBEBEB">
        <span id="Tableusername">username</span>      </td>  
      <td height="30" align="left" bgcolor="#EBEBEB">
        <span id="Tablepassword">password</span>      </td> 
      <td height="30" align="left" bgcolor="#EBEBEB">
        <span id="TablestudentNo">studentNo</span>      </td> 
      <td height="30" align="left" bgcolor="#EBEBEB">
        <span id="Tablename">name</span>      </td> 
      <td height="30" align="left" bgcolor="#EBEBEB">
        <span id="Tablesex">sex</span>      </td> 
      <td height="30" align="left" bgcolor="#EBEBEB">
        <span id="Tablemajor">major</span>      </td> 
      <td height="30" align="left" bgcolor="#EBEBEB">
        <span id="Tableinfo">info</span>      </td> 
      
      <td height="30" align="center" bgcolor="#EBEBEB">
      <input id="edit" class="but"  type="button" value="修改" onClick="editStudentClicked(this.id);check5()"/>
      &nbsp;      
      <input id="delete" class="but" type="button" value="删除" onClick="deleteStudentClicked(this.id)"/>      </td>
    </tr>
  </tbody>
</table></td>
       </tr>
</table>
<div id="editStudent" style="display: none">
<h3>编辑学生</h3>
<table class="plain"  width="700">
  <tr>
    <td align="right" width="40%">用户名:</td>
    <td align="left"><input id="username" type="text" size="30"/></td> 
  </tr>
  <tr>
    <td align="right">密码:</td>
    <td align="left"><input id="password" type="text" size="30"/></td>
  </tr>
  <tr>
    <td align="right">学生编号:</td>
    <td align="left"><input id="studentNo" type="text" size="30"/></td> 
    </tr>
    <tr>
    <td align="right">学生姓名:</td>
    <td align="left"><input id="name" type="text" size="30"/></td> 
    </tr>
    <tr>
    <td align="right">学生性别:</td>
    <td align="left"><input id="sex" type="text" size="30"/></td> 
    </tr>
    <tr>
    <td align="right">学生专业:</td>
    <td align="left"><input id="major" type="text" size="30"/></td>  
    </tr> 
    <tr>
    <td align="right">学生信息:</td>
    <td align="left"><input id="info" type="text" size="30"/></td>
   </tr>
  
  <tr>
    <td colspan="2" align="right">
      <small>(ID=<span id="id">-1</span>)</small>
      <input type="button"  class="but" value="保存" onClick="writeStudent()" />
      <input type="button"  class="but" value="清除" onClick="clearStudent()" />
   </td>
  </tr>
</table>
</div>

</body>
</html>

