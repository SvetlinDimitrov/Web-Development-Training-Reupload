import {useEffect, useRef, useState} from 'react';
import * as d3 from 'd3';
import PropTypes from 'prop-types';

function handleResize(setDimensions) {
    setDimensions({
        width: window.innerWidth,
        height: window.innerHeight
    });
}

function drawElements(g, rects, data, rectSizeX, rectSizeY, yScale) {
    data.forEach(d => {
        if (d.link && rects[d.name]) {
            d.link.forEach(link => {
                if (rects[link]) {
                    g.append('line')
                        .attr('x1', rects[d.name].x)
                        .attr('y1', rects[d.name].y + rectSizeY / 2)
                        .attr('x2', rects[link].x)
                        .attr('y2', rects[link].y - rectSizeY / 2)
                        .attr('stroke', 'black')
                        .attr('stroke-width', 1)
                        .attr("marker-end", "url(#end)");
                }
            });
        }
    });
}
function createArrowMarker(svg) {
    svg.append("defs").selectAll("marker")
        .data(["end"])
        .enter().append("marker")
        .attr("id", String)
        .attr("viewBox", "0 0 10 10")
        .attr("refX", 10)
        .attr("refY", 5)
        .attr("markerWidth", 6)
        .attr("markerHeight", 6)
        .attr("orient", "auto")
        .append("path")
        .attr("d", "M0,0L10,5L0,10L5,5L0,0");
}

function addZooming(svg, g) {
    svg.call(d3.zoom().on("zoom", function (event) {
        g.attr("transform", event.transform)
    }));
}

function D3Component({data}) {
    const ref = useRef();
    const [dimensions, setDimensions] = useState({
        width: window.innerWidth,
        height: window.innerHeight
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
        const levels = [...new Set(data.map(d => d.level))];
        const yScale = d3.scaleBand().domain(levels).range([0, dimensions.height]).padding(0.1);

        const svg = d3.select(ref.current)
            .append('svg')
            .attr('width', dimensions.width)
            .attr('height', dimensions.height);

        const g = svg.append('g');

        addZooming(svg, g);

        const rects = {};

        levels.forEach(level => {
            const rowData = data.filter(d => d.level === level);
            const totalWidth = rowData.length * (rectSizeX + gapSize) - gapSize;
            const startX = (dimensions.width - totalWidth) / 2;

            rowData.forEach((d, i) => {
                const x = startX + i * (rectSizeX + gapSize);
                const y = yScale(level);

                rects[d.name] = {x: x + rectSizeX / 2, y: y + rectSizeY / 2};

                g.append('rect')
                    .attr('x', x)
                    .attr('y', y)
                    .attr('width', rectSizeX)
                    .attr('height', rectSizeY)
                    .attr('fill', 'white')
                    .attr('stroke', 'black')
                    .attr('stroke-width', 1);

                g.append('text')
                    .attr('x', x + rectSizeX / 2)
                    .attr('y', y + rectSizeY / 2)
                    .attr('text-anchor', 'middle')
                    .attr('dominant-baseline', 'middle')
                    .text(d.name);
            });
        });

        createArrowMarker(svg);
        drawElements(g, rects, data, rectSizeX, rectSizeY, yScale);
    }, [data, dimensions]);

    return <div ref={ref} style={{width: '100%', height: '100%', overflow: 'auto'}}></div>;
}

D3Component.propTypes = {
    data: PropTypes.arrayOf(PropTypes.shape({
        level: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
    })).isRequired,
};

export default D3Component;