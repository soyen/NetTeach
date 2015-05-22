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
			 if( $(this).is('#className') ){
					if( this.value==""){
						var errorMsg = '请输入班级名称';
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
				alert("修改成功");
		 });

		//重置
		 $('#res').click(function(){
			$(".formtips").remove(); 
		 });
})
//]]>
    </script>
		
	</head>
	<body><form action="adminStudent.do?method=modifyStudent&id=${student.id}" name="studentForm" method="post">
		<table width="400" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td bgcolor="#EBEBEB"><div class="int">
		      <label for="username">用户名:</label>
		      &nbsp;
		      <input name="username" type="text" id="username" class="required" value="${student.username}"/>
		    </div></td>
          </tr>
          <tr>
            <td bgcolor="#EBEBEB"><div class="int">
              <label for="password">密码:</label>
              &nbsp;
              <input name="password" type="password" id="password" class="required" value="${student.password}"/>
            </div></td>
          </tr>
          <tr>
            <td bgcolor="#EBEBEB"><div class="int">
              <label for="studentNo">学生学号:</label>
              &nbsp;
              <input name="studentNo" type="text" id="studentNo" value="${student.studentNo}"/>
            </div></td>
          </tr>
          <tr>
            <td bgcolor="#EBEBEB"><div class="int">
              <label for="name">学生姓名:</label>
              &nbsp;
              <input name="name" type="text" id="name" value="${student.name}"/>
            </div></td>
          </tr>
          <tr>
            <td bgcolor="#EBEBEB"><div class="int">
              <label for="sex">性别:</label>
              &nbsp;
              <input name="sex" type="text" id="sex" value="${student.sex}"/>
            </div></td>
          </tr>
          <tr>
            <td bgcolor="#EBEBEB"><div class="int">
              <label for="major">专业:</label>
              &nbsp;
              <input name="major" type="text" id="major" value="${student.major}"/>
            </div></td>
          </tr>
          <tr>
            <td bgcolor="#EBEBEB"><div class="int">
              <label for="info">信息:</label>
              &nbsp;
              <textarea name="info" cols="42" rows="5" id="info">${student.info}</textarea>
            </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB">
              <div class="sub">
                <input name="submit" type="submit" id="send" value="提交"/></div>            </td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><a href="adminStudent.do?method=listStudent&amp;pageNo=${studentForm.pageNo }&amp;pageSize=${studentForm.pageSize }">返回</a></td>
          </tr>
      </table>
	</form>
	</body>
</html>
