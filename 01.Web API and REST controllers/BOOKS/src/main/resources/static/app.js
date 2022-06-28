console.log('My requests...')

let loadBooks = document.getElementById('loadBooks');

loadBooks.addEventListener('click', onLoadBookClick);

function onLoadBookClick(event) {
    let tableBody = document.getElementById('authors-container');
    tableBody.innerHTML = '';
    let requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://localhost:8080/api/books", requestOptions)
        .then(response => response.json())
        .then(result => result.forEach(book => addRecord(book)))
            .catch(error => console.log('error', error));
}

function addRecord(book) {
    let tableBody = document.getElementById('authors-container');

    let row = document.createElement('tr');
    row.setAttribute('id', book.id);
    let titleCol = document.createElement('td');
    let authorCol = document.createElement('td');
    let isbnCol = document.createElement('td');
    let actionCol = document.createElement('td');
    titleCol.textContent = book.title;
    authorCol.textContent = book.author.name;
    isbnCol.textContent = book.isbn;


    actionCol.append(createDeleteBtn(book.id));

    row.append(titleCol, authorCol, isbnCol, actionCol);
    tableBody.append(row);

}

function createDeleteBtn(id) {
    let btn = createBtn("Delete")
    btn.onclick = function () {
        let requestOptions = {
            method: 'DELETE',
            redirect: 'follow'
        };

        fetch("http://localhost:8080/api/books/" + id, requestOptions)
            .then(response => response.text())
            .then(result => {
                let element = document.getElementById(id);
                element.parentNode.removeChild(element);
            })
            .catch(error => console.log('error', error));
    };

    return btn;
}

function createBtn(name) {
    let btn = document.createElement("button");
    btn.textContent = name;
    return btn;
}

let btnSubmit = document.getElementById('submit');
btnSubmit.addEventListener('click', sendData);

function sendData() {
    const formElement = document.querySelector("form");
    const formData = new FormData(formElement);
    let data = JSON.stringify(Object.fromEntries(formData));

    let requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: data,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/api/books", requestOptions)
        .then(response => response.text())
        .then(result => addRecord(data))
        .catch(error => console.log('error', error));
}

btnSubmit.addEventListener('click', sendData);
