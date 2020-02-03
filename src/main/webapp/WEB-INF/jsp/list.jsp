<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>List of parcels</title></head>
  <body>
  <h1>Parcels list</h1>
  <ul>
    <c:forEach items="${parcels}" var="parcel">
      <li><a href="/pack/${parcel.idworker}"> <b>${parcel.name}</b>, ;<b>${parcel.imei}</b> </a>
    </c:forEach>
  </ul>
  </body>
</html>