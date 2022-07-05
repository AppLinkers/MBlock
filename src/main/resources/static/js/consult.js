const optionMenu = document.querySelector("section .board-main .right .select-menu"),
        selectBtn = optionMenu.querySelector(".select-btn"),
        options = optionMenu.querySelectorAll(".option"),
        sBtn_text = optionMenu.querySelector(".sBtn-text");

const traderInput = document.getElementById("traderInput");
const name = document.getElementById("name");
const email = document.getElementById("email");
const phone = document.getElementById("phone");
const content = document.getElementById("content")
selectBtn.addEventListener("click", () => optionMenu.classList.toggle("active"));

options.forEach(option => {
    option.addEventListener("click", () => {
        let selectedOption = option.querySelector(".option-text").innerText;
       // sBtn_text.innerText = selectedOption;
        traderInput.value= selectedOption;
        optionMenu.classList.remove("active");
    })
})



function nullCheck(){
    if(name != "" && email!= "" && phone != "" && traderInput != ""&& content != ""){
        alert("상담 제출이 완료되었습니다. 빠른 시일 내로 연락드리겠습니다!")
    }
}

