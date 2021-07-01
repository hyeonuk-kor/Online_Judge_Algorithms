console.log(solution(8, 1));
function solution(brown, yellow) {
    var answer = [];
    var rectangle = brown + yellow;
    for(var i=rectangle; i>=1; i--) {
        var w = i;
        var h = rectangle/i;
        if(rectangle%i==0) {
            if((w-2)*(h-2)==yellow) {
                answer.push(w, h);
                break;
            }
        }
    }
    return answer;
}