<%-- 
    Document   : aggiungicorso
    Created on : 24-dic-2015, 18.26.00
    Author     : Rembor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Xenon Boostrap Admin Panel" />
        <meta name="author" content="" />

        <title>Aggiungi Corso</title>

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

        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="script/aggiungicorso.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
<script type="text/javascript">
            function checkDate() {
                var start = new Date($("#startdate").val());
                var end = new Date($("#enddate").val());

                if (start > end) {
                    alert('La data di fine della missione è precedente alla data di inizio!');
                }
            };
        </script>
    </head>
    <body class="page-body">

        <!-- Inclusione della pagina contenente il menù superiore -->
        <jsp:include page="barraMenu.jsp" flush="true"/>
        <div class="page-container">

            <!-- Inclusione della pagina contenente il menù laterale -->

            <!-- Contenuto della pagina -->

            <div class="main-content" id="content">

                <div class="row">

                    <div class="col-sm-1"></div>

                    <div class="col-sm-10">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1> Aggiungi Corso</h1>
                            </div>
                            <div class="panel-body">
                                <!--<form class="form-horizontal" method="POST" action="AddCourseServlet">-->
                                    <div class="form-group">
                                        <table width="90%" align="center">
                                            <tr><td>
                                                   
                                                    
                                                    
                                                    <p>Id Corso:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" name="idCourse" type="text" id="numCorso" required>
                                                    </div>
                                                    <br>
                                                    <br>
                                                  <p>Ciclo:</p>
                                                     <div class="input-group">
                                                        
                                                        <select class="form-control" name="fkCycle" id="CycleList" required onchange="selectedItem()"> 
                                                          <option value="default" >Seleziona il ciclo</option>
                                                        
                                                                  
                                                        </select>
                                                     </div>
                                                  <br>
                                                    <br>
                                                 <p>Curriculum:</p>
                                                    <div class="input-group">
                                                        <select class="form-control" name="fkCurriculum" id="curriculum" required> 
                                                          <option value="default" >Seleziona il curriculum</option>
                                                          
                                                                  
                                                        </select> </div>
                                                    <br>
                                                    <br>
                                                    
                                                    
                                                     <p>Nome Corso:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" name="name" type="text" id="nameCourse" required>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <p>Descrizione del Corso:</p>
                                                     <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <textarea class="form-control" name="description" rows="5" cols="40" id="description"> </textarea>
                                                    </div>
                                                    <br>                          


                                                    <br>
                                                   
                                                    
                                                   <p>Data di Inizio:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" id="startdate" name="startDate" type="date" placeholder="aaaa-mm-gg" required>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <p>Data di Fine:</p>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"></span>
                                                        <input class="form-control" id="enddate" name="endDate" onblur="checkDate()" type="date" placeholder="aaaa-mm-gg"  required>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    

                                                    <div>
                                                        <input type="submit" class="btn btn-blue" value="Inserisci" onclick="insertCourse()"> 
                                                        <br>
                                                        <br>

                                                    </div>
                                                </td></tr>
                                        </table>

                                    </div>
                                <!--</form>-->
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-1"></div>

                </div>
            </div>
        </div>

    </body>
</html>