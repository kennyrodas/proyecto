
function trim(cadena) 
{ 
    for(i=0; i<cadena.length; ) 
    { 
        if(cadena.charAt(i)==" ") 
            cadena=cadena.substring(i+1, cadena.length); 
        else 
            break; 
    } 

    for(i=cadena.length-1; i>=0; i=cadena.length-1) 
    { 
        if(cadena.charAt(i)==" ") 
            cadena=cadena.substring(0,i); 
        else 
            break; 
    } 
     
	return cadena;
} 

function ValidaHora( dato )
{		
        var er_fh = /^(1|01|2|02|3|03|4|04|5|05|6|06|7|07|8|08|9|09|10|11|12)\:([0-5]0|[0-5][1-9])\ (am|pm)$/
        if( dato == "" )
        {
                //alert("Introduzca la hora.")
                return false;
        }
        if ( !(er_fh.test( dato )) ) 
        { 
                //alert("El dato en el campo hora no es válido.")
                return false;
        }
        
        //alert("¡Campo de hora correcto!")
        return true;
}

function  ValidaDatos_Asignar(form){
	

	var control_txt_especialista = ValidarCaracteres(form.txt_especialista.value);	
	//var control_date_asignacion_h = ValidaHora(form.date_asignacion_h.value);
	


	
	if (document.form.int_tipo_servicio.value == "0" ) { 
        document.form.int_tipo_servicio.focus() 
        alert("Elija una opción de Tipo de Servicio"); 
        return false; 
        }
		
		
		else{
		if(trim(form.txt_especialista.value)==""){
		alert ("Es necesario que ingrese un Especialista.");
		form.txt_especialista.focus();
		return false;

		}
		
		
		/*else{
		if(trim(form.date_asignacion_h.value)==""){
		alert ("Es necesario que ingrese una Hora.");
		form.date_asignacion_h.focus();
		return false;
		}
		*/

		
		
		
	/*	else{
		if(trim(form.date_asignacion_h.value)==""){
		alert ("Es necesario que ingrese la hora.");
		form.date_asignacion.focus();
		return false;
		}
		
		else{
		if (document.form.int_departamento.value == "0" ) { 
        document.form.int_departamento.focus() 
        alert("Elija Departamento"); 
        return false; 
        }
		
		else{
		if (document.form.int_provincia.value == "0" ) { 
        document.form.int_provincia.focus() 
        alert("Elija Provincia"); 
        return false; 
        }
		*/
		/*else{
		if (document.form.int_distrito.value == "0" ) { 
        document.form.int_distrito.focus() 
        alert("Elija Distrito"); 
        return false; 
        }

*/




} }	//} 	//}	//} }}
								











function validarEmail(cadena)  {
	  var a = cadena;
      var filter=/^[A-Za-z][A-Za-z0-9_.]*@[A-Za-z0-9_]+.[A-Za-z0-9_.]+[A-za-z]$/;
          if (a.length == 0 ) 
              return true;
          if (filter.test(a))
              return true;
          else
       /*       alert("Porfavor, debe ingresar una dirección de correo válida");
          cadena.focus();*/
          return false;

}



function Validar(Cadena){   
    var Fecha= new String(Cadena)  // Crea un string   
    var RealFecha= new Date()   // Para sacar la fecha de hoy   
   //Cadena Año   
    var Ano= new String(Fecha.substring(Fecha.lastIndexOf("/")+1,Fecha.length))   
   //Cadena Mes   
    var Mes= new String(Fecha.substring(Fecha.indexOf("/")+1,Fecha.lastIndexOf("/")))   
   //Cadena Día   
    var Dia= new String(Fecha.substring(0,Fecha.indexOf("/")))   
  
   // Valido el año   
    if (isNaN(Ano) || Ano.length<4 || parseFloat(Ano)<1900){   
            alert('Año inválido')   
        return false   
    }   
   // Valido el Mes   
    if (isNaN(Mes) || parseFloat(Mes)<1 || parseFloat(Mes)>12){   
        alert('Mes inválido')   
        return false   
    }   
   //Valido el Dia   
    if (isNaN(Dia) || parseInt(Dia, 10)<1 || parseInt(Dia, 10)>31){   
        alert('Día inválido')   
        return false   
    }   
    if (Mes==4 || Mes==6 || Mes==9 || Mes==11 || Mes==2) {   
        if (Mes==2 && Dia > 28 || Dia>30) {   
            alert('Día inválido')   
            return false   
        }   
    }   
       
 //para que envie los datos, quitar las  2 lineas siguientes   
  alert("Fecha correcta.")   
  return false     
}   
  





function ValidarNumeros(valor)
{
 var checkOK = "0123456789";
  var checkStr = valor;
  var esp = Espacios(valor);
  if (!esp)
  {
   var allValid = true; 
   for (i = 0; i < checkStr.length; i++) {
     ch = checkStr.charAt(i); 
     for (j = 0; j < checkOK.length; j++)
       if (ch == checkOK.charAt(j))
         break;
     if (j == checkOK.length) { 
	   allValid = false; 
	   break;
     }
   }
   return allValid;
  }else{ allValid = true;}
  return allValid;
	
}

function ValidarFloat(valor)
{
 var checkOK = "0123456789.";
  var checkStr = valor;
  var esp = Espacios(valor);
  if (!esp)
  {
   var allValid = true; 
   for (i = 0; i < checkStr.length; i++) {
     ch = checkStr.charAt(i); 
     for (j = 0; j < checkOK.length; j++)
       if (ch == checkOK.charAt(j))
         break;
     if (j == checkOK.length) { 
	   allValid = false; 
	   break;
     }
   }
   return allValid;
  }else{ allValid = true;}
  return allValid;
	
}


function ValidarTelefono(valor)
{
 var checkOK = "()0123456789_-/";
  var checkStr = valor;
  var esp = Espacios(valor);
  if (!esp)
  {
   var allValid = true; 
   for (i = 0; i < checkStr.length; i++) {
     ch = checkStr.charAt(i); 
     for (j = 0; j < checkOK.length; j++)
       if (ch == checkOK.charAt(j))
         break;
     if (j == checkOK.length) { 
	   allValid = false; 
	   break;
     }
   }
   return allValid;
  }
  return allValid;
	
}




function ValidarCaracteres(valor)
{
  var checkOK = " ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyzáéíóúÁÉÍÓÚ0123456789_-.@&";
  var checkStr = valor;
  var esp = Espacios(valor);
  if (!esp)
  {
   var allValid = true; 
   for (i = 0; i < checkStr.length; i++) {
     ch = checkStr.charAt(i); 
     for (j = 0; j < checkOK.length; j++)
       if (ch == checkOK.charAt(j))
         break;
     if (j == checkOK.length) { 
	   allValid = false; 
	   break;
     }
   }
   return allValid;
  }else{ allValid = true;}
  return allValid;
} 
//}







function Espacios(valor)
{
  var checkOK = " ";
  var checkStr = valor;
  var allValid = true; 
  for (i = 0; i < checkStr.length; i++) {
    ch = checkStr.charAt(i); 
    for (j = 0; j < checkOK.length; j++)
      if (ch == checkOK.charAt(j))
        break;
    if (j == checkOK.length) { 
      allValid = false; 
	  break;
    }
  }
  return allValid;
} 
