fetch('http://localhost:10001/pessoas?page=0&linesPage=10&orderBy=id&direction=DESC', {
    method: 'GET',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    }
})
.then(response => response.json())
.then(data => {
    const pessoasListElement = document.getElementById('pessoas-list');

        pessoasListElement.innerHTML = '';

        data.content.forEach((pessoa) => {
            const pessoaElement = document.createElement('div');
            pessoaElement.innerHTML = `<p>ID: ${pessoa.id}, Nome: ${pessoa.nome}</p>`;
            pessoasListElement.appendChild(pessoaElement);
        });
})
.catch(error => {
    console.error('Ocorreu um erro:', error);
});