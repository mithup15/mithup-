var myTabs = document.querySelectorAll(".tab");
for (let tab of myTabs) {
    tab.addEventListener("click", function() {
        var cont = tab.nextElementSibling;
        if (cont.style.maxHeight) {
            cont.style.maxHeight = null;
        } else {
            cont.style.maxHeight = cont.scrollHeight + "px";
        }
        tab.classList.toggle("active");
    });
}
