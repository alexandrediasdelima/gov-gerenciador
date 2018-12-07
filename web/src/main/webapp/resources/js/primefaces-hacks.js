function removeInputPrimefacesStyles(elements) {
	$(elements).each(function() {
		$(this)
			.removeClass('ui-inputfield ui-inputmask ui-widget ui-state-default ui-corner-all')
			.focus(function() {
				$(this).removeClass('ui-state-focus');
			})
			.mouseover(function() {
				$(this).removeClass('ui-state-hover');
			}).focus(function() {
				$(this).removeClass('ui-state-focus');
			}).hover(function() {
				$(this).removeClass('ui-state-focus');
			});
	});
}
