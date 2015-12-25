<%-- 
    Document   : calendario
    Created on : 15-dic-2015, 16.52.45
    Author     : Rembor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     
        <meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        
       <!-- Bootstrap e i fogli di stile vado a fiducia  -->
       <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Arimo:400,700,400italic">
        <link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
        <link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.css">
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/xenon-core.css">
        <link rel="stylesheet" href="assets/css/xenon-forms.css">
        <link rel="stylesheet" href="assets/css/xenon-components.css">
        <link rel="stylesheet" href="assets/css/xenon-skins.css">
        <link rel="stylesheet" href="assets/css/custom.css">  
        <link rel="stylesheet" href="style/dottorato.css">
        <link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.min.css" >
	<link rel="stylesheet" href="http://getbootstrap.com/assets/css/docs.min.css">
	<link rel="stylesheet" href="assets/js/calendar/jin.calendar.style.css">
       
        <script src="assets/js/calendar/jin.calendar.js"></script>
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="script/amministrazione.js"></script>
    
    </head>
    <body>
        <div class="page-body">
     <jsp:include page="barraMenu.jsp"/>
    <div class="page-container"> 
          <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Gestione Calendario </a>
                    </div>
                    <div>
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="aggiungicorso.jsp">Aggiungi Corso</a></li>
                            <li><a href="aggiungievento.jsp">Aggiungi Eventi</a></li>
                            
                        </ul>
                    </div>
                </div>
        

	<div class="div-month row">
		<div class="col-xs-3 text-right">
			<h4>
			<button id="btn-prev" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-circle-arrow-left"></span> Prev
			</button>
			</h4>
		</div>
		
		<div class="col-xs-6">
			<h4 class="h4-month text-center"></h4>
		</div>
		
		<div class="col-xs-3 text-left">
			<h4>
			<button id="btn-next" type="button" class="btn btn-default">
				Next <span class="glyphicon glyphicon-circle-arrow-right"></span>
			</button>
			</h4>
		</div>
	</div>

	<div class="div-main">
		<div class="div-calendar row">
			<div class="div-init col-sm-12"></div>
		</div>
	</div>

<script>

		jinCalendar.init();

		
	</script>
	

	
   </div>
</div>
</body>


</html>
