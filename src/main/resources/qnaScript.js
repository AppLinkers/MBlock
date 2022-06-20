const list = document.querySelector("section .board-main .right ul li"),
    title = list.querySelector(".list-title"),
    content = list.querySelector(".list-content"),
    icon = title.querySelector("i");

title.addEventListener("click", ()=> title.classList.toggle("active"));