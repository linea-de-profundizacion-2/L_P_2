<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>registrarse</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <!--JQUERY-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    <!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
    <!-- Los iconos tipo Solid de Fontawesome-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

    <!-- Nuestro css-->
    <link rel="stylesheet" type="text/css" href="statico/css/index.css" th:href="@{/css/index.css}">

</head>
<body>
   
    <div class="modal-dialog text-center">
        
        <div class="col-sm-10 main-section">
            
            <div class="modal-content">
                
                   <div class="form-group  ">
                 <h2>SE REALIZO EL INGRESO CON EXITO</h2> 
                 <br>
                 <br>
                    </div>
                <div class="col-12 user-img">
                   
                    <img src="statico/img/LOGRO.png" th:src="@{/img/LOGRO.png}"/>
                    
                    
                   
                  <form class="col-12" method="post" action="control_reg">
  
               
           </div>
      <br/>
     
      
     
</form>

                </div>
            </div>
        </div>
    </div>
</body>
</html>