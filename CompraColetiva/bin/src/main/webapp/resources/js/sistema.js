function sticky_footer() {
	var mFoo = $("footer");
	if ((($(document.body).height() + mFoo.outerHeight()) < $(window).height() && mFoo
			.css("position") == "fixed")
			|| ($(document.body).height() < $(window).height() && mFoo
					.css("position") != "fixed")) {
		mFoo.css({
			position : "fixed",
			bottom : "0px"
		});
	} else {
		mFoo.css({
			position : "static"
		});
	}
}

jQuery(document).ready(function($) {
	sticky_footer();
	$(window).scroll(sticky_footer);
	$(window).resize(sticky_footer);
	$(window).load(sticky_footer);
});