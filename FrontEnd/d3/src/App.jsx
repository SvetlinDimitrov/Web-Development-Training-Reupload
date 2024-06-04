import React, { useEffect } from 'react';
import D3Component from './D3Component';
import {DataProvider, DataContext} from './DataProvider';

function App() {
    return (
        <DataProvider>
            <DataWrapper/>
        </DataProvider>
    );
}

function DataWrapper() {
    const {data, setData} = React.useContext(DataContext);
    let data1 = [
        {id: '1', level: 0, children: [], info: {name: 'A'}},
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

    useEffect(() => {
        setData(data1);
    }, [setData]);

    return <D3Component/>;

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