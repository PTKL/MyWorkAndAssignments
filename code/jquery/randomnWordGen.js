$(document).ready(function() {
    var quotes = new Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"),
    randnom = quotes[Math.floor( Math.random() * quotes.length )];
    	$("#msg").text(randnom);
    setTimeout(function(){
   		window.location.reload(1);
}, 		5000);
});