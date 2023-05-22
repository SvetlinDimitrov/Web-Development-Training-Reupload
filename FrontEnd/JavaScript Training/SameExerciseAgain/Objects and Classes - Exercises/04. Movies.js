function solve(input){
    let answer = {};
    for(let i = 0 ; i < input.length ; i++){
        let addMovie = input[i].split("addMovie ");
        let directedBy = input[i].split(" directedBy ");
        let onDate = input[i].split(" onDate ");

        if(addMovie.length != 1){
            answer[addMovie[1]] = {name:addMovie[1]};
        }
        if(directedBy.length != 1){
            if(answer.hasOwnProperty(directedBy[0])){
                answer[directedBy[0]]['director'] = directedBy[1];
            }
            
        }
        if(onDate.length != 1){
            if(answer.hasOwnProperty(onDate[0])){
                answer[onDate[0]]['date'] = onDate[1];
            }
        }
    }
    Object.entries(answer).forEach(e=>{
        if(e[1].hasOwnProperty(`director`)){
            if(e[1].hasOwnProperty(`date`)){
                
                    console.log(JSON.stringify(e[1]));
                
            }
        }
    })
}
solve([
    'addMovie The Avengers',
    'addMovie Superman',
    'The Avengers directedBy Anthony Russo',
    'The Avengers onDate 30.07.2010',
    'Captain America onDate 30.07.2010',
    'Captain America directedBy Joe Russo'
    ]);