import React from 'react';
import D3Component from './D3Component';

function App() {
    let data1 = [
        {id: '8', level: 1, children: ['12', '13', '14', '15'], info: {name: 'CD2'}, partner: '11'},
        {id: '9', level: 2, children: [], info: {name: 'AB1CD11'} , partner: '16'},
        {id: '10', level: 2, children: [], info: {name: 'AB1CD12'}},
        {id: '11', level: 1, children: [], info: {name: 'E'}},
        {id: '12', level: 2, children: [], info: {name: 'CD2E1'}},
        {id: '13', level: 2, children: [], info: {name: 'CD2E2'}},
        {id: '14', level: 2, children: [], info: {name: 'CD2E3'}},
        {id: '15', level: 2, children: [], info: {name: 'CD2E4'}},
        {id: '16', level: 2, children: [], info: {name: 'R'}},
        {id: '1', level: 0, children: ['5', '6'], partner: '2', info: {name: 'A'}},
        {id: '2', level: 0, children: [], info: {name: 'B'}},
        {id: '3', level: 0, children: ['7', '8'], partner: '4', info: {name: 'C'}},
        {id: '4', level: 0, children: [], info: {name: 'D'}},
        {id: '5', level: 1, children: ['9', '10'], info: {name: 'AB1'}, partner: '7'},
        {id: '6', level: 1, children: [], info: {name: 'AB2'}},
        {id: '7', level: 1, children: [], info: {name: 'CD1'}},
    ];
    data1 = data1.map(item => {
        const {level, ...rest} = item;
        return rest;
    });

    const depthMap = {};

    data1.forEach((node, index) => {
        if (!depthMap[node.id]) {
            depthMap[node.id] = dfs(node, index);
        }
    });

    data1.forEach(node => {
        if (node.children) {
            let maxChildLevel = Math.max(...node.children.map(childId => depthMap[childId]));
            node.children.forEach(childId => {
                depthMap[childId] = maxChildLevel;
            });
        }
    });

    const maxDepth = Math.max(...Object.values(depthMap));

    data1.forEach(node => {
        node.level = maxDepth - depthMap[node.id];
    });

    return <D3Component data={data1}/>;

    function dfs(node) {
        if (depthMap[node.id] !== undefined) {
            return depthMap[node.id];
        }

        let level = 0;

        if (node.children) {
            node.children.forEach(childId => {
                const childIndex = data1.findIndex(item => item.id === childId);
                if (childIndex !== -1) {
                    level = Math.max(level, 1 + dfs(data1[childIndex], childIndex));
                }
            });
        }

        depthMap[node.id] = level;

        if (node.partner && depthMap[node.partner] === undefined) {
            depthMap[node.partner] = level;
        }

        return level;
    }
}

export default App;