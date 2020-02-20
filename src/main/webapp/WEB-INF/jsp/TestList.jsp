<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список активных нарядов</title></head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <body>
  <h3>Тест по логину ${test.service}</h3>
  <ul>
      <span>Логин       -  </span><c:out value="${test.service}"/><br>
      <span>Ip-address  -  </span><c:out value="${test.ip_address}"/><br>

    <c:if test="${test.profil != null}">
        <span>Слот        -  </span><c:out value="${test.port}"/><br>
        <span>Порт        -  </span><c:out value="${test.slot}"/><br>
        <span>Профиль           </span><c:out value="${test.profil}"/><br>
        <span>Инициализации     </span><c:out value="${test.init_count}"/><br>
        <span>Сигнал/шум        </span><c:out value="${test.snr_out}"/>  -  <c:out value="${test. snr_in}"/><br>
        <span>Затухание линии   </span>-  <c:out value="${test.l_Attenuation_out}"/>      -  <c:out value="${test.l_Attenuation_in}"/><br>
        <span>Затухание сигнала </span>-  <c:out value="${test.s_Attenuation_out}"/>      -  <c:out value="${test.s_Attenuation_in}"/><br>
        <span>Мощность      </span><c:out value="${test.power_out}"/>  -  <c:out value="${test.power_in}"/><br>
      <span>Скорость<br>
          предыдущая      </span><c:out value="${test.v_previous_out}"/>     -  <c:out value="${test.v_previous_in}"/><br>
        <span>текущая         </span><c:out value="${test.v_current_out}"/>      -  <c:out value="${test.v_current_in}"/><br>
        <span>максимальная    </span><c:out value="${test.v_max_out}"/>          -  <c:out value="${test.v_max_in}"/>
    </c:if>
    <c:if test="${test.profil == null}">
        <span>Слот        -  </span><c:out value="${test.slot}"/><br>
        <span>Порт        -  </span><c:out value="${test.port}"/><br>
        <span>Ont           -  </span><c:out value="${test.ont}"/><br>
        <span>  Статус      - </span> <c:out value="${test.status}"/><br>
        <span>Описание      -  </span><c:out value="${test.description}"/><br>
        <span>Сер.номер     -  </span><c:out value="${test.sn}"/><br>
        <span>Кодовое слово -  </span><c:out value="${test.passwd}"/><br>
        <span>Ont версия    -  </span><c:out value="${test.ontVersion}"/><br>
        <span>Расстояние    -  </span><c:out value="${test.distance}"/><br>
        <span>Мощность      -  </span><c:out value="${test.power_in}"/><br>
        <span>Статус <br>
            порт(<c:out value="${test.v_port1}"/>)   - </span> <c:out value="${test.status_port1}"/><br>
        <span>порт(<c:out value="${test.v_port2}"/>)   - </span>  <c:out value="${test.status_port2}"/><br>
        <span>порт(<c:out value="${test.v_port3}"/>)   -  </span><c:out value="${test.status_port3}"/><br>
        <span>порт(<c:out value="${test.v_port4}"/>)   -  </span><c:out value="${test.status_port4}"/><br>
        <span>Mac.адрес     -  </span><c:out value="${test.macAddress}"/><br>
        <span>Vlan          -  </span><c:out value="${test.vlans}"/><br>
    </c:if>
  </ul>
  <script>
      $("span").css( "color", "blue").css("font-weight", "bold");
  </script>
  </body>
</html>