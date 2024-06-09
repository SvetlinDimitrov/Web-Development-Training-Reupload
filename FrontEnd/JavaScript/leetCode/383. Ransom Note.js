/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function (ransomNote, magazine) {
    let history = {};
    for (let i = 0; i < ransomNote.length; i++) {

        let wordToSearch = ransomNote[i]

        if (history[wordToSearch] === undefined) {
            history[wordToSearch] = magazine.indexOf(wordToSearch);
        } else {
            while (history[wordToSearch] !== -1) {
                history[wordToSearch] = magazine.indexOf(wordToSearch, history[wordToSearch] + 1)
                if (history[wordToSearch] !== -1) break;
            }
        }

        if(history[wordToSearch] === -1) return false;
    }
    return true;
};

// console.log(canConstruct("a", "b")); // false
// console.log(canConstruct("aa", "ab")); // false
console.log(canConstruct("aa", "aab")); // true