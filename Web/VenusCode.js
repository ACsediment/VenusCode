
document.getElementById("textarea_in").addEventListener("input", encode);
document.getElementById("maxColumn_in").addEventListener("input", encode);

//clipboard From clipboard.js
var clipboardSnippets = new ClipboardJS('.btn',{
    target: function(trigger) {
        return trigger.nextElementSibling;
    }
});
clipboardSnippets.on('success', function(e) {
    showTooltip(e.trigger, 'Copied!');
});
clipboardSnippets.on('error', function(e) {
    showTooltip(e.trigger, fallbackMessage(e.action));
});

//Tooltips:
var btns = document.querySelectorAll('.btn');
for (var i = 0; i < btns.length; i++) {
    btns[i].addEventListener('mouseleave', clearTooltip);
    btns[i].addEventListener('blur', clearTooltip);
}
function clearTooltip(e) {
    e.currentTarget.setAttribute('class', 'btn');
    e.currentTarget.removeAttribute('aria-label');
}
function showTooltip(elem, msg) {
    elem.setAttribute('class', 'btn tooltipped tooltipped-s');
    elem.setAttribute('aria-label', msg);
}
function fallbackMessage(action) {
    var actionMsg = '';
    var actionKey = (action === 'cut' ? 'X' : 'C');
    if (/iPhone|iPad/i.test(navigator.userAgent)) {
        actionMsg = 'No support :(';
    } else if (/Mac/i.test(navigator.userAgent)) {
        actionMsg = 'Press ⌘-' + actionKey + ' to ' + action;
    } else {
        actionMsg = 'Press Ctrl-' + actionKey + ' to ' + action;
    }
    return actionMsg;
}
//End Tooltips

function encode(){
	var maxColumn=7;
	maxColumn=document.getElementById("maxColumn_in").value;
	var inputString=document.getElementById("textarea_in").value;
	document.getElementById("textarea_out").value=venusCode(inputString,maxColumn);
}

function venusCode(inputString,maxColumn){
	var outputString="";
		if (inputString.length<=maxColumn) {
			//if maxColumn is too large for input string, cut it in half.
			maxColumn=inputString.length/2;
		}
		if (maxColumn<=0) {maxColumn=1;};
		var rawCount=Math.ceil(inputString.length/maxColumn);

		for (i=0;i<rawCount;i++) {
			for (j=0; j<maxColumn; j++) {
				charIndex=i+j*rawCount;
				if (charIndex<inputString.length) {
					theChar=inputString.charAt(charIndex);
					outputString+=theChar;
					if(theChar.charCodeAt(0) < 127){outputString+=" ";} //additional space for half-full
					outputString+=" ";
				}
			}
			outputString+="\n"; //End of this line.
		}

		return outputString;
}
