const valueDiv = document.querySelector("#copy-email");
const copyText = valueDiv.textContent;
const copyIcon = valueDiv.querySelector("i");
const textArea = document.createElement('textarea');



copyIcon.addEventListener("click", () => {
    document.body.appendChild(textArea);
    textArea.value = copyText;
    textArea.select();
    document.execCommand('copy');
    document.body.removeChild(textArea);

    alert("복사되었습니다");
})
