

function apply(){
	Paper.createText($('.entry').val());
}


window.onload= function(){
	console.log("loaded");
	Paper.createText();
}