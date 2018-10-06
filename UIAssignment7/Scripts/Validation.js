var error = new Map();

function firstNameValidate() {
    var inputValue = document.getElementById("first-name").value;
    var regexpression = new RegExp("^([a-zA-Z]{2,})$");
    if(inputValue==""){
        document.getElementById("first-name").style.border="solid thin red";
        error.set("First Name", "First Name is required.");
        return false;
    }
    else if (regexpression.test(inputValue)) {
        document.getElementById("first-name").style.border="solid thin blue";
        return true;
    } else {
        document.getElementById("first-name").style.border="solid thin red";
        error.set("First Name", "First Name is invalid. First Name length should be minimum 2 alphabets.");
        return false;
    }
}

function lastNameValidate() {
    var inputValue = document.getElementById("last-name").value;
    var regexpression = new RegExp("^([a-zA-Z]{2,})$");
    if(inputValue==""){
        document.getElementById("last-name").style.border="solid thin red";
        error.set("Last Name", "Last Name is required. ");
        return false;
    }
    else if (regexpression.test(inputValue)) {
        document.getElementById("last-name").style.border="solid thin blue";
        return true;
    } else{
        document.getElementById("last-name").style.border="solid thin red";
        error.set("Last Name", "Last Name is invalid. Last Name length should be minimum 2 alphabets.");
        return false;
    }
}

function emailValidate() {
    var inputValue = document.getElementById("email").value;
    var regexpression = new RegExp("^^([a-zA-Z0-9_\.]{2,})@([a-zA-Z0-9_]{2,})\.([a-zA-Z]{2,5})$");
    if(inputValue==""){
        document.getElementById("email").style.border="solid thin red";
        error.set("Email", "E-mail is required");
        return false;
    }
    else if (regexpression.test(inputValue)) {
        document.getElementById("email").style.border="solid thin blue";
        return true;
    } else {
        document.getElementById("email").style.border="solid thin red";
        error.set("Email", "E-mail is invalid");
        return false;
    }
}

function phoneValidate() {
    var inputValue = document.getElementById("phone").value;
    var regexpression = new RegExp("^([0-9]{10,12})$");
    if(inputValue==""){
        document.getElementById("phone").style.border="solid thin red";
        error.set("Phone", "Phone is required");
        return false;
    }
    else if (regexpression.test(inputValue)) {
        document.getElementById("phone").style.border="solid thin blue";
        return true;
    } else {
        document.getElementById("phone").style.border="solid thin red";
        error.set("Phone", "Phone number is invalid. Phone number length should be of 10-12 digits.");
        return false;
    }
}

function addressValidate(){
    var inputValue = document.getElementById("address").value;
    if(inputValue==""){
        document.getElementById("address").style.border="solid thin red";
        error.set("Address", "Address is required");
        return false;
    }
    else{
        document.getElementById("address").style.border="solid thin blue";
        return true;
    }
}

function cityValidate() {
    var inputValue = document.getElementById("city").value;
    var regexpression = new RegExp("^([a-zA-Z]{2,})$");
    if(inputValue==""){
        document.getElementById("city").style.border="solid thin red";
        error.set("City", "City name is required");
        return true;
    }
    else if (regexpression.test(inputValue)) {
        document.getElementById("city").style.border="solid thin blue";
        return true;
    } else {
        document.getElementById("city").style.border="solid thin red";
        error.set("City", "City Name is invalid. City name should be of minimum 2 alphabets.");
        return false;
    }
}

function websiteValidate() {
    var inputValue = document.getElementById("website").value;
    var regexpression = new RegExp("^([a-zA-Z]{2,})$");
    if(inputValue==""){
        document.getElementById("website").style.border="solid thin red";
        error.set("Website Name", "website Name is required");
        return false;
    }
    else if (regexpression.test(inputValue)) {
        document.getElementById("website").style.border="solid thin blue";
        return true;
    } else {
        document.getElementById("website").style.border="solid thin red";
        error.set("Website", "Website is invalid. Website name should be of minimum 2 alphabets");
        return false;
    }
}

function projectValidate() {
    var inputValue = document.getElementById("project").value;
    var regexpression = new RegExp("^([a-zA-Z]{2,})$");
    if(inputValue==""){
        document.getElementById("project").style.border="solid thin red";
        error.set("Project Name", "Project Name is required");
        return false;
    }
    else if (regexpression.test(inputValue)) {
        document.getElementById("project").style.border="solid thin blue";
        return true;
    } else {
        document.getElementById("project").style.border="solid thin red";
        error.set("Project", "Project description is invalid. Project description should be of minimum 2 alphabets");
        return false;
    }
}

function zipCodeValidate() {
    var inputValue = document.getElementById("zip-code").value;
    var regexpression = new RegExp("^([0-9]{6})$");
    if(inputValue==""){
        document.getElementById("zip-code").style.border="solid thin red";
        error.set("Zip Code", "Zip Code is required");
        return false;
    }
    else if (regexpression.test(inputValue)) {
        document.getElementById("zip-code").style.border="solid thin blue";
        return true;
    } else {
        document.getElementById("zip-code").style.border="solid thin red";
        error.set("Zip Code", "Zip Code is invalid. Zip Code should be of 6 digits.");
        return false;
    }
}

function stateValidate() {
    var inputValue = document.getElementById("State").value;
    if (inputValue == 'n/a') {
        document.getElementById("State").style.border="solid thin red";
        error.set("State", "State Name is required");
        return false;
    } else {
        document.getElementById("State").style.border="solid thin blue";
        return true;
    }
}

function submitForm() {
    error.clear();
    localStorage.clear();
    var state = document.getElementById("State");
    var flag = false;
    if (state.value == "Rajasthan" && (projectValidate() & websiteValidate())) {
        localStorage.setItem("Project", document.getElementById("project").value);
        localStorage.setItem("Website", document.getElementById("website").value);
        flag = true;
    } else if (state.value == "Haryana" && zipCodeValidate()) {
        var yesHosting = document.getElementById("yes-hosting");
        var noHosting = document.getElementById("no-hosting");

        if(yesHosting.checked) {
            localStorage.setItem("Has Hosting", yesHosting.value);
        }
        else if(noHosting.checked) {
            localStorage.setItem("Has Hosting", noHosting.value);
        }
        localStorage.setItem("ZipCode", document.getElementById("zip-code").value);
        flag = true;
    } else if (state.value == "Maharastra" && (zipCodeValidate() & projectValidate())) {
        localStorage.setItem("ZipCode", document.getElementById("zip-code").value);
        localStorage.setItem("Project", document.getElementById("project").value);
        flag = true;
    }
    if (firstNameValidate() & lastNameValidate() & emailValidate() & phoneValidate() & addressValidate() & cityValidate() & stateValidate() & flag) {
        localStorage.setItem("First Name", document.getElementById("first-name").value);
        localStorage.setItem("Last-name", document.getElementById("last-name").value);
        localStorage.setItem("Email", document.getElementById("email").value);
        localStorage.setItem("Phone", document.getElementById("phone").value);
        localStorage.setItem("Address", document.getElementById("address").value);
        localStorage.setItem("City", document.getElementById("city").value);
        localStorage.setItem("State", state.value);
        return true;
    } else {
        var errorKeys = error.keys();
        var message = "";

        for (var key of errorKeys) {
            message = message + key + "-" + error.get(key) + "\n";
        }
        alert(message);
        return false;
    }


}
