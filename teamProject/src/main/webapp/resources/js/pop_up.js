function openwindow(opage, x, y) {
farwindow = window.open('','Links','width='+x+', height='+y+', toolbar=0, scrollbars=1, resizable=no');
if (farwindow != null) {
if (farwindow.opener == null) {
farwindow.opener = self;
};
farwindow.location.href = opage;
};
close();
};