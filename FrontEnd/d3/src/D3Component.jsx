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
    let currentY = rectSizeY + gapSize;
    const coordinates = {};

    let totalPartners = 0;
    levels.forEach(level => {

        const startX = 0;
        const rowData = data.filter(d => d.level === level - 1);
        totalPartners += rowData.reduce((acc, curr) => curr.partner ? acc + 1 : acc, 0);
        let y = currentY * level;

        if (totalPartners !== 0) {
            y += (rectSizeY + gapSize) * totalPartners / 2;
        }

        // const rowData = data.filter(d => d.level === level);
        // const totalWidth = rowData.length * (rectSizeX + gapSize) - gapSize;
        // const startX = (dimensions.width - totalWidth) / 2; // Centering happens here

        coordinates[level] = {x: startX, y};
    });

    return coordinates;
}

function drawRectangle(g, coordinates, level, rectSizeX, rectSizeY, id, drawnIds, drawnRectCoordinates, info) {
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
        .text(info.name);

    drawnIds.add(id);
    drawnRectCoordinates[id] = {x: coordinates[level].x, y: coordinates[level].y};
}

function drawNextRectangle(level, g, coordinates, rectSizeX, rectSizeY, gapSize, node, drawnIds, drawnRectCoordinates, data, drawnLines, totalDrawnLines) {
    const id = node.id;
    const partnerId = node.partner;

    if (coordinates[level] && coordinates[level + 1]) {
        if (coordinates[level].x < coordinates[level + 1].x) {
            coordinates[level].x = coordinates[level + 1].x;
        }
    }

    if (!drawnIds.has(id)) {
        drawRectangle(g, coordinates, level, rectSizeX, rectSizeY, id, drawnIds, drawnRectCoordinates, node.info);
        coordinates[level].x += rectSizeX + gapSize;
    }

    if (partnerId && !drawnIds.has(partnerId)) {
        const partner = data.find(d => d.id === partnerId);
        drawRectangle(g, coordinates, level, rectSizeX, rectSizeY, partnerId, drawnIds, drawnRectCoordinates, partner.info);
        coordinates[level].x += rectSizeX * 2 + gapSize;
    }

    if (node && node.children && node.children.length > 0) {
        node.children.forEach(childId => {
            const child = data.find(d => d.id === childId);
            if (child) {
                drawRectangle(g, coordinates, child.level, rectSizeX, rectSizeY, childId, drawnIds, drawnRectCoordinates , child.info);
                coordinates[child.level].x += rectSizeX + gapSize;
            }
        });
        coordinates[level + 1].x += rectSizeX + gapSize;
    }

    drawHorizontalAndVerticalLine();

    function drawHorizontalAndVerticalLine() {
        if (partnerId) {
            const currentColor = getColor(totalDrawnLines.current);
            let lineY = extractLineY();
            const {minX, maxX} = extractMinAndMaxX();

            g.append('line')
                .attr('x1', minX)
                .attr('y1', lineY)
                .attr('x2', maxX)
                .attr('y2', lineY)
                .attr('stroke', currentColor)
                .attr('stroke-width', 1);

            drawVerticalLine(id, lineY, currentColor, rectSizeY);

            if (node.partner) {
                drawVerticalLine(node.partner, lineY, currentColor, rectSizeY);
            }

            if (node.children && node.children.length > 0) {
                node.children.forEach(childId => {
                    const childNode = data.find(d => d.id === childId);
                    if (childNode) {
                        drawVerticalLine(childId, lineY, currentColor, 0);
                    }
                });
            }

            totalDrawnLines.current++;
            drawnLines[level] = drawnLines[level] + 1 || 1;
        }
    }

    function extractMinAndMaxX() {
        let xCoordinates = [];

        xCoordinates.push(drawnRectCoordinates[id].x + rectSizeX / 2);

        if (partnerId) {
            xCoordinates.push(drawnRectCoordinates[partnerId].x + rectSizeX / 2);
        }

        if (node.children && node.children.length > 0) {
            node.children.forEach(childId => {
                const childNode = data.find(d => d.id === childId);
                if (childNode) {
                    xCoordinates.push(drawnRectCoordinates[childId].x + rectSizeX / 2);
                }
            });
        }

        const minX = Math.min(...xCoordinates);
        const maxX = Math.max(...xCoordinates);
        return {minX, maxX};
    }

    function extractLineY() {
        const rowData = data.filter(d => d.level === level);
        const totalLines = rowData.reduce((acc, curr) => curr.partner ? acc + 1 : acc, 0);
        const totalLinesDrawn = drawnLines[level] || 0;

        let currentY = coordinates[level].y + rectSizeY;
        let nextY = coordinates[level + 1] ? coordinates[level + 1].y : currentY*1.2;

        const yScale = d3.scaleLinear()
            .domain([0, totalLines + 1])
            .range([currentY, nextY]);

        return yScale(totalLinesDrawn + 1);
    }

    function getColor(index) {
        const partners = new Set();
        data.forEach(item => {
            if (item.partner) {
                partners.add(item.partner);
            }
        });
        const hue = index * 360 / partners.size;
        return `hsl(${hue}, 100%, 50%)`;
    }

    function drawVerticalLine(nodeName, lineY, color, rectSizeY) {
        const nodeCenterX = drawnRectCoordinates[nodeName].x + rectSizeX / 2;
        const nodeBottomY = drawnRectCoordinates[nodeName].y + rectSizeY;

        g.append('line')
            .attr('x1', nodeCenterX)
            .attr('y1', nodeBottomY)
            .attr('x2', nodeCenterX)
            .attr('y2', lineY)
            .attr('stroke', color)
            .attr('stroke-width', 1);
    }
}

function D3Component({data}) {
    const ref = useRef();
    const totalDrawnLines = useRef(0);
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

        const dataIds = new Set();
        const drawnRectCoordinates = {};
        const drawnLines = {};
        data.forEach(node => {
            drawNextRectangle(node.level, g, coordinates, rectSizeX, rectSizeY, gapSize, node, dataIds, drawnRectCoordinates, data, drawnLines, totalDrawnLines);
        });
    }, [data, dimensions]);

    return <div ref={ref} style={{width: '100%', height: '100%', overflow: 'auto'}}></div>;
}

D3Component.propTypes = {
    data: PropTypes.arrayOf(PropTypes.shape({
        info: PropTypes.object,
        level: PropTypes.number.isRequired,
        id: PropTypes.string.isRequired,
        children: PropTypes.arrayOf(PropTypes.string),
        partner: PropTypes.string,
    })).isRequired,
};

export default D3Component;