/**
 * 
 */

var EventUtil = {
		addHandler: function(element, type, handler){
			element.addEventListener(type, handler, false);
		},
		getEvent: function(event){
			return event;
		},
		getTarget: function(event){
			return event.target;
		},
		preventDefault: function(event){
			event.preventDefault();
		},
		removeHandler: function(element, type, handler){
			element.removeEventListener(type, handler, false);
		},
		stopPropagation: function(event){
			event.stopPropagation();
		}
}