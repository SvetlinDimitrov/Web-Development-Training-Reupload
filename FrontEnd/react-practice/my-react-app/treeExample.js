/*Tree example structure
const singleTree = {
    id,
    threeObjects:[]
}
Може да има и други неща.
*/

/*
TreeObject example structure
const singleTreeObject = {
    id,
    mother,
    father,
    children: []
}
Toва репресентира човек от дървото , може да има много повече полета ,
но основните са тези.
*/

/*
Начин на работа
Във всеки един treeObject : mother , father , children са обекти от тип TreeObject
Благодарение на тази структура това което можем да направим е да създадем един breadFirstSearch algo който да ни обиколи дървото и да ни даде хората в последователен ред.
Реда ще е от най-възрастните към най-младите което си мисля че ще ни помогне когато трябва да ги нанасяме тези неща на снимка.
Ако искаме да работи по този начин трябва threeObject , които ще са array в дъровото да са с null father i mother.
Например ако user-a e сложил в дървото 40 роднини ще трябва да ги nestnem , и в базата данни ще запазим само тези който имам майка и баща който са нулл
*/

// Пример


function example() {
    const tree = createTree(1);

    const treeObject = createTreeObject('Child1', 2);
    const treeObject2 = createTreeObject('Mother1', 3);
    const treeObject3 = createTreeObject('Father1', 4);

    const treeObject4 = createTreeObject('Child2', 5);
    const treeObject5 = createTreeObject('Mother2', 6);
    const treeObject6 = createTreeObject('Father2', 7);

    const treeObject7 = createTreeObject('Grandmother', 8);
    const treeObject8 = createTreeObject('Grandfather', 9);

    setTreeObjectMother(treeObject, treeObject2);
    setTreeObjectFather(treeObject, treeObject3);
    addTreeObjectChildren(treeObject2, treeObject);
    addTreeObjectChildren(treeObject3, treeObject);

    setTreeObjectMother(treeObject4, treeObject5);
    setTreeObjectFather(treeObject4, treeObject6);
    addTreeObjectChildren(treeObject5, treeObject4);
    addTreeObjectChildren(treeObject6, treeObject4);

    setTreeObjectMother(treeObject5, treeObject7);
    setTreeObjectFather(treeObject5, treeObject8);
    addTreeObjectChildren(treeObject7, treeObject5);
    addTreeObjectChildren(treeObject8, treeObject5);
    setTreeObjectMother(treeObject2, treeObject7);
    setTreeObjectFather(treeObject2, treeObject8);
    addTreeObjectChildren(treeObject7, treeObject2);
    addTreeObjectChildren(treeObject8, treeObject2);

    const treeObjects = [
        treeObject,
        treeObject2,
        treeObject3,
        treeObject4,
        treeObject5,
        treeObject6,
        treeObject7,
        treeObject8
    ];

    const rootObjects = treeObjects.filter(obj => obj.mother === null && obj.father === null);
    tree.treeObjects.push(...rootObjects);

    bfs(tree);
}

example();


function createTree(id) {
    return {
        id: id,
        treeObjects: []
    }
}

function createTreeObject(name, id) {
    return {
        id: id,
        name: name,
        mother: null,
        father: null,
        children: []
    }
}

function setTreeObjectMother(treeObject, mother) {
    treeObject.mother = mother;
}

function setTreeObjectFather(treeObject, father) {
    treeObject.father = father;
}

function addTreeObjectChildren(treeObject, children) {
    treeObject.children.push(children);
}

function bfs(tree) {
    let queue = [...tree.treeObjects];
    let visited = new Set();

    while (queue.length > 0) {
        let node = queue.shift();
        if (!visited.has(node.id)) {
            console.log(node.name + " - children: [" + node.children.map(child => child.name).join(", ") + "]");
            visited.add(node.id);
            queue.push(...node.children);
        }
    }
}