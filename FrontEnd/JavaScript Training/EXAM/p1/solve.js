function solve(arr){
    let tasks = {};
    let assignees = {};
   

    let n = Number(arr.splice(0,1));
    for (let i = 0; i < n; i++) {
        let input = arr[i].split(":");
        tasks[input[1]] = {title : input[2] , status : input[3] , estimatedPoints : input[4]};
        assignees[input[0]] = [input[1]];
    }
    for (let i = n; i < arr.length; i++) {
        let input = arr[i].split(":");
        let command = input[0];
        let assignee = input[1];

        if(command === "Add New"){
            if(assignees.hasOwnProperty(assignee)){
                tasks[input[2]] = {title : input[3] , status : input[4] , estimatedPoints : input[5]};
                assignees[assignee].push(input[2]);
            }else{
                console.log(`Assignee ${assignee} does not exist on the board!`);
            }
        }else if (command === "Change Status"){
            if(assignees.hasOwnProperty(assignee)){
                if(tasks.hasOwnProperty(input[2])){
                    tasks[input[2]].status = input[3];
                }else{
                    console.log(`Task with ID ${input[2]} does not exist for ${assignee}!`)
                }
            }else{
                console.log(`Assignee ${assignee} does not exist on the board!`)
            }
        }else if (command === "Remove Task"){
            if(assignees.hasOwnProperty(assignee)){
                let arr = assignees[assignee];
                if(arr.length < Number(input[2])){
                    console.log("Index is out of range!");
                }else{
                    delete tasks[assignees[assignee][Number(input[2])-1]];
                    arr.splice(Number(input[2])-1 , 1);
                    assignees[assignee] = arr;
                }
            }else{
                console.log(`Assignee ${assignee} does not exist on the board!`)
            }
        }
    }
        let answer = {
            'ToDo' : 0,
            'In Progress' : 0,
            'Code Review' : 0,
            'Done' : 0
        }
       for (let {status , estimatedPoints} of Object.values(tasks)) {
        answer[status] = Number(answer[status]) + Number(estimatedPoints);
       }
        console.log(`ToDo: ${answer['ToDo']}pts`);
        console.log(`In Progress: ${answer['In Progress']}pts`);
        console.log(`Code Review: ${answer['Code Review']}pts`);
        console.log(`Done Points: ${answer['Done']}pts`);

        let allPoints = Number(answer['ToDo']) 
                        + Number(answer['In Progress'])+Number(answer['Code Review']);
        if(allPoints > Number(answer['Done'])){
            console.log(`Sprint was unsuccessful...`);
        }else{
            console.log(`Sprint was successful!`);
        }
}
   

solve( [
    '4',
    'Kiril:BOP-1213:Fix Typo:Done:1',
    'Peter:BOP-1214:New Products Page:In Progress:2',
    'Mariya:BOP-1215:Setup Routing:ToDo:8',
    'Georgi:BOP-1216:Add Business Card:Code Review:3',
    'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
    'Change Status:Georgi:BOP-1216:Done',
    'Change Status:Will:BOP-1212:In Progress',
    'Remove Task:Georgi:3',
    'Change Status:Mariya:BOP-1215:Done',
])