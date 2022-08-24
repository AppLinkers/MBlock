const youtube_edit = document.querySelector("main .right .edit");
const edit_close = document.querySelector("main .right .edit .close i");
// const edit_btn = document.getElementsByClassName("editBtn");
const on_air = document.querySelector("main .right .edit .edit-info .name p");
const long_btn =document.getElementById("long");
const short_btn =document.getElementById("short");
const isOnAir = document.getElementById("isOnAir");
const youtubeTitle = document.getElementById("youtubeTitle");
const onAirInput =document.getElementById("onAirInput");



//닫기 버튼
edit_close.addEventListener("click", ()=>{
    youtube_edit.classList.remove("active");
})
//onAir
on_air.addEventListener("click", ()=>{
    on_air.classList.toggle("active");
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




