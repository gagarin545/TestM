<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список активных нарядов</title></head>
  <body>
  <h2>Список активных нарядов</h2>
  <ul>
    <c:forEach items="${parcels}" var="parcel">
      <li>
        <a href="/incident/full/${parcel.n_incident}"> <b>${parcel.n_incident}</b> </a>
        Время визита до - <b>${parcel.decisiontime}</b>
        <a href="/test/${parcel.n_incident}"> (<b>${parcel.service}</b>) </a> <b>${parcel.address}</b>, - <b>${parcel.room}</b>
        <br><b>${parcel.declared}</b> контрольное время - <b>${parcel.controlterm}</b>  Назначен - <b>${parcel.workersEntity.name}</b><br>
      </li>
    </c:forEach>
  </ul>
  </body>
</html>