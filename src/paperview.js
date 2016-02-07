
var PaperFunctions = {



createText : function(){
	var text = new PointText({
    point: [100, 50],
    content: 'The contents of the point text',
    fillColor: 'black',
    fontFamily: 'Courier New',
    fontWeight: 'bold',
    fontSize: 25
	});
	
}


}


//export functions to global
window.Paper = PaperFunctions;