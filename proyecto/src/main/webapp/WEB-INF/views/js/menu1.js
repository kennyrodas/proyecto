nu=false;

function CambiaColor(c,n)	{

document.images[c].src="images/"+n;

	}


function onSuccessu(req,json){
if(json.success){	 
   var consoleContainer = document.getElementById("console");
    consoleContainer.style.display = "none";					
consoleContainer.innerHTML = json.tpl;	
consoleContainer.style.display = "block";
  cierra_pestagnas(json);
	initConsole();
	}
}

function onFailureu(e){	
alert("Error: "+e.status+" "+e.statusText);
}
function carga(plt){
	var menuContainer = document.getElementById("menu");
	menuContainer.style.display = "block";
	
	if(calendario==true){
    var pickerDiv = document.getElementById(datePickerDivID);
	pickerDiv.style.visibility = "hidden";
	pickerDiv.style.display = "none";
	adjustiFrame(pickerDiv);
	calendario=false;
    }
  
	
   new Ajax.Request('LSA_services/redirecciona.php?pltd='+plt, {method:'POST', onSuccess: onSuccessu, onFailure: onFailureu});
}

function pre(e){
var capa = document.getElementById("tabs").getElementsByTagName("li");
for (var i=0; i<capa.length; i++) {
	capa[i].setAttribute("id", "w"); 
};
capa[e].setAttribute("id", "current"); 
}

function cierra_pestagnas(json){

            var plt1 = "cierre_culminacion_salutia";
            var plt2 = "seguimiento_perfil_salutia";
            var plt3 = "cierre_culminacion_procuracion";
            var plt4 = "seguimiento_perfil_procuracion";
            var plt5 = "cierre_culminacion_aequitas";
            var plt6 = "seguimiento_perfil_aequitas";
            var plt7 = "asignacion_perfil_aequitas";
			var plt8 = "analisis_tecnico_aequitas";
			var plt9 = "reporte_salutia";
            var plt10 = "reporte_procuracion";
            var plt11 = "reporte_aequitas";


  if( (json.nombre_tpl==plt1) || (json.nombre_tpl==plt2) || (json.nombre_tpl==plt3) || (json.nombre_tpl==plt4) || (json.nombre_tpl			
	==plt5) || (json.nombre_tpl==plt6) || (json.nombre_tpl==plt7)|| (json.nombre_tpl==plt9)|| (json.nombre_tpl==plt10)|| (json.nombre_tpl==plt11)){

      var pesta = document.getElementById("panelcontroller");

 	 switchPanel(pesta);
             }else{

           if(json.nombre_tpl==plt8){
		 switchPanel(document.getElementById("panelcontroller"));
  	      switchPanel(document.getElementById("panelcontroller1"));
   		 switchPanel(document.getElementById("panelcontroller2"));

                            }

                 }


}


function sub_menu_sobre(c)      {
document.images[c-1].src="images/sub_tab_r_0.jpg";
document.getElementById("b"+c).style.backgroundImage = "url('images/sub_tab_r_1.jpg')";
document.images[c].src="images/sub_tab_r_2.jpg";
            }

function sub_menu_fuera(c)       {
document.images[c-1].src="images/sub_tab_0.jpg";
document.getElementById("b"+c).style.backgroundImage = "url('images/sub_tab_1.jpg')";
document.images[c].src="images/sub_tab_2.jpg";
            }


function muestra(nro,plt){
	 nu = nro;
	 $("overlay").style.backgroundColor= "#000000";
	$("overlay").style.display = "block";
	$("overlaypanel").style.display = "block";
	$("overlayalert"+nu).style.display = "block";	

	new Ajax.Request('LSA_services/redirecciona.php?pltd='+plt, {method:'POST', onSuccess: onSuccessf, onFailure: onFailureu});
}

function onSuccessf(req,json){
	if(json.success){ 
	  $("overlayalert"+nu).innerHTML = json.tpl;	
	}
}

function esconder(nu){
	$("overlayalert"+nu).innerHTML="";
	$("overlayalert"+nu).style.display = "none";
	if(nu =='1'){
	$("overlaypanel").innerHTML="";
	$("overlay").innerHTML="";
	$("overlaypanel").style.display = "none";
	$("overlay").style.display = "none";
	$("overlay").style.backgroundColor=""; 
	}	
}

function setIndice(indice){

            this.indice=indice;

            }

function getIndice(){

            return this.indice;

            }

