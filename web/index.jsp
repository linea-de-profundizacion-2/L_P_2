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

<script>
  function random() {
    return Math.random().toString(36).substr(2); // Eliminar `0.`
};
 
function token() {
    return random() + random(); // Para hacer el token más largo
};
 document.getElementById("csrf").value = token();



</script>
    
    
 <meta name="csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- ... -->
    




<script>
    function validarcampos(e)
{
key = e.keyCode || e.which;
tecla = String.fromCharCode(key).toString();
datos = "ABCDEFGHIJKLMÑOPQRSTUVWXYZabcdefghijklmnñopqrstvwxyz1234567890";

especiales = [8,13];
tecla_e = false
for(var i in especiales) {
if(key == especiales[i]){
 tecla_e = true;
 break;
}
}

if(datos.indexOf(tecla) == -1 && !tecla_e)
{
 alert("ingreso de caracteres invalido");
 return false;
}
}
    
    
</script>

<body>
   
    <div class="modal-dialog text-center">
        
        <div class="col-sm-10 main-section">
            
            <div class="modal-content">
                
                 <div class="form-group  ">
                 <h2> Iniciar sesión </h2>
                 <br>
                 <br>
                    </div>
                <div class="col-12 user-img">
                   
                    <img src="statico/img/user.png" th:src="@{/img/user.png}"/>
                    
                  <form class="col-12" method="post" action="cont_logeo">
  
                                <div class="form-group  ">
                                    <br>
                              
                
                                 <input type="text" class="form-control " id="usu" name="usuario" placeholder="Usuario" required autocomplete="off" 
                                        onkeypress="validarcampos(event);" required>
 				 </div>
  
                                <div class="form-group  ">
                                 <input type="password" class="form-control" id="PASWORD" name="clave"
                                        placeholder="Contraseña" required autocomplete="off" onkeypress="validarcampos(event);" required>
                                 
                                </div>
                       <div class="form-group  ">
                           <input type="hidden" name="csrf" value="";>
                                </div>
                      
  
           <div id="g-recaptcha" >
               
           </div>
      <br/>
      
     
      
      <button type="submit" name="btn_loging" class="btn btn-primary" >Ingresar</button>
   
  <br>
  <p> <a  href="registrarse.jsp"> Registrarse </a> </p>
</form>

                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
      var onloadCallback = function() {
        grecaptcha.render('g-recaptcha', {
          'sitekey' : '6LerAoYaAAAAAG2i5u7jdDuQWPUw5D5qCXOO1L6_'
        });
      };
    </script>
    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
        async defer>
    </script>
</html>