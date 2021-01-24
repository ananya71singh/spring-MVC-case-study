var currDate;
var dateOfLaunch;
var dt;
var st;
function validateMenuItemForm()
{
 currDate = new Date();
 dt = document.getElementById("date-of-launch").value;
 st = dt.split("/");
 
 
 if ( ! /^\d\d\/\d\d\/\d\d\d\d$/.test(dt) ) {
  document.getElementById("date-of-launch").style.borderColor="red";
  document.getElementById("date-of-launch").style.borderWidth="medium";
  //document.getElementById("submit").disabled = true;
  alert("please check the input format(dd/mm/yyyy) !");
 }
else{
  dateOfLaunch =  new Date(st[2]+"-"+st[1]+"-"+st[0]);//new Date(document.getElementById("date-of-launch").value);
  if(currDate - dateOfLaunch > 1){
  document.getElementById("date-of-launch").style.borderColor="red";
  document.getElementById("date-of-launch").style.borderWidth="medium";
  document.getElementById("submit").disabled = true;
  alert("please enter a greater date !");
 } 
 else{
  document.getElementById("date-of-launch").style.borderWidth="thin";	
  document.getElementById("date-of-launch").style.borderColor="black";
  document.getElementById("submit").disabled = false; 	
 }	
 }

}
