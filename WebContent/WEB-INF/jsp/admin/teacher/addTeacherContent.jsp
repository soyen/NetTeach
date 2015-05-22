<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html> 
	<head>
		<title><bean:message key="title"/></title>
		
	    <script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.3.1.js"></script>
	    <script type="text/javascript">
    //<![CDATA[
$(function(){
		//如果是必填的，则加红星标识.
		$("form :input.required").each(function(){
			var $required = $("<strong class='high'> *</strong>"); //创建元素
			$(this).parent().append($required); //然后将它追加到文档中
		});
		 //文本框失去焦点后
		$('form :input').blur(function(){  // 为表单元素添加失去焦点事件
			 var $parent = $(this).parent();
			 $parent.find(".formtips").remove();
			 //验证用户名
			 if( $(this).is('#username') ){
					if( this.value==""){
						var errorMsg = '请输入用户名';
						$parent.append('<span class="formtips onError">'+errorMsg+'</span>');
					}else{
						var okMsg =	'输入正确.';
						$parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
					}
			 }
			 if( $(this).is('#password') ){
					if( this.value==""){
						var errorMsg = '请输入密码';
						$parent.append('<span class="formtips onError">'+errorMsg+'</span>');
					}else{
						var okMsg =	'输入正确.';
						$parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
					}
			 }
			 
		})
		//提交，最终验证。
		 $('#send').click(function(){
				$("form :input.required").trigger('blur');
				var numError = $('form .onError').length;
				if(numError){
					return false;
				} 
				alert("进行添加");
		 });

		//重置
		 $('#res').click(function(){
			$(".formtips").remove(); 
		 });
})
//]]>
    </script>
	</head>
	
	<body>
	<html:errors/>
	<form action="adminTeacher.do?method=addTeacher" name="teacherForm" method="post">
	<table width="400" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="department">部门:</label>
              &nbsp;
              <c:choose >
                <c:when test="${empty deptList}"> </c:when>
                <c:otherwise>
                  <select name="deptList">
                    <c:forEach items="${deptList}" var="department">
                      <option value="${department.id}">${department.departmentName}</option>
                    </c:forEach>
                  </select>
                </c:otherwise>
              </c:choose>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="username">用户名:</label>
              &nbsp;
              <input name="username" type="text" id="username" class="required"/>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="password">密码:</label>
              &nbsp;
              <input name="password" type="password" id="password" class="required"/>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="name">教师姓名:</label>
              &nbsp;
              <input name="name" type="text" id="name"/>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="sex">性别:</label>
              &nbsp;
              <input name="sex" type="text" id="sex"/>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="title">职称:</label>
              &nbsp;
              <input name="title" type="text" id="title"/>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="info">简介:</label>
              &nbsp;
              <input name="info" type="text" id="info" />
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
              <label for="teacherNo">教师编号:</label>
              &nbsp;
              <input name="teacherNo" type="text" id="teacherNo" />
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB">
              <div class="sub">
                <input class="but" name="submit" type="submit" id="send" value="提交"/>
              </div>
            </td>
          </tr>
      </table></form>
	</body>
</html>
