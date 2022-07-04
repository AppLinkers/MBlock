const modal = document.querySelector("main .right .modal");
const deleteBtn = document.querySelector("#delete");
const xBtn = modal.querySelector("i");


deleteBtn.onclick = function() {
    modal.style.display = "block";
}
xBtn.onclick = function(){
    modal.style.display = "none";
}
window.onclick = function(event){
    if(event.target == modal){
        modal.style.display = "none";
    }
}

