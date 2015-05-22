<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
   <head>
      <title><bean:message key="title"/></title>
     
   </head>
   <body >
        <%-- One table lays out all of the content --%>
		<table border="0" cellpadding="0" cellspacing="0" style=" background-color:#ebebeb" width="100%">
<tr>
<td colspan="3"  height="82" align="left" valign="bottom">
<tiles:insert attribute="header"/>
</td>
</tr>
<tr>
<td width="238" height="569" valign="top" background="<%=request.getContextPath()%>/images/pic_teacher/left.jpg" style="background-position:top; background-repeat:no-repeat" >
<table width="188" height="75" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="27" align="center">&nbsp;</td>
  </tr>
  <tr>
    <td height="48" align="center">&nbsp;
      <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="125" height="28">
      <param name="movie" value="<%=request.getContextPath()%>/flash/time.swf">
      <param name="wmode" value="transparent">
    </object></td>
  </tr>
</table>
  <tiles:insert attribute="sidebar"/>
</td>
  <td  height="583" style="(src=<%=request.getContextPath()%>/images/pic_admin/bg2.jpg, sizingMethod=scale);
  width:100%;height:585px" valign="top" align="center" colspan="2" nowrap="nowrap"><br> 
 <table width="97%">
<tr>
<td height="162" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=<%=request.getContextPath()%>/images/pic_admin/dfdffd.jpg, sizingMethod=scale); width:100%;height:29px"> &nbsp;&nbsp;<span class="start_title">${user.name}老师，欢迎使用本系统</span></td>
</tr>
</table>

	<table width="96%" height="497" border="1" cellpadding="10" cellspacing="0">
      <tr>
        <td height="495" align="left" valign="top"><tiles:insert attribute="content"/></td>
      </tr>
    </table> 
</td> 
</tr>
<tr>
<td background="<%=request.getContextPath()%>/images/pic_admin/buttom2.jpg" style="background-repeat:no-repeat; background-position:bottom; background-repeat:repeat-x"></td>
<td height="69"  background="<%=request.getContextPath()%>/images/pic_admin/buttom.jpg" style="background-repeat:no-repeat; background-position:bottom"></td>
<td width="20%" background="<%=request.getContextPath()%>/images/pic_admin/buttom2.jpg" style="background-repeat:no-repeat; background-position:bottom; background-repeat:repeat-x;"></td>
<tiles:insert attribute="footer"/>
</tr>
</table>

   </body>
</html>