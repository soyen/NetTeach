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
  document.getElementById("editTeacher").style.display="block";
  }
  </script>
</head>
<style type="text/css">
a{ text-decoration:none}
a:hover{ color:#999999}
</style>
<body onLoad="fillDepartment();">

     <table width="700" border="0" cellpadding="5" cellspacing="0">
       <tr>
         <td height="30"><a class="but" href="adminTeacher.do?method=beforeAddTeacher">添加教师</a>&nbsp;<a class="but" href="queryTeacher.do">查询</a></td>
       </tr>
       <tr>
         <td height="30">请选择部门:&nbsp;&nbsp;
           <select id="selectDept" onChange="displayTeacherTable(this)">
<option value="123">1212</option>
</select></td>
       </tr>
       <tr>
         <td><table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
           <tr>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>用户名</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>密码</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>教师编号</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>教师姓名</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>性别</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>职称</strong></td>
             <td height="30" align="left" bgcolor="#EBEBEB"><strong>简介</strong></td>
             <td height="30" align="center" bgcolor="#EBEBEB"><strong>操作</strong></td>
           </tr>
           <tbody id="teacherbody">
             <tr id="pattern" style="display:none;">
               <td height="30" bgcolor="#EBEBEB"><span id="Tableusername">username</span> </td>
               <td height="30" bgcolor="#EBEBEB"><span id="Tablepassword">password</span> </td>
               <td height="30" bgcolor="#EBEBEB"><span id="TableteacherNo">teacherNo</span> </td>
               <td height="30" bgcolor="#EBEBEB"><span id="Tablename">name</span> </td>
               <td height="30" bgcolor="#EBEBEB"><span id="Tablesex">sex</span> </td>
               <td height="30" bgcolor="#EBEBEB"><span id="Tabletitle">title</span> </td>
               <td height="30" bgcolor="#EBEBEB"><span id="Tableinfo">info</span> </td>
               <td height="30" align="center" bgcolor="#EBEBEB"><input  class="but" name="button" type="button" id="edit" onClick="editTeacherClicked(this.id);check5()" value="修改"/>
                   <input class="but" name="button2" type="button" id="delete" onClick="deleteTeacherClicked(this.id)" value="删除"/>
               </td>
             </tr>
           </tbody>
         </table></td>
       </tr>
</table>
<div id="editTeacher" style="display: none">
<h3>编辑教师</h3>
<table class="plain" width="700">
  <tr>
    <td align="right" width="40%">用户名:</td>
    <td align="left"><input id="username" type="text" size="30"/></td> 
  </tr>
  <tr>
    <td align="right">密码:</td>
    <td align="left"><input id="password" type="text" size="30"/></td>
  </tr>
  <tr>
    <td align="right">教师编号:</td>
    <td align="left"><input id="teacherNo" type="text" size="30"/></td> 
    </tr>
    <tr>
    <td align="right">教师姓名:</td>
    <td align="left"><input id="name" type="text" size="30"/></td> 
    </tr>
    <tr>
    <td align="right">教师性别:</td>
    <td align="left"><input id="sex" type="text" size="30"/></td> 
    </tr>
    <tr>
    <td align="right">教师职称:</td>
    <td align="left"><input id="title" type="text" size="30"/></td>  
    </tr> 
    <tr>
    <td align="right">教师信息:</td>
    <td align="left"><input id="info" type="text" size="30" /></td>
   </tr>
  
  <tr>
    <td colspan="2" align="right">
      <small>(ID=<span id="id">-1</span>)</small>
      <input type="button" value="保存" onClick="writeTeacher()" style="width:80px; height:24px;"/>
      <input type="button" value="清除" onClick="clearTeacher()" style="width:80px; height:24px;"/>
   </td>
  </tr>
</table>
</div>

</body>
</html>

