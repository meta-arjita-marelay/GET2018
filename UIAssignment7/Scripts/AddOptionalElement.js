function furtherOptions(event){
    removeOptionalElements();
    if(this.options[this.selectedIndex].text=='Rajasthan'){
        addWebsiteDomain();
        addProjectDescription();
    }
    else if(this.options[this.selectedIndex].text=="Haryana"){
        addZipCode();
        addHostingField();
    }
    else if(this.options[this.selectedIndex].text=="Maharastra"){
        addZipCode();
        addProjectDescription();
    }
}
function addWebsiteDomain(){
    var formContainer = document.getElementById("form-container");
    var div = document.createElement('div');
    div.className = 'row optionalElement';
    div.innerHTML='<div class="field-name">Website or domain name</div>\
                        <div class="input-container">\
                            <div class="field-icon">\
                                <i class="fas fa-globe-americas"></i>\
                            </div>\
                            <div class="input-field">\
                                <input type="text" id="website" placeholder="Website or domain name">\
                            </div>\
                        </div>';
     formContainer.appendChild(div);
}
function addProjectDescription(){
    var formContainer = document.getElementById("form-container");
    var div = document.createElement('div');
    div.className = 'row optionalElement';
    div.innerHTML='<div class="field-name">Project Description</div>\
                        <div class="input-container">\
                            <div class="field-icon" id="textarea-icon">\
                                <i class="fas fa-pen"></i>\
                            </div>\
                            <div class="input-field">\
                                <textarea id="project" placeholder="Project Description"></textarea>\
                            </div>\
                        </div>';
    formContainer.appendChild(div);
}
function addZipCode(){
    var formContainer = document.getElementById("form-container");
    var div = document.createElement('div');
    div.className = 'row optionalElement';
    div.innerHTML='<div class="field-name">Zip Code</div>\
                        <div class="input-container">\
                            <div class="field-icon">\
                                <i class="fas fa-home"></i>\
                            </div>\
                            <div class="input-field">\
                                <input type="text" id="zip-code" placeholder="Zip Code">\
                            </div>\
                        </div>';
    formContainer.appendChild(div);
}
function addHostingField(){
    var formContainer = document.getElementById("form-container");
    var div = document.createElement('div');
    div.className = 'row optionalElement';
    div.innerHTML='<div class="field-name" id="hosting-field">Do you have hosting?</div>\
                        <div class="input-container">\
                            <div class="input-field" id="radio-input">\
                                <label>\
                                    <input type="radio" id="yes-hosting" value="yes" name="hosting">Yes\
                                </label>\
                                <label>\
                                    <input type="radio" id="no-hosting" value="no" name="hosting">No\
                                </label>\
                            </div>\
                        </div>';
       formContainer.appendChild(div);

}
function removeOptionalElements() {
   var elements = document.getElementsByClassName("optionalElement");
   while(elements.length > 0){
       elements[0].parentNode.removeChild(elements[0]);
   }
}