<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список активных нарядов</title></head>
  <body>
  <h1>Список активных нарядов</h1>
  <ul>
    <c:forEach items="${parcels}" var="parcel">

      <li><a href="/incident/${parcel.n_incident}"> <b>${parcel.address}</b>, - <b>${parcel.room}</b> - <b>${parcel.declared}</b> Время- <b>${parcel.controlterm}</b> Sla- <b>${parsel.controltermsla}</b> - Task- <b>${parsel.controltermslatask}</b></a>
        <script language="JavaScript">
          var dates;
          dates = ${parcel.controlterm};
          document.write( "dat->" +dates);
        </script>
    </c:forEach>
  </ul>
  </body>
</html>