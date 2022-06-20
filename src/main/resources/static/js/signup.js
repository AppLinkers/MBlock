const defaultBtn = document.querySelector("#selectImg");
const customBtn = document.querySelector("main .form-group .profile-img");
const img = document.querySelector("main .form-group .profile-img img");

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