$(function(){
	$('#navbar li a').each(function(){
		var $href = $(this).attr('href');
		if(location.href.match($href)) {
			var $class = $(this).parent().parent().parent().attr('class');
			if($class == "dropdown" ){
				$(this).parent().parent().parent().addClass('active');
			}
			else{
				$(this).parent().addClass('active');
			}
		}
		else {
			$('#navbar li a').removeClass('active');
		}
		if(location.href.match("/drillMaster/teacher/editStudent/") && $href=="/drillMaster/teacher/viewStudent/"){
			$(this).parent().addClass('active');
		}
	});
});