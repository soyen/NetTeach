<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
 
<tiles:insert page="/WEB-INF/jsp/admin/layout.jsp" flush="true">  
      <tiles:put name="sidebar" value="/WEB-INF/jsp/admin/sidebar.jsp"/>
      <tiles:put name="header"  value="/WEB-INF/jsp/admin/header.jsp"/>   
      <tiles:put name="content" value="/WEB-INF/jsp/admin/notice/queryNoticeContent.jsp"/>   
      <tiles:put name="footer"  value="/WEB-INF/jsp/footer.jsp"/>   
 
</tiles:insert>