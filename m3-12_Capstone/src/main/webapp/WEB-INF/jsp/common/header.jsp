<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>National Park Geek</title>
    <c:url value="/css/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="National Park Geek logo" />
        </a>
       </header>
    
    <c:url value="/" var="homePage" />
    
   <c:url value="/survey" var="survey" />
    
   
  
    <nav>
       
        <ul>
            <li><a href="${homePage}">Home</a></li>
            <li><a href="${survey}">Survey</a></li>
                       
        </ul>
    </nav>
    
  	<div id="main-content">