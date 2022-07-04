const modal = document.querySelector("main .right .modal");
const deleteBtns = document.querySelectorAll("main .right .list ul li .control-delete");
const xBtn = modal.querySelector("i");

const modalAccept = document.querySelector("main .right .modal-accept");
const acceptBtns = document.querySelectorAll("main .right .list ul li .control-accept");
const xBtnAccept = modalAccept.querySelector("i");


//삭제 버튼
deleteBtns.forEach(deleteBtn => {
    deleteBtn.addEventListener('click',()=> {
        modal.style.display = "block";
    })
})
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

//승인 버튼
acceptBtns.forEach(acceptBtn => {
    acceptBtn.addEventListener('click',()=> {
        modalAccept.style.display = "block";
    })
})
xBtnAccept.onclick = function(){
    modalAccept.style.display = "none";
}