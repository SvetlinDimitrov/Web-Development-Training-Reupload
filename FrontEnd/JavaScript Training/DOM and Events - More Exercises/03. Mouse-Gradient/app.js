function attachGradientEvents() {
    let result = document.getElementById(`result`);
    let input = document.getElementById(`gradient`);
    console.log(input.getBoundingClientRect())
    input.addEventListener('mousemove', getCoords);

    function getCoords(elem) {
        let box = elem.getBoundingClientRect();
        console.log(box)
      }
}