function inputContent(){
	var detailsDiv = document.getElementById("data");
	for(var i = 0; i < localStorage.length; i++) {
		var key = localStorage.key(i);
        
        var parentContainer = document.createElement("div");
        parentContainer.className = "row";
        detailsDiv.appendChild(parentContainer);
        
		var fieldName = document.createElement("h3");
	    fieldName.className = "field-name";
	    fieldName.innerHTML = key + " : ";
	    parentContainer.appendChild(fieldName);
	    
	    var fieldValue = document.createElement("div");
	    fieldValue.className = "input-container";
	    fieldValue.innerHTML = localStorage.getItem(key);
	    parentContainer.appendChild(fieldValue);
        
	}
}