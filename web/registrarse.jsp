<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
   
	<meta charset="utf-8">
	<title>Cabecera fija</title>

        <link rel="stylesheet" href="style.css">

    <title>registrarse</title>

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
        
        <div class="col-sm-8 main-section">
            
            <div class="modal-content">
                   <div class="form-group  ">
                 <h2> Registro </h2>
                 <br>
                 <br>
                    </div>
                <div class="col-12 user-img">
                   
                    <img src="statico/img/user.png" th:src="@{/img/user.png}"/>
                    
                    
                   
                  <form class="col-12" method="post" action="control_reg">
  
  				 <div class="form-group  ">
  			  
                           <br>
                                 <input type="text" name="usuario"class="form-control " id="usu" placeholder="Usuario" size="30" required autocomplete="off">
 				 </div>
                      
                                  <div class="form-group  ">
  				
                                 <input type="text" name="nombre" class="form-control " id="nom1"  placeholder="Nombre " size="20" required autocomplete="off">
 				</div>
                      
                                  <div class="form-group  ">
                                
                                <input type="text" name="apellido"class="form-control" id="APEL" placeholder="Apellido" size="20" required autocomplete="off">
                                </div>
                      
                                 <div class="form-group  ">
                                 
                                 <input type="password" name="clave" class="form-control" id="PASWORD" placeholder="Contraseña" required autocomplete="off">
                                  </div>
                                 
                                 <div class="form-group  ">
                                 
                                 <input type="email" class="form-control" name="email" id="EMAILL" aria-describedby="emailHelp" placeholder="Correo electronico" required size="30">
                                 </div>
                                
                      <small id="emaill" style="color:#FF0000;"  class="form-text text-muted">Sus datos estan seguros</small>

                      <button type="submit" id="bn" name="btn_loging" class="btn btn-primary">Registrarse</button>
</form>

                </div>
            </div>
        </div>
    </div>
  
    
   
    
    
</body>

</html>