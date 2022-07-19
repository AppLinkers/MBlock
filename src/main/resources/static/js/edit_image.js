const defaultBtn = document.querySelector("#selectImg");
const img = document.querySelector("main .right .profile .img img");

function defaultBtnActive(){
    defaultBtn.click();
}

defaultBtn.addEventListener("change",function(){
    const file = this.files[0];
    if(file){
        const reader = new FileReader();
        reader.onload = function(){
            const result = reader.result;
            img.src = result;
            img.classList.toggle("active");
        }
        reader.readAsDataURL(file);
    }
    img.classList.remove("active");

});

//스피너
// const optionMenu = document.querySelector("main .right .select-menu"),
//     selectBtn = optionMenu.querySelector(".select-btn"),
//     options = optionMenu.querySelectorAll(".option"),
//     sBtn_text = optionMenu.querySelector(".sBtn-text");
//
// selectBtn.addEventListener("click", () => optionMenu.classList.toggle("active"));
//
// options.forEach(option => {
//     option.addEventListener("click", () => {
//         let selectedOption = option.querySelector(".option-text").innerText;
//         sBtn_text.innerText = selectedOption;
//
//         optionMenu.classList.remove("active");
//     })
// })