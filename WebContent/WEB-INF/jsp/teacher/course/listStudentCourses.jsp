<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<tiles:insert page="/WEB-INF/jsp/teacher/layout.jsp" flush="true">  
      <tiles:put name="sidebar" value="/WEB-INF/jsp/teacher/sidebar.jsp"/>
      <tiles:put name="header"  value="/WEB-INF/jsp/teacher/header.jsp"/>   
      <tiles:put name="content" value="/WEB-INF/jsp/teacher/course/listStudentCoursesContent.jsp"/>   
      <tiles:put name="footer"  value="/WEB-INF/jsp/footer.jsp"/>   
 
</tiles:insert>