let authObj = JSON.parse(window.localStorage.getItem('AuthObj'));
console.log(authObj);

if(authObj != null){
    fetch('http://localhost:9000/api/v1/cliente/loguin', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(authObj)

    })
        .then(function (response) {
            console.log(response.status)
            if (response.status == 200) {
                response.json().then(json => {
                    console.log(json);
                    localStorage.setItem('AuthObj', JSON.stringify(json))
                    document.getElementById("btnLogout").style.display = "inline";
                    document.getElementById("btnLogin").style.display = "none";
                    document.getElementById("btnCarrito").style.display = "inline";
                    
                 
                  });
                
            }else{
                response.json().then(json => {
                    console.log(json);})
                    location.href="http://localhost:9000/login";
            }
        })     
}else{
    location.href="http://localhost:9000/login";
}

function cerrarSesion(){
    window.localStorage.removeItem('AuthObj');
    return window.location.reload();
}
function irCarrito(){
    window.location.href = "http://localhost:9000/carrito/1";
}