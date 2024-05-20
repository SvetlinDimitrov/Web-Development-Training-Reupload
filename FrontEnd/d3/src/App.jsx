import React from 'react';
import D3Component from './D3Component';

function App() {
    const data = [

        {name: 'A', level: 0, link: ['B' , 'B0'], partner: 'D'},
        {name: 'D', level: 0, link: ['B' , 'B0'], partner: 'A'},
        {name: 'A1', level: 0, link: ['B1' , 'C' , 'C1' , 'C2', 'C3' , 'C4' , 'C5' , 'C6' , 'C7' , 'C8' ,'C9' , 'C10'], partner: 'D1'},
        {name: 'D1', level: 0 ,  link: ['B1' , 'C' , 'C1' , 'C2', 'C3' , 'C4' , 'C5' , 'C6' , 'C7' , 'C8' ,'C9' , 'C10'], partner: 'A1'},
        {name: 'B', level: 1},
        {name: 'B0', level: 1},
        {name: 'B1', level: 1},
        {name: 'C', level: 1 },
        {name: 'C1', level: 1 },
        {name: 'C2', level: 1 },
        {name: 'C3', level: 1 , partner: 'C11' , link: ['C12' , 'C13' , 'C14' , 'C16' , 'C17' , 'C18' , 'C19']},
        {name: 'C4', level: 1 },
        {name: 'C5', level: 1 },
        {name: 'C6', level: 1 },
        {name: 'C7', level: 1 },
        {name: 'C8', level: 1 },
        {name: 'C9', level: 1 },
        {name: 'C10', level: 1 },
        {name: 'C11', level: 1 , partner: 'C3' , link: ['C12' , 'C13' , 'C14' , 'C16' , 'C17' , 'C18' , 'C19']},
        {name: 'C12', level: 2 },
        {name: 'C13', level: 2 },
        {name: 'C14', level: 2 },
        {name: 'C16', level: 2 },
        {name: 'C17', level: 2 },
        {name: 'C18', level: 2 },
        {name: 'C19', level: 2 },
        {name: 'C20', level: 2 },
        {name: 'C21', level: 2 },

        // {name: 'C1', level: 2 },
        // {name: 'C2', level: 2 },
    ];

    return <D3Component data={data}/>;
}

export default App;