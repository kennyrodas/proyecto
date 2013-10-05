function marcar(obj) {
  frm=obj.form;
  for (i=0; ele=frm.sel[i]; i++)
  ele.disabled = !obj.checked;
  document.form.n2.disabled = true; 
 
}

function habilita(){ 
    document.form.n2.disabled = false; 
 

   } 
   
function deshabilita(){ 
    document.form.n2.disabled = true; 
    document.form.n2.value = ""; 
   } 
   
   
   function habilita_2(){ 
    document.form.n3.disabled = false; 


   } 
   
function deshabilita_2(){ 
    document.form.n3.disabled = true; 
    document.form.n3.value = ""; 
   } 