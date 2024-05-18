import React from 'react';
import D3Component from './D3Component';

function App() {
    const data = [

        {name: 'A', level: 0, link: ['B']},
        {name: 'D', level: 0, link: ['B']},
        {name: 'A1', level: 0, link: ['B1']},
        {name: 'D1', level: 0, link: ['B1']},
        {name: 'B', level: 1 , link: ['C', 'C1', 'C2']},
        {name: 'B1', level: 1, link: ['C' , 'C1', 'C2']},
        {name: 'C', level: 2 },
        {name: 'C1', level: 2 },
        {name: 'C2', level: 2 },
    ];

    return <D3Component data={data}/>;
}

export default App;