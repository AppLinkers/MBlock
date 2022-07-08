//올라가는 숫자
(function(){
    const counters =document.querySelectorAll('.profit .profit-inner h3 span');

    for(let n of counters){
        const updateCount = () => {
            const target = +n.getAttribute('data-target');
            const count = +n.innerText;
            const speed = 5000;
            const inc = target / speed;
            if(count < target){
                n.textContent = Math.ceil(count + inc);
                setTimeout(updateCount,1);
            } else{
                n.innerText = target;
            }
        }

        updateCount();
    }
})();

// 업비트 아니면 바이낸스 보여주기
const upbit = document.querySelector("section .control .control-upbit");
const binance =document.querySelector("section .control .control-binance");

upbit.addEventListener("click", ()=> {
    upbit.classList.add("active");
    binance.classList.remove("active");
})
binance.addEventListener("click", ()=> {
    upbit.classList.remove("active");
    binance.classList.add("active");
})

const currency = document.querySelector("section .currency .currency-inner .currency-select");

function upbitView(){
    upBitDiv.style.display="block";
    binanceDiv.style.display="none";
}

