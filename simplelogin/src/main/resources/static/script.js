let cookie = document.cookie;
if(cookie.includes("email")){
    let email = cookie.replace("email=","");
    document.querySelector("#email").value = email;
}
