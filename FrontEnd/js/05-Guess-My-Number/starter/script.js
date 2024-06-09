'use strict';

// Defining the secret number
let secretNumber = document.querySelector('.number');
let secretNumberValue;
setNewSecretNumber();

let body = document.querySelector('body');
let guess = document.querySelector('.guess');
let message = document.querySelector('.message');
let score = document.querySelector('.score');
let highscore = document.querySelector('.highscore');

// Event listener for the button
let button = document.querySelector('.check');
button.addEventListener('click', function() {

  let guessedNumber = Number(guess.value);

  if (gameOver()) {
    if (secretNumberValue === guessedNumber) {
      message.textContent = '🎉🎉🎉 Correct Number!';
      highscore.textContent = (Math.max(Number(score.textContent), Number(highscore.textContent))).toString();
      body.setAttribute('style', 'background-color: #60b347;');
      secretNumber.textContent = secretNumberValue.toString();
    } else if (guessedNumber && secretNumberValue > guessedNumber) {
      message.textContent = '📉 Too Low!';
      decreaseScore();
    } else if (guessedNumber && secretNumberValue < guessedNumber) {
      message.textContent = '📈 Too High!';
      decreaseScore();
    } else {
      message.textContent = '❌ Invalid Input!';
      decreaseScore();
    }
  } else {
    message.textContent = 'The game is over!';
  }
});

let buttonAgain = document.querySelector('.again');
buttonAgain.addEventListener('click', function() {
  setNewSecretNumber();
  score.textContent = '20';
  guess.value = '';
  message.textContent = 'Start guessing...';
  body.setAttribute('style', 'background-color: #222;');
});

function decreaseScore() {
  let scoreValue = Number(score.textContent);
  scoreValue--;
  if (scoreValue <= 0) {
    scoreValue = 0;
    message.textContent = '😢 You Lost!';
  }
  score.textContent = scoreValue.toString();
}

function setNewSecretNumber() {
  secretNumberValue = Math.trunc(Math.random() * 20) + 1;
  secretNumber.textContent = '?';
}

function gameOver() {
  if (score.textContent !== '0') {
    if (
      message.textContent === '🎉🎉🎉 Correct Number!' ||
      message.textContent === 'The game is over!' ||
      message.textContent === '😢 You Lost!') {
      return false;
    }
  }else {
    return false;
  }
  return true;
}