function solution(arr) {
    var answer = 0;
    var index = 0;
    arr.push(0);
    for(var i=0; i<arr.length; i++) {
        if(arr[i]==0) {
            answer += getResult(arr.slice(index, i));
            index = i+1;
        }
    }
    return answer;
}
function getResult(arr) {
    console.log(arr.length)
    if(arr.length<=1) {
        return arr.length;
    }
    console.log(arr);
}
console.log(solution([1, 2, 4, 0, 4, 2, 1]));