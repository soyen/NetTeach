<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<tiles:insert page="/WEB-INF/jsp/student/layout.jsp" flush="true">  
      <tiles:put name="sidebar" value="/WEB-INF/jsp/student/sidebar.jsp"/>
      <tiles:put name="header"  value="/WEB-INF/jsp/student/header.jsp"/>   
      <tiles:put name="content" value="/WEB-INF/jsp/student/homework/listQuestionsContent.jsp"/>   
      <tiles:put name="footer"  value="/WEB-INF/jsp/footer.jsp"/>   
 
</tiles:insert>