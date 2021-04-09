<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>actual_correo</title>
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
                 <h2> cambio de correo </h2>
                 <br>
                 <br>
                    </div>
                <div class="col-12 user-img">
                   
                    <img src="statico/img/user.png" th:src="@{/img/user.png}"/>
                    
                    
                   
                  <form class="col-12" method="post" action="act_correo">
  
                                <div class="form-group  ">
                                    <br>
                              
                
                                 <input type="text" class="form-control " id="usu" name="usuario" placeholder="Usuario" required autocomplete="off">
 				 </div>
  
                                 <div class="form-group  ">
                                 
                                 <input type="email" class="form-control" name="emailant" id="EMAILL" aria-describedby="emailHelp" placeholder="Correo actual" required size="30">
                                 </div>
  <div class="form-group  ">
                                 
                                 <input type="email" class="form-control" name="emailnew" id="EMAILL" aria-describedby="emailHelp" placeholder="Nuevo correo" required size="30">
                                 </div>
                      
           <div id="g-recaptcha" >
               
           </div>
      <br/>
     
      
      <button type="submit" name="btn_loging" class="btn btn-primary" >Actualizar</button>
   
  <br>
  
</form>

                </div>
            </div>
        </div>
    </div>
</body>

   
    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
        async defer>
    </script>
</html>