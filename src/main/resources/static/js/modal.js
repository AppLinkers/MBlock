const modal = document.querySelector("main .right .modal");
const deleteBtns = document.querySelectorAll("#delete");
const xBtn = modal.querySelector("i");

deleteBtns.forEach(deleteBtn => {
    deleteBtn.addEventListener('click', ()=> {
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
}

