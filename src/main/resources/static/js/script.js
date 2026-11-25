// 페이지 로딩 시 질문 목록 가져오기
window.onload = function() {
    questionList();
}


// 질문 목록 가져오기
function questionList() {

    fetch("/quection")
        .then(response => response.json())
        .then(data => {

            let html = "";

            let label = [
                "전혀 그렇지 않다",
                "그렇지 않다",
                "보통입니다",
                "약간 그렇다",
                "매우 그렇다"
            ];
            for (let i = 0; i < data.length; i++) {
                html += "<div>";
                html += "<h3>";
                html += data[i].qno + ".";
                html += data[i].quection;
                html += "</h3>";
                for (let j = 1; j <= 5; j++) {

                    html += "<label>";
                    html += "<input type='radio' ";
                    html += "name='answer" + data[i].qno + "' ";
                    html += "value='" + j + "'>";
                    html += j + "점 (" + label[j - 1] + ")";
                    html += "</label><br>";
                }
                html += "</div><hr>";
            }

            document.getElementById("questionList").innerHTML = html;

        });
}


function submitList() {

    let answer = [];

    for (let i = 1; i <= 20; i++) {
        let selected = document.querySelector(
            "input[name='answer" + i + "']:checked"
        );
        if (selected == null) {
            alert(i + "번 질문에 응답 부탁드립니다");
            return;
        }
        let score = Number(selected.value);
        answer.push(score);
    }

    fetch("/calculation", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            answer: answer
        })
    })
    .then(response => response.json())
    .then(data => {
        alert("당신의 MBTI는 " + data.mbti + "입니다");
    });

}
