$(document).ready(function(){

	var listLinks = $('#menu').find('li');

	for (var i = 0 ; i < listLinks.length ; i++){
		if ($(listLinks[i]).find('a').attr('href') == ""){
			$(listLinks[i]).find('a').attr('title','No disponible');
			$(listLinks[i]).find('a').addClass('disabled');
			$('#container').find('.e'+(i+1)).addClass('disabled');
		}
	}

	$('.element').click(function(){
		if(!$(this).hasClass("disabled")){
			var a = $(this).attr('class').split(' ');
			var url = $('#menu').find('.'+(a[1])).find('a').attr('href');
			if (url != ""){
				/*window.location.href = url;*/
			}
		}
	});
	$('.element').hover(
		function(){
			$(this).find('.wrappers').addClass('wrappers-selected');
			$(this).find('h3').addClass('selected');
			if (!$(this).hasClass('disabled')){
				$(this).find('.wrapper-selected').css('cursor','pointer');
			}
		},
		function(){
			$(this).find('.wrappers').removeClass('wrappers-selected');
			$(this).find('h3').removeClass('selected');
	});
	$('#menu').find('li').hover(
		function(){
			var element = $(this).attr('class');
			$('#container').find('.'+element).find('.wrappers').addClass('wrappers-selected');
			$('#container').find('.'+element).find('h3').addClass('selected');
		},
		function(){
			var element = $(this).attr('class');
			$('#container').find('.'+element).find('.wrappers').removeClass('wrappers-selected');
			$('#container').find('.'+element).find('h3').removeClass('selected');
		}
	);
	$('.wrappers').css('behavior','url(images/scripts/PIE.htc)');
});
