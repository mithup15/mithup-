function searchFun()
{
    var key = document.querySelector("#search").value.toUpperCase();
    var myFood = document.querySelectorAll(".food");
    for (let myfood of this.myFood) {
        var inItems = myfood.querySelector("h2").innerText.toUpperCase();
        if (inItems.indexOf(key) > -1){
            myfood.style.display = "";
        } 
        else {
            myfood.style.display = "none";
        }
    }
}
