<%@ page contentType="text/html;charset=UTF-8" language="java"  %> 
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><bean:message key="title"/></title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/jsfiles/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$("ul.menu_body li:even").addClass("alt");
    $('img.menu_head').click(function () {
	$('ul.menu_body').slideToggle('medium');
    });
	$('ul.menu_body li a').mouseover(function () {
	$(this).animate({ fontSize: "14px", paddingLeft: "20px" }, 50 );
    });
	$('ul.menu_body li a').mouseout(function () {
	$(this).animate({ fontSize: "12px", paddingLeft: "10px" }, 50 );
    });
});
</script>

</head>

<body>
<div class="container">
<img src="<%=request.getContextPath()%>/images/pic_student/8.jpg" class="menu_head" />
<ul class="menu_body">
<li><a href="demo1.do">串行加法器</a></li>
<li><a href="demo2.do">单脉冲发生器</a></li>
<li><a href="demo3.do">全加器</a></li>
<li><a href="demo4.do">十进制数加法器</a></li>
<li><a href="demo5.do">同步模4可逆计数器</a></li>
<li><a href="demo6.do">异步模8加1计数器</a></li>
<li><a href="back.do">返回</a></li>
</ul>
</div>

</body>
</html>
