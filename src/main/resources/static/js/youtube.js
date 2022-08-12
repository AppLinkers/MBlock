const youtube_edit = document.querySelector("main .right .edit");
const edit_close = document.querySelector("main .right .edit .close i");
const edit_btn = document.getElementById("edit");
const on_air = document.querySelector("main .right .edit .edit-info .name p");
const long_btn =document.getElementById("long");
const short_btn =document.getElementById("short");
//수정하기
edit_btn.addEventListener("click", ()=>{
    youtube_edit.classList.toggle("active");
})
//닫기 버튼
edit_close.addEventListener("click", ()=>{
    youtube_edit.classList.remove("active");
})
//onAir
on_air.addEventListener("click", ()=>{
    on_air.classList.toggle("active")
})
//position
long_btn.addEventListener("click", ()=>{
    long_btn.classList.add("active");
    short_btn.classList.remove("active");
})
short_btn.addEventListener("click", ()=>{
    long_btn.classList.remove("active");
    short_btn.classList.add("active");
})




