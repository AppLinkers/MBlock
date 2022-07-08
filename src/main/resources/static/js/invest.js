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





function upbitView(){
    upBitDiv.style.display="block";
    binanceDiv.style.display="none";
}