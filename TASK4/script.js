function onformsubmit(){
     var formdata=readformdata();
     insertNewRecord(formdata);
}
function readformdata(){
    var formdata={};
    formdata["name"]= document.getElementById("name").Value;
    formdata["fname"]= document.getElementById("fname").Value;
    formdata["empid"]= document.getElementById("empid").Value;
    formdata["birth"]= document.getElementById("birth").Value;
    formdata["state"]= document.getElementById("state").Value;
    return formdata;
}
function insertNewRecord(data){
    var table= document.getElementById("employeelist").getElementsByTagName('tbody')[0];
    var newRow= table.newRow(table.length);
    cell1= newRow.insertCell(0);
    cell1.innerHTML=data.name;
    cell2= newRow.insertCell(1);
    cell2.innerHTML=data.fname;
    cell3= newRow.insertCell(2);
    cell3.innerHTML=data.empid;
    cell4= newRow.insertCell(3);
    cell4.innerHTML=data.birth;
    cell5= newRow.insertCell(4);
    cel5.innerHTML=data.state;
    cell5= newRow.insertCell(5);
    cel5.innerHTML="<a>Edit</a>";
    cel5.innerHTML="<a>Delete</a>";
}