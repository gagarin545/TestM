<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список работников</title></head>
  <body>
  <h1>Список работников</h1>
  <ul>
    <c:forEach items="${parcels}" var="parcel">
      <li><a href="/workers/${parcel.idworker}"> &nbsp;<b>${parcel.name}</b>, &nbsp;<b>${parcel.imei}</b>&nbsp; <b>${parcel.iddivision}</b></a>
    </c:forEach>
  </ul>
  </body>
</html>