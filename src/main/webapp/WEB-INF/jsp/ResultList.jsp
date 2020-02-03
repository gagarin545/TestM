<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список горящих и просроченных нарядов</title></head>
  <body>
  <h1>Список горящих и просроченных нарядов</h1>
  <ul>
    <c:forEach items="${parcels}" var="parcel">
      <li><a href="/result/${parcel.date}"> - <b>${parcel.date}</b>, - <b>${parcel.namedivision}</b>, - <b>${parcel.kvcount}</b>, - <b>${parcel.skvcount}</b> </a>
    </c:forEach>
  </ul>
  </body>
</html>