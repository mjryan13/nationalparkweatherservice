<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="pageTitle" value="Survey" />
<%@include file="common/header.jsp"%>




<div class="parks">

<h1>Survey</h1>

<c:url var="surveyForm" value="/survey" />



<form:form modelAttribute="survey" action="${surveyForm}" method="POST">
	<div class="survey">
	<div>
		<label for="parkCode">Favorite Park Name</label>

		<form:select path="parkCode" name="parkCode" style="margin-left: 10px;">
		<form:option value="CVNP">Cuyahoga Valley National Park</form:option>
		<form:option value="ENP">Everglades National Park</form:option>
		<form:option value="GCNP">Grand Canyon National Park</form:option>
		<form:option value="GNP">Glacier National Park</form:option>
		<form:option value="GSMNP">Great Smoky Mountains National Park</form:option>
		<form:option value="GTNP">Grand Teton National Park</form:option>
		<form:option value="MRNP">Mount Rainier National Park</form:option>
		<form:option value="RMNP">Rocky Mountain National Park</form:option>
		<form:option value="YNP">Yellowstone National Park</form:option>
		<form:option value="YNP2">Yosemite National Park</form:option>
		<form:errors path="parkCode" cssClass="error" />
		</form:select>
	</div>
	<br>
	<div>
		<label for="emailAddress">Your Email</label>
		<form:input path="emailAddress" placeholder="enter valid email" style="margin-left: 76px;" />
		<form:errors path="emailAddress" cssClass="error" />

	</div>
	<br>
	<div>
		<label for="state">State of Residence</label>
		<form:select name="state" path="state" style="margin-left: 15px;" >
		<form:option value="AL">Alabama</form:option>
		<form:option value="AK">Alaska</form:option>
		<form:option value="AZ">Arizona</form:option>
		<form:option value="AR">Arkansas</form:option>
		<form:option value="CA">California</form:option>
		<form:option value="CO">Colorado</form:option>
		<form:option value="CT">Connecticut</form:option>
		<form:option value="DE">Delaware</form:option>
		<form:option value="DC">District Of Columbia</form:option>
		<form:option value="FL">Florida</form:option>
		<form:option value="GA">Georgia</form:option>
		<form:option value="HI">Hawaii</form:option>
		<form:option value="ID">Idaho</form:option>
		<form:option value="IL">Illinois</form:option>
		<form:option value="IN">Indiana</form:option>
		<form:option value="IA">Iowa</form:option>
		<form:option value="KS">Kansas</form:option>
		<form:option value="KY">Kentucky</form:option>
		<form:option value="LA">Louisiana</form:option>
		<form:option value="ME">Maine</form:option>
		<form:option value="MD">Maryland</form:option>
		<form:option value="MA">Massachusetts</form:option>
		<form:option value="MI">Michigan</form:option>
		<form:option value="MN">Minnesota</form:option>
		<form:option value="MS">Mississippi</form:option>
		<form:option value="MO">Missouri</form:option>
		<form:option value="MT">Montana</form:option>
		<form:option value="NE">Nebraska</form:option>
		<form:option value="NV">Nevada</form:option>
		<form:option value="NH">New Hampshire</form:option>
		<form:option value="NJ">New Jersey</form:option>
		<form:option value="NM">New Mexico</form:option>
		<form:option value="NY">New York</form:option>
		<form:option value="NC">North Carolina</form:option>
		<form:option value="ND">North Dakota</form:option>
		<form:option value="OH">Ohio</form:option>selected
		<form:option value="OK">Oklahoma</form:option>
		<form:option value="OR">Oregon</form:option>
		<form:option value="PA">Pennsylvania</form:option>
		<form:option value="RI">Rhode Island</form:option>
		<form:option value="SC">South Carolina</form:option>
		<form:option value="SD">South Dakota</form:option>
		<form:option value="TN">Tennessee</form:option>
		<form:option value="TX">Texas</form:option>
		<form:option value="UT">Utah</form:option>
		<form:option value="VT">Vermont</form:option>
		<form:option value="VA">Virginia</form:option>
		<form:option value="WA">Washington</form:option>
		<form:option value="WV">West Virginia</form:option>
		<form:option value="WI">Wisconsin</form:option>
		<form:option value="WY">Wyoming</form:option>
		<form:errors path="state" cssClass="error" />
	</form:select>
	</div>
	<br>
	<div>
		<label style="margin-right: 60px;" for="activityLevel"> Activity level</label>
		<form:input path="activityLevel" type="hidden" />
		<form:radiobutton path="activityLevel" value="Inactive"/> Inactive
		<form:radiobutton path="activityLevel" value="Sedentary"/> Sedentary 
		<form:radiobutton path="activityLevel" value="Active"/> Active 
		<form:radiobutton path="activityLevel" value="Extremely Active"/> Extremely Active
		<form:errors path="activityLevel" cssClass="error" />
	</div>
	
	<br>
	<input type="submit" value="Submit" id="submit" />
</div>
</form:form>
</div>

<%@include file="common/footer.jsp"%>
