const optionMenu = document.querySelector(".select-menu"),
    selectBtn = optionMenu.querySelector(".select-btn"),
    options = optionMenu.querySelectorAll(".option"),
    sBtn_text = optionMenu.querySelector(".sBtn-text");

const role = document.getElementById("role");

const trader_name = document.querySelector(".trader__name");

selectBtn.addEventListener("click", () => optionMenu.classList.toggle("active"));

options.forEach(option => {
    option.addEventListener("click", () => {
        let selectedOption = option.querySelector(".option-text").innerText;
        role.value = selectedOption;
        optionMenu.classList.remove("active");
        trader_name.innerText = selectedOption;
    })
})


// contact에서만
const show = document.getElementById("show");
const non_show = document.getElementById("non-show");
const show_password = document.querySelector(".show-password");
const allow = document.querySelector(".form-allow");

const modal = document.querySelector(".modal");
const close_modal = document.getElementById("close-modal");
const btn_modal = document.querySelector(".modal__btn");

show.addEventListener("click", () => {
    show.classList.add("active");
    non_show.classList.remove("active");
    show_password.classList.remove("active");
})

non_show.addEventListener("click", () => {
    non_show.classList.add("active");
    show.classList.remove("active");
    show_password.classList.add("active");
})

allow.addEventListener("click", () => {
    if (allow.classList.contains("active")) {
        allow.classList.remove("active");
    } else {
        modal.classList.add("active");
    }
})

close_modal.addEventListener("click", () => {
    modal.classList.remove("active");
})

btn_modal.addEventListener("click", () => {
    modal.classList.remove("active");
    allow.classList.toggle("active");
})