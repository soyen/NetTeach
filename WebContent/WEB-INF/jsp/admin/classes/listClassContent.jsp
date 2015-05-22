<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 

  <script type='text/javascript' src="<%=request.getContextPath()%>/dwr/engine.js"> </script>
  <script type='text/javascript' src="<%=request.getContextPath()%>/dwr/util.js"> </script>
  <script type='text/javascript' src="<%=request.getContextPath()%>/dwr/interface/DwrService.js"> </script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/netTeach.js"></script> 
  <script type="text/javascript">
  function check5()
  {
  document.getElementById("editClass").style.display="block";
  }
  </script>
<body onLoad="fillDepartment();">
     <table width="700" border="0" cellpadding="5" cellspacing="0">
       <tr>
         <td height="30" colspan="2"><a class="but" href="adminClasses.do?method=beforeAddClasses">添加班级</a>&nbsp;<a class="but" href="queryClasses.do">查询</a></td>
       </tr>
       <tr>
         <td width="84" height="30">请选择系:</td>
         <td width="616" height="30"><select id="selectDept" onChange="displayClasses(this);"></select></td>
       </tr>
       <tr>
         <td colspan="2"><table width="712" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <thead>
          <tr>
             <th width="219" bgcolor="#EBEBEB">班级名称</th>
             <th width="227" bgcolor="#EBEBEB">班级人数</th> 
             <th width="220" bgcolor="#EBEBEB">操作</th>     
           </tr>
           </thead>
  <tbody id="classbody">
    <tr id="pattern" style="display:none;">
      <td bgcolor="#EBEBEB">
        <span id="TableclassName">className</span>      </td>  
      <td bgcolor="#EBEBEB">
        <span id="Tablecapacity">capacity</span>      </td> 
      <td align="center" bgcolor="#EBEBEB">
        <input id="edit"  class="but" type="button" value="修改" onClick="editClassClicked(this.id);check5()"/>&nbsp;
        <input id="delete"  class="but" type="button" value="删除" onClick="deleteClassClicked(this.id)"/>      </td>
    </tr>
  </tbody>
</table></td>
       </tr>
</table>
<div id="editClass" style="display:none">
<h3>编辑班级</h3>
<table class="plain" width="500">
  <tr>
    <td align="right">班级名称:</td>
    <td align="left"><input id="className" type="text" size="30"/></td>
  </tr>
  
  <tr>
    <td colspan="2" align="right">
      <small>(ID=<span id="id">-1</span>)</small>
      <input type="button"  class="but" value="保存" onClick="writeClass()" />
      <input type="button"  class="but" value="清除" onClick="clearClass()"/>
   </td>
  </tr>
</table>
</div>

</body>

