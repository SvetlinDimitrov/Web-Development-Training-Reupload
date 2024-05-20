import React from 'react';
import D3Component from './D3Component';

function App() {
    const data = [

        {name: 'A', level: 0, link: ['B'], partner: 'D'},
        {name: 'D', level: 0, link: ['B'], partner: 'A'},
        {name: 'A1', level: 0, link: ['B1' , 'C' , 'C1' , 'C2', 'C3' , 'C4' , 'C5'], partner: 'D1'},
        {name: 'D1', level: 0 , link: ['B1' , 'C' , 'C1' , 'C2', 'C3' , 'C4' , 'C5'], partner: 'A1'},
        {name: 'B', level: 1},
        {name: 'B1', level: 1},
        {name: 'C', level: 1 },
        {name: 'C1', level: 1 },
        {name: 'C2', level: 1 },
        {name: 'C3', level: 1 },
        {name: 'C4', level: 1 },
        {name: 'C5', level: 1 },
        {name: 'C6', level: 1 },
        {name: 'C7', level: 1 },
        {name: 'C8', level: 1 },
        {name: 'C9', level: 1 },
        {name: 'C10', level: 1 },
        {name: 'C11', level: 1 },
        // {name: 'C1', level: 2 },
        // {name: 'C2', level: 2 },
    ];

    return <D3Component data={data}/>;
}

export default App;