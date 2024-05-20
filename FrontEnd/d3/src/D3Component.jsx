import {useEffect, useRef, useState} from 'react';
import * as d3 from 'd3';
import PropTypes from 'prop-types';

function handleResize(setDimensions) {
    setDimensions({
        width: window.innerWidth,
        height: window.innerHeight
    });
}

function addZooming(svg, g) {
    svg.call(d3.zoom().on("zoom", function (event) {
        g.attr("transform", event.transform)
    }));
}

function calculateAvailableCoordinates(data, dimensions, rectSizeX, rectSizeY, gapSize) {
    const levels = [...new Set(data.map(d => d.level))];
    const yScale = d3.scaleBand().domain(levels).range([0, dimensions.height]).padding(0.1);

    const coordinates = {};
    levels.forEach(level => {
        const rowData = data.filter(d => d.level === level);
        const totalWidth = rowData.length * (rectSizeX + gapSize) - gapSize;
        // const startX = 0;
        const y = yScale(level);
        const startX = (dimensions.width - totalWidth) / 2; // Centering happens here


        coordinates[level] = {x: startX, y};
    });

    return coordinates;
}

function drawNextRectangle(level, g, coordinates, rectSizeX, rectSizeY, gapSize, name, drawnNames, data) {
    const nextCoordinate = coordinates[level];

    if (!nextCoordinate) {
        throw new Error(`No available coordinates for level ${level}`);
    }

    if (drawnNames.has(name)) {
        return;
    }

    g.append('rect')
        .attr('x', nextCoordinate.x)
        .attr('y', nextCoordinate.y)
        .attr('width', rectSizeX)
        .attr('height', rectSizeY)
        .attr('fill', 'white')
        .attr('stroke', 'black')
        .attr('stroke-width', 1);

    g.append('text')
        .attr('x', nextCoordinate.x + rectSizeX / 2)
        .attr('y', nextCoordinate.y + rectSizeY / 2)
        .attr('text-anchor', 'middle')
        .attr('dominant-baseline', 'middle')
        .text(name);

    drawnNames.add(name);

    const node = data.find(d => d.name === name);
    if (node && node.partner && drawnNames.has(node.partner)) {
        coordinates[level].x = coordinates[level + 1].x;
    } else {
        coordinates[level].x += rectSizeX + gapSize;
    }

    if (node && node.link) {
        node.link.forEach(linkedName => {
            const linkedNode = data.find(d => d.name === linkedName);
            if (linkedNode) {
                drawNextRectangle(linkedNode.level, g, coordinates, rectSizeX, rectSizeY, gapSize, linkedName, drawnNames, data);
            }
        });
        coordinates[level + 1].x += 150;
    }
}

function D3Component({data}) {
    const ref = useRef();
    const [dimensions, setDimensions] = useState({
        width: window.innerWidth,
        height: window.innerHeight
    });

    data.sort((a, b) => {
        if (a.level === b.level) {
            return b.link?.length - a.link?.length;
        }
        return a.level - b.level;
    });

    useEffect(() => {
        window.addEventListener('resize', () => handleResize(setDimensions));

        return () => {
            window.removeEventListener('resize', () => handleResize(setDimensions));
        };
    }, []);

    useEffect(() => {
        d3.select(ref.current).selectAll("*").remove();

        const rectSizeX = 150;
        const rectSizeY = 60;
        const gapSize = 40;

        const svg = d3.select(ref.current)
            .append('svg')
            .attr('width', dimensions.width)
            .attr('height', dimensions.height);

        const g = svg.append('g');

        addZooming(svg, g);

        const coordinates = calculateAvailableCoordinates(data, dimensions, rectSizeX, rectSizeY, gapSize);

        const drawnNames = new Set();

        data.forEach(node => {
            drawNextRectangle(node.level, g, coordinates, rectSizeX, rectSizeY, gapSize, node.name, drawnNames, data);
        });
    }, [data, dimensions]);

    return <div ref={ref} style={{width: '100%', height: '100%', overflow: 'auto'}}></div>;
}

D3Component.propTypes = {
    data: PropTypes.arrayOf(PropTypes.shape({
        level: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
        link: PropTypes.arrayOf(PropTypes.string),
        partner: PropTypes.string,
    })).isRequired,
};

export default D3Component;