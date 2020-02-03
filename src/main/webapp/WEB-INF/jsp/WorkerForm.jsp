<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Parcel for ${parcel.name}</title></head>
  <body>
  <h1>Parcel for ${parcel.name}</h1>

  <%--@elvariable id="parcel" type=""--%>
<script language="JavaScript1.5">
    function( int[] s)
</script>
  <form:form modelAttribute="parcel">
  <form:hidden path="idworker"/>
  <table>
    <tr>
          <td>Имя :</td>
          <td><form:input path="name"/></td>
    </tr>
    <tr>
          <td>Imei :</td>
          <td><form:input path="imei"/></td>
     </tr>
      <tr>
          <td>Отделы :</td>
          <td><form:input path="iddivision"/></td>
      </tr>
     <tr>
          <td colspan="3"><input type="submit" value="Save Changes"/></td>
     </tr>
  </table>
  </form:form>
  </body>
</html>