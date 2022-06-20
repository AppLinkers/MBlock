const defaultBtn = document.querySelector("#selectImg");
const customBtn = document.querySelector("main .form-group .profile-img");
const img = document.querySelector("main .form-group .profile-img img");

function defaultBtnActive(){
    defaultBtn.click();
}

function nullCheck(){
    const name = document.getElementById("name").value;
    const id = document.getElementById("id").value;
    const pw = document.getElementById("password").value;
    const pwcheck = document.getElementById("password-confirm").value;
    const position = document.getElementById("name").value;
    const phone = document.getElementById("name").value;
    const selectImg = document.getElementById("selectImg").value;

    if(name=="" || id=="" ||pw=="" || pwcheck=="" || position=="" || phone =="" || selectImg==""){
        alert("빈 칸이 있습니다. 다시 한번 확인해주세요.");
    }
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