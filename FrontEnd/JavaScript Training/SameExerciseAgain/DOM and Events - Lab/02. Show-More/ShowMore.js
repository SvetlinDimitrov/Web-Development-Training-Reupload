function showText() {
    document.getElementById('more').style.display = 'none';
    document.getElementById('text').style.display = 'inline';
}
let input = document.getElementsByTagName('ul');
console.log(input[0]);
console.log(input[0].children);
console.log(input[0].children.getElementById('mecho'));
