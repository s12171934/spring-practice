let rsp = ["/rock.png", "/scissors.png", "/paper.png"];

function fetchResult(you, computerNum) {
  let result = fetch("http://localhost:8080/rsp", {
    method: "POST",
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
    body: JSON.stringify({
      you: you.src,
      computer: computerNum,
    }),
  })
    .then((res) => res.json())
    .then((result) => {
      if (result.winner) {
        document.querySelector(".winner").className = "";
        document.querySelector(result.winner).className = "winner";
      }
      document.querySelector("#win").innerHTML = result.win;
      document.querySelector("#lose").innerHTML = result.lose;
      document.querySelector("#draw").innerHTML = result.draw;
    });
}

function fetchRefresh() {
  fetch("http://localhost:8080/rsp")
    .then((res) => res.json())
    .then((result) => {
      document.querySelector("#win").innerHTML = result.win;
      document.querySelector("#lose").innerHTML = result.lose;
      document.querySelector("#draw").innerHTML = result.draw;
    });
}

document.querySelector("#form").addEventListener("click", async (event) => {
  let you = document.querySelector("#you").firstElementChild;
  let computer = document.querySelector("#computer").firstElementChild;
  you.src = event.target.src;
  let computerNum = Math.floor(Math.random() * 3);
  computer.src = rsp[computerNum];
  fetchResult(you, computerNum);
});

fetchRefresh();
