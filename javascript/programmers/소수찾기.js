console.log(solution("17"));
var check, set;
function solution(numbers) {
    var answer = 0;
    check = new Array(numbers.length);
    set = new Set([]);
    for(var i=1; i<=numbers.length; i++)
        makeNumber(numbers, [], 0, i);
    set.forEach(element => {
        if(isPrime(element))
            answer++;
    });
    return answer;
}
function isPrime(number) {
    if(number<=1) 
        return false;
    for(var i=2; i<number; i++) 
        if(number%i==0)
            return false;
    return true;
}
function makeNumber(numbers, str, depth, length) {
    if(depth==length) {
        set.add(parseInt(str.join("")));
        return;
    }
    for(var i=0; i<numbers.length; i++) {
        if(!check[i]) {
            check[i] = true;
            str.push(numbers.charAt(i));
            makeNumber(numbers, str, depth+1, length);
            str.pop();
            check[i] = false;
        }
    }
}