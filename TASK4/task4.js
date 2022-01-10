var selectedRow = null

function onFormSubmit() {
    if (validate()) {
        var formData = readFormData();
        if (selectedRow == null)
            insertNewRecord(formData);
        else
            updateRecord(formData);
        resetForm();
    }
}
function state() { 
            var result = document.getElementById("state").value; 
            alert(result);
        } 


function readFormData() {
    var formData = {};
    formData["fullName"] = document.getElementById("fullName").value;
    formData["Phonenumber"] = document.getElementById("Phonenumber").value;
    formData["email"] = document.getElementById("email").value;
    formData["salary"] = document.getElementById("salary").value;
    formData["state"] = document.getElementById("state").value;
    formData["city"] = document.getElementById("city").value;
    if(document.getElementById("male").checked){
        formData["gender"] =document.getElementById("male").value;    
    }
    else if(document.getElementById("female").checked){
        formData["gender"] =document.getElementById("female").value;    
    }
    else{
        formData["gender"] =document.getElementById("others").value;    
    }
    console.log(document.getElementById("male").value);
    return formData;
}

function insertNewRecord(data) {
    var table = document.getElementById("empdetails").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.fullName;
    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.Phonenumber;
    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.email;
    cell4 = newRow.insertCell(3);
    cell4.innerHTML = data.salary;
    cell5 = newRow.insertCell(4);
    cell5.innerHTML = data.state;
    cell6 = newRow.insertCell(5);
    cell6.innerHTML = data.city;
    cell7 = newRow.insertCell(6);
    cell7.innerHTML = data.gender;
    cell8 = newRow.insertCell(7);
    cell8.innerHTML = `<a onClick="onEdit(this)">Edit</a>
                       <a onClick="onDelete(this)">Delete</a>`;
    
}

function resetForm() {
    document.getElementById("fullName").value = "";
    document.getElementById("Phonenumber").value = "";
    document.getElementById("email").value = "";
    document.getElementById("salary").value = "";
    document.getElementById("state").value = "";
    document.getElementById("city").value = "";
    document.getElementById("gender").value = "";
    selectedRow = null;
}

function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("fullName").value = selectedRow.cells[0].innerHTML;
    document.getElementById("Phonenumber").value = selectedRow.cells[1].innerHTML;
    document.getElementById("email").value = selectedRow.cells[2].innerHTML;
    document.getElementById("salary").value = selectedRow.cells[3].innerHTML;
    document.getElementById("state").value = selectedRow.cells[4].innerHTML;
    document.getElementById("city").value = selectedRow.cells[5].innerHTML;
    document.getElementById("gender").value = selectedRow.cells[5].innerHTML;
}
function updateRecord(formData) {
    selectedRow.cells[0].innerHTML = formData.fullName;
    selectedRow.cells[1].innerHTML = formData.Phonenumber;
    selectedRow.cells[2].innerHTML = formData.email;
    selectedRow.cells[3].innerHTML = formData.salary;
    selectedRow.cells[4].innerHTML = formData.state;
    selectedRow.cells[5].innerHTML = formData.city;
    selectedRow.cells[6].innerHTML = formData.gender;

}

function onDelete(td) {
    if (confirm('Are you ready to take risk ?')) {
        row = td.parentElement.parentElement;
        document.getElementById("empdetails").deleteRow(row.rowIndex);
        resetForm();
    }
}
function validate() {
    isValid = true;
    if (document.getElementById("fullName").value == "") {
        isValid = false;
        document.getElementById("fullNameValidationError").classList.remove("hide");
    } else {
        isValid = true;
        if (!document.getElementById("fullNameValidationError").classList.contains("hide"))
            document.getElementById("fullNameValidationError").classList.add("hide");
    }
    return isValid;
}