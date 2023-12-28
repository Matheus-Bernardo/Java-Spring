const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const IidUser = document.querySelector(".idUser");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Itelefone = document.querySelector(".telefone");


function login(){

    fetch("http://localhost:8080/usuarios/login",
        {
            mode: "cors",
            headers:{
                'Accept' : 'application/json',
                'Content-Type' : 'application/json',
            },
            method: "POST",
            body: JSON.stringify({
                id : IidUser.value,
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
                telefone: Itelefone.value      
            })
            })
            .then(function (res) {

                if(res.ok){
                    window.location.href= "Home.html";
                }else{
                    console.log(res)}
                }           
            )
            .catch(function (res) {console.log(res)})

}

function limpar(){
    IidUser.value = ""
    Inome.value = ""
    Iemail.value = ""
    Isenha.value = ""
    Itelefone.value = ""
};

formulario.addEventListener('submit',function (event){
    event.preventDefault();
    login();
    limpar();
});