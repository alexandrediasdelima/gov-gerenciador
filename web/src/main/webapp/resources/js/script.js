function showOfertaCaronaLightbox(){
	
	var validacaoLightbox = document.getElementById('validacaoHtmlLightbox').checked;
	
	if (validacaoLightbox){
		document.getElementById('lightboxCarona_panel').style.display = 'block';
	}
}

function showLightboxInformativoCarona(){
	
	var validacaoHtmlInformativo = document.getElementById('validacaoHtmlInformativo').checked;
	
	if (validacaoHtmlInformativo){
		document.getElementById('lightboxInformativoCarona_panel').style.display = 'block';
	}
}

function showLoadingFeature() {
	
	if ($('.validacaoFeature').length > 0) {
		$('.validacaoFeature').hide();
	}
	
	$('#icoLoadingFeature').show();
}

function hideLoadingFeature() {
	
	if ($('.icoLoadingFeature').length > 0) {
		$('.icoLoadingFeature').hide();
	}
	
	if ($('.validacaoFeature').length > 0) {
		$('.validacaoFeature').show();
	}
}