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
    let currentY = 120;
    const coordinates = {};

    let totalPartners = 0;
    levels.forEach(level => {

        const startX = 0;
        const rowData = data.filter(d => d.level === level-1);
        totalPartners += rowData.reduce((acc, curr) => curr.partner ? acc + 1 : acc, 0);
        let y = currentY * level;

        if(totalPartners !== 0) {
            y += (rectSizeY + gapSize) * totalPartners / 2;
        }

        // const rowData = data.filter(d => d.level === level);
        // const totalWidth = rowData.length * (rectSizeX + gapSize) - gapSize;
        // const startX = (dimensions.width - totalWidth) / 2; // Centering happens here

        coordinates[level] = {x: startX, y};
    });

    return coordinates;
}

function drawNextRectangle(level, g, coordinates, rectSizeX, rectSizeY, gapSize, node, drawnNames, data) {

    const name = node.name;
    const partnerName = node.partner;

    if (coordinates[level] && coordinates[level + 1]) {
        if (coordinates[level].x < coordinates[level + 1].x) {
            coordinates[level].x = coordinates[level + 1].x;
        }
    }

    if (!drawnNames.has(name)) {
        g.append('rect')
            .attr('x', coordinates[level].x)
            .attr('y', coordinates[level].y)
            .attr('width', rectSizeX)
            .attr('height', rectSizeY)
            .attr('fill', 'white')
            .attr('stroke', 'black')
            .attr('stroke-width', 1);

        g.append('text')
            .attr('x', coordinates[level].x + rectSizeX / 2)
            .attr('y', coordinates[level].y + rectSizeY / 2)
            .attr('text-anchor', 'middle')
            .attr('dominant-baseline', 'middle')
            .text(name);

        drawnNames.add(name);
        coordinates[level].x += rectSizeX + gapSize
    }

    if (partnerName && !drawnNames.has(partnerName)) {
        g.append('rect')
            .attr('x', coordinates[level].x)
            .attr('y', coordinates[level].y)
            .attr('width', rectSizeX)
            .attr('height', rectSizeY)
            .attr('fill', 'white')
            .attr('stroke', 'black')
            .attr('stroke-width', 1);

        g.append('text')
            .attr('x', coordinates[level].x + rectSizeX / 2)
            .attr('y', coordinates[level].y + rectSizeY / 2)
            .attr('text-anchor', 'middle')
            .attr('dominant-baseline', 'middle')
            .text(partnerName);

        drawnNames.add(partnerName);
        coordinates[level].x += rectSizeX * 2 + gapSize
    }

    if (node && node.children && node.children.length > 0) {
        node.children.forEach(linkedName => {
            const linkedNode = data.find(d => d.name === linkedName);
            if (linkedNode) {
                g.append('rect')
                    .attr('x', coordinates[linkedNode.level].x)
                    .attr('y', coordinates[linkedNode.level].y)
                    .attr('width', rectSizeX)
                    .attr('height', rectSizeY)
                    .attr('fill', 'white')
                    .attr('stroke', 'black')
                    .attr('stroke-width', 1);

                g.append('text')
                    .attr('x', coordinates[linkedNode.level].x + rectSizeX / 2)
                    .attr('y', coordinates[linkedNode.level].y + rectSizeY / 2)
                    .attr('text-anchor', 'middle')
                    .attr('dominant-baseline', 'middle')
                    .text(linkedNode.name);
            }
            drawnNames.add(linkedNode.name);
            coordinates[linkedNode.level].x += rectSizeX + gapSize

        });

        coordinates[level + 1].x += rectSizeX + gapSize
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
            drawNextRectangle(node.level, g, coordinates, rectSizeX, rectSizeY, gapSize, node, drawnNames, data);
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