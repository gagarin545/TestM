<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Parcel for ${parcel.namedivision}</title></head>
  <body>
  <h1>Parcel for ${parcel.namedivision}}</h1>

  <%--@elvariable id="parcel" type=""--%>
  <form:form modelAttribute="parcel">
  <form:hidden path="iddivision"/>
  <table>
    <tr>
          <td>Имя :</td>
          <td><form:input path="namedivision"/></td>
    </tr>
    <tr>
          <td>Imei :</td>
          <td><form:input path="idcity"/></td>
          <td colspan="2"><input type="submit" value="Save Changes"/></td>
     </tr>
  </table>
  </form:form>
  </body>
</html>