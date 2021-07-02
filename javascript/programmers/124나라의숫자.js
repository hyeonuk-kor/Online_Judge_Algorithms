console.log(solution(100));
function solution(n) {
    console.log(-1%3);
    var answer = '';
    while(n>0) {
        if(n%3==0) {
            answer = 4 + answer;
            n = (n/3>>0) - 1;
        } else {
            answer = (n%3) + answer;
            n = (n/3>>0);
        }
    }
    return answer;
}