<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="parks">






	<c:forEach var="park" items="${parks}">

		<div class="parkDetail">
			<div class="parkImage">


				<img src="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />

			</div>
			<br>
			<div class="parkName">
				<c:out value="${park.parkName}" />
			</div>
			<div>
				<c:out value="${park.state}" />
			</div>
			<br>
			<div>
				<c:out value="${park.parkDescription }" />
			</div>
			<br>
			<div>
				<span style="font-weight: bold"><c:out value="Climate:" /></span>
				<c:out value="${park.climate }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out value="Acreage:" /></span>
				<c:out value="${park.acreage }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out value="Elevation:" /></span>
				<c:out value="${park.elevationInFeet }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out
						value="Number of Campsites:" /></span>
				<c:out value="${park.numberOfCampsites }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out value="Year Founded:" /></span>
				<c:out value="${park.yearFounded }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out
						value="Annual Visitors:" /></span>
				<c:out value="${park.annualVisitorCount }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out value="Quote:" /></span>
				<c:out value="\" ${park.inspirationalQuote }\"" />
				<c:out value="- by" />
				<c:out value="${park.quoteSource }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out
						value="Miles of Trails:" /></span>
				<c:out value="${park.milesOfTrail }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out value="Entry Fee:" /></span>
				<c:out value="$${park.entryFee }" />
			</div>
			<div>
				<span style="font-weight: bold"><c:out
						value="Number of Species:" /></span>
				<c:out value="${park.numberOfSpecies }" />
			</div>


		</div>

	</c:forEach>
</div>
<br>

	<c:forEach var="weather" items="${parks}">

	<c:url var="detailUrl" value="/parkDetail">
		<c:param name="parkCode" value="${weather.parkCode}" />
		<c:param name="temp" value="${temp}" />
		
	</c:url>
	<c:url var="celciuslUrl" value="/tempToggle">
		<c:param name="parkCode" value="${weather.parkCode}" />
		<c:param name="temp" value="${temp}" />
	
		</c:url>
		<span style="padding-left: 15px; font-weight: bold">Toggle Celcius / Fahrenheit:  <a href="${celciuslUrl}">F/C</a></span>

</c:forEach>

<div class="weather">


	<c:forEach var="weather" items="${weather}">

		<div class="today">
			<div class="date">
				<c:out value="${weather.dayOfWeek}" />
			
			
			</div>


			<div>
				<c:choose>
					<c:when test="${weather.forecast == 'partly cloudy'}">
						<img src="img/weather/partlyCloudy.png" />
					</c:when>
					<c:otherwise>
						<img src="img/weather/${weather.forecast}.png" />
					</c:otherwise>
				</c:choose>
			</div>




			<div>

<c:choose>
<c:when test="${temp == false}">
				<c:choose>
					<c:when test="${weather.fiveDayForecastValue != 1}">
						<div>
							<c:out value="High" />
							<span style="font-weight: bold"><c:out
									value="${weather.high}" />F</span> <br>
							<c:out value="Low" />
							<span style="font-weight: bold"><c:out
									value="${weather.low}" />F</span>
						</div>

					</c:when>
					<c:otherwise>

						<div>
							<c:out value="High" />
							<span style="font-weight: bold"> <c:out value="${weather.high}" />F</span>

							<c:out value="Low" />
							<span style="font-weight: bold"> <c:out value="${weather.low}" />F</span>
						</div>
					</c:otherwise>
				</c:choose>
</c:when>
<c:when test="${temp == true}">
				<c:choose>
					<c:when test="${weather.fiveDayForecastValue != 1}">
						<div>
							<c:out value="High" />
							<span style="font-weight: bold"><c:out
									value="${weather.highC}" />C</span> <br>
							<c:out value="Low" />
							<span style="font-weight: bold"><c:out
									value="${weather.lowC}" />C</span>
						</div>

					</c:when>
					<c:otherwise>

						<div>
							<c:out value="High" />
							<span style="font-weight: bold"> <c:out value="${weather.highC}" />C</span>

							<c:out value="Low" />
							<span style="font-weight: bold"> <c:out value="${weather.lowC}" />C</span>
						</div>
					</c:otherwise>
				</c:choose>

</c:when>
</c:choose>



			</div>
			<div class="prepare">
				<c:choose>
					<c:when
						test='${weather.fiveDayForecastValue == 1 && weather.forecast == "rain"}'>
						<c:out value="Pack rain gear and wear waterproof shoes" />
					</c:when>
					<c:when
						test='${weather.fiveDayForecastValue == 1 && weather.forecast == "snow"}'>
						<c:out value="Better pack snow shoes" />
					</c:when>
					<c:when
						test='${weather.fiveDayForecastValue == 1 && weather.forecast == "thunderstorms"}'>
						<c:out value="Seek shelter and avoid hiking on exposed ridges" />
					</c:when>
					<c:when
						test='${weather.fiveDayForecastValue == 1 && weather.forecast == "sunny"}'>
						<c:out value="Better pack sunblock" />
					</c:when>
					<c:otherwise>
						<c:out value="" />
					</c:otherwise>
				</c:choose>
			</div>
			<div class="tempWarning">
				<c:choose>
					<c:when
						test="${weather.fiveDayForecastValue == 1 && weather.high > 75}">
						<c:out value="Bring an extra gallon of water" />
					</c:when>
					<c:when
						test="${(weather.fiveDayForecastValue == 1) && (weather.high - weather.low > 20)}">
						<c:out value="Wear breathable layers" />
					</c:when>
					<c:when
						test="${weather.fiveDayForecastValue == 1 && weather.low < 20}">
						<c:out value="Danger...exposure to frigid temperatures" />
					</c:when>
				</c:choose>
			</div>
		</div>
	</c:forEach>
</div>
<br>






<%@include file="common/footer.jsp"%>