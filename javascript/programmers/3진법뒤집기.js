console.log(solution(125));
function solution(n) {
    var answer = 0;
    ternary_string = n.toString(3);
    reversal_string = ternary_string.split("").reverse().join("");
    answer = parseInt(reversal_string.toString(10), 3);
    return answer;
}