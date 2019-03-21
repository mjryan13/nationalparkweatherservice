<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>



<c:set var="pageTitle" value="Survey Results" />
<%@include file="common/header.jsp"%>



<div class="surveyResults">
<h1>Favorite Parks</h1>

	<c:url var="surveyResults" value="/surveyResults" />
	
<c:forEach var="surveys" items="${surveys}">
	
	<div class="surveyDetails" >
	
		<div class="surveyImage">
			<img src="img/parks/${fn:toLowerCase(surveys.parkCode)}.jpg" />
		</div>
		<div class="countSurvey">
			<c:out value="${surveys.parkName}"/>
			<span style="font-weight: bold; margin-left: 7px"><c:out value="count:${surveys.surveyCount}"/></span>
		</div>
	<br>
	</div>
</c:forEach>
</div>
<%@include file="common/footer.jsp"%>
