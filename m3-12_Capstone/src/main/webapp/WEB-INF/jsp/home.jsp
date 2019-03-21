<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="common/header.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="parks">

	<c:forEach var="park" items="${parks}">

		<div class="contentParks">
			<div class="imageHome">
			<c:url var="detailUrl" value="/parkDetail">
				<c:param name="parkCode" value="${park.parkCode}"/>
				</c:url>
			<a href="${detailUrl}">
			<img src="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />
			</a>
			</div>
			<div class="descriptionHome">
			<div class="parkName">
			<c:out value="${park.parkName}"/>
			</div>
			<div>
			<c:out value="${park.state}"/>
			</div>
			<br>
			<div>
			<c:out value="${park.parkDescription }" />
			</div>
			</div>
		</div>

	</c:forEach>
</div>



<%@include file="common/footer.jsp"%>