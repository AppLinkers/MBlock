const modal = document.querySelector("main .right .modal");
const deleteBtn = document.querySelector("main .right .list ul li .control-delete");
const xBtn = modal.querySelector("i");

const modalAccept = document.querySelector("main .right .modal-accept");
const acceptBtn = document.querySelector("main .right .list ul li .control-accept");
const xBtnAccept = modalAccept.querySelector("i");

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
    else if(event.target == modalAccept){
        modalAccept.style.display = "none";
    }
}

acceptBtn.onclick = function() {
    modalAccept.style.display = "block";
}
xBtnAccept.onclick = function(){
    modalAccept.style.display = "none";
}