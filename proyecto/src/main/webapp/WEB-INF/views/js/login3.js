var pending = false;

function showPreloader(){
	$("overlay").style.display = "block";
	$("preloader").style.display = "block";	
}

function hidePreloader(){
	$("preloader").style.display = "none";
}


function onFailure(e){
	alert("Error: "+e.status+" "+e.statusText);
}

var ajaxHandlers = {
	onCreate: function(){
	showPreloader();
	 pending = true;
	/*var consoleContainer = document.getElementById("console");
	 consoleContainer.innerHTML = "Procesando...";*/
	},	
	onComplete: function(){
		hidePreloader();
		pending = false;
	}
}

Ajax.Responders.register(ajaxHandlers);
 //-------------------------------------------------------------
function onSuccess(req, json){
	var consoleContainer = document.getElementById("console");
		 var menuContainer = document.getElementById("menu");
		 var cabeceraContainer = document.getElementById("cabecera");
	if(json.success){
		//alert("existo")	
		//sendAlert("Fue un existo");
		//menuContainer.style.display = "none";
		menuContainer.innerHTML = json.tpl_m;
		cabeceraContainer.innerHTML = json.tpl_c;
		menuContainer.style.display = "none";
		//menuContainer.style.display = "block";
		consoleContainer.style.display = "none";
		consoleContainer.innerHTML = json.tpl;
		consoleContainer.style.display = "block";
		
		initConsole();
	}else{
		sendAlert(json.message);
	}
}
function sendAlert(message){
	/*var mensajealerta =document.getElementById("alertmessage");
	mensajealerta.innerHTML = message;*/
	$("overlay").style.display = "block";
	$("overlayalert").style.display = "block";
	$("alertmessage").innerHTML = message;
}

function hideAlert(){
	$("overlay").style.display = "none";
	$("alertmessage").inneHTML = "";
	$("overlayalert").style.display = "";
}

function sendLogin(){
	if (!pending) {
		var user = $F("user");
		var pass = $F("pass");
		var form = $("login");
		var action = form.action;
		if (!user.length) {
			sendAlert("Es necesario que ingrese su nombre de usuario");
		}
		else 
			if (!pass.length) {
				sendAlert("Es necesario que ingrese su contrase&ntilde;a");
			}
			else {
				new Ajax.Request(action, {
					method: 'post',
					postBody: Form.serialize(form),
					onSuccess: onSuccess,
					onFailure: onFailure
				});
			}
		$("user").blur();
		$("pass").blur();
	}
	return false;
}
//-------------------------------------------

function doSave(){

	var user = $F("user");
	var pass = $F("pass");	
	form = $("registra");
	var action = form.action;
	params = {method: 'post',
	postBody:Form.serialize(form),
	onSuccess: onSuccesst,
	onFailure: onFailure};
	new Ajax.Request(action, params);	
	return false;	
}

function onSuccesst(req, json){
	if(json.success){
		sendAlert("Fue un existo");	
		carga("welcome");
	}else{
		sendAlert(json.message);
	}
}