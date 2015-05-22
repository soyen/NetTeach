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
			 if( $(this).is('#title') ){
					if( this.value==""){
						var errorMsg = '请输入标题';
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
	<body>
		 <form action="adminNotice.do?method=modifyNotice&id=${notice.id}" name="noticeForm" method="post">
		<table width="700" border="0" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC">
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
		      <label for="title">标题:</label>
		      &nbsp;
		      <input name="title" type="text" id="title" class="required" value="${notice.title}"/>
		    </div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EBEBEB"><div class="int">
		       <label for="content">内容:&nbsp;&nbsp;</label>
		       <textarea name="content" cols="75" rows="5" id="content">${notice.content}</textarea>  
		    </div>  </td>
          </tr>
          <tr>
            <td height="30" align="center" bgcolor="#EBEBEB"><div class="sub">
	        <input type="submit" value="提交" class="but" id="send"/></div></td>
          </tr>
          <tr>
            <td height="30" align="center" bgcolor="#EBEBEB"><a class="but" href="adminNotice.do?method=listNotice&amp;pageNo=${noticeForm.pageNo }&amp;pageSize=${noticeForm.pageSize }">返回</a></td>
          </tr>
        </table>
		 </form>
	</body>
</html>
