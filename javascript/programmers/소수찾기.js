console.log(solution("17"));
var check, allNumber;
function solution(numbers) {
    var answer = 0;
    check = new Array(numbers.length);
    allNumber = new Set([]);
    for(var i=1; i<=numbers.length; i++) {
        getNumber(numbers,[], 0, i);
    }
    allNumber.forEach(element => {
        var check = element>1?true:false;
        for(var i=2; i<element; i++) {
            if(element%i==0) {
                check=false;
                break;
            }
        }
        if(check) {
            answer++;
        }
    });
    return answer;
}
function getNumber(numbers, array, depth, end) {
    if(depth==end) {
        allNumber.add(parseInt(array.join("")));
        return;
    }
    for(var i=0; i<numbers.length; i++) {
        if(!check[i]) {
            check[i] = true;
            array.push(numbers.charAt(i));
            getNumber(numbers, array, depth+1, end);
            array.pop();
            check[i] = false;
        }
    }
}