
var PaperFunctions = {
text: new PointText({
    point: [100, 50],
    content: "Hallo",
    fillColor: 'black',
    fontFamily: 'Courier New',
    fontWeight: 'bold',
    fontSize: 25
    
}),


createText : function(entry){
    if(!entry){
        entry = 'The contents of the point text';
    }
	this.text.set(
	{
	    content: entry,
	});
	view.draw();
	
}


}


//export functions to global
window.Paper = PaperFunctions;