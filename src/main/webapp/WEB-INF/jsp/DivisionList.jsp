<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Cписок отделов</title></head>
  <body>
  <h1>Cписок отделов</h1>
  <ul>
    <c:forEach items="${parcels}" var="parcel">
      <li><a href="/incident/${parcel.iddivision}"> <b>${parcel.namedivision}</b>,  ;<b>${parcel.idcity}</b> </a>
    </c:forEach>
  </ul>
  </body>
</html>