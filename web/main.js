function onBefore() { 
    $('#feature').fadeOut(300);
} 
function onAfter() { 
    $('#feature').html(this.alt).fadeIn(50);
}

$(document).ready(function() {
	
    $('.slideshow').cycle({
    		fx: 'scrollLeft',
            speed:    500, 
            timeout:  3000,
            before:  onBefore, 
            after:   onAfter            
    	});
    	
    $("a.divButton").button();
	
});