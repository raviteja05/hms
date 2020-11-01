<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>${pageId}-AppCal</title>
    <spring:eval expression="@environment.getProperty('webcontext')" var="webcontext" />
     
    <script>
      var data=${pageData}
      
    </script>
    <link rel="icon" type="image/jpeg" sizes="1800x1200" href="${webcontext}/assets/img/Background.jpg">
    <link rel="stylesheet" href="${webcontext}/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=ABeeZee">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Acme">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aguafina+Script">
    <link rel="stylesheet" href="${webcontext}/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="${webcontext}/assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="${webcontext}/assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="${webcontext}/assets/css/Calendar-BS4-1.css">
    <link rel="stylesheet" href="${webcontext}/assets/css/Calendar-BS4.css">
    <link rel="stylesheet" href="${webcontext}/assets/css/Filter.css">
    <link rel="stylesheet" href="${webcontext}/assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="${webcontext}/assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="${webcontext}/assets/css/smoothproducts.css">
</head>

<body>
      <div id="root"></div>
    <!--
      This HTML file is a template.
      If you open it directly in the browser, you will see an empty page.

      You can add webfonts, meta tags, or analytics to this file.
      The build step will place the bundled scripts into the <body> tag.

    -->
  </body>
  <script src="${webcontext}/js/dist/${pageId}.bundle.js"></script>
      <script src="${webcontext}/assets/js/jquery.min.js"></script>
    <script src="${webcontext}/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="${webcontext}/assets/js/smoothproducts.min.js"></script>
    <script src="${webcontext}/assets/js/theme.js"></script>
</body>

</html>