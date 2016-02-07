
var popup;
function popUp(url) {
	popup=window.open(url,'name','height=500,width=720,left=700,top=200,location=no,titlebar=no,toolbar=no,status=no');


    $(popup).load(function(){
        
        $(popup.document.body).append($('#previewCanvas'));
        
        
    })
    
    
    
    if (window.focus) {popup.focus()}
    return false;
}

