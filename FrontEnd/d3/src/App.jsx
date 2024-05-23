import React from 'react';
import D3Component from './D3Component';

function App() {
    const data1 = [

        {
            name: 'A',
            level: 0,
            children: ['AD1', 'AD2'],
            partner: 'D'
        },
        {
            name: 'A1',
            level: 0,
            children: ['A1D11', 'A1D12', 'A1D13'],
            partner: 'D1'
        },
        {name: 'AD1', level: 1, partner: 'D0', children: ['AD1D01', 'AD1D02']},
        {name: 'AD2', level: 1, partner: 'D1', children: ['AD2D11', 'AD2D12']},
        {name: 'A1D11', level: 1, partner: 'D2'},
        {name: 'A1D12', level: 1},
        {name: 'A1D13', level: 1},
        {name: 'AD1D01', level: 2},
        {name: 'AD1D02', level: 2},
        {name: 'AD2D11', level: 2, partner: 'K', children: ['AD2D11K1', 'AD2D11K2']},
        {name: 'AD2D12', level: 2},
        {name: 'AD2D11K1', level: 3},
        {name: 'AD2D11K2', level: 3},
    ];
    return <D3Component data={data1}/>;
}

export default App;