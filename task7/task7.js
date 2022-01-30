function searchFun() {
    var key = document.querySelector("#search").value.toUpperCase();
    var myFood = document.querySelectorAll(".food");
    for (let i = 0; i < myFood.length; i++) {
        var inItems = myFood[i].querySelector("h2").innerText.toUpperCase();
        if (inItems.indexOf(key) > -1) {
            myFood[i].style.display = ""
        } else {
            myFood[i].style.display = "none"
        }
    }
}