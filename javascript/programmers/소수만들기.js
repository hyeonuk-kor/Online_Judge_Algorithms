var check, answer=0;
console.log(solution([1,2,7,6,4]));
function solution(nums) {
    check = new Array(nums.length);
    getPrime(nums, [], 0, 0);    
    return answer;
}
function getPrime(nums, threeNumber, index, depth) {
    if(depth==3) {
        var sum = threeNumber.reduce(function(x, y) {return x+y;});
        var isPrime = sum>1?true:false;
        for(var i=2; i<sum; i++) {
            if(sum%i==0) {
                isPrime=false;
                break;
            }
        }
        if(isPrime) {
            answer++;
        }
        return;
    }
    for(var i=index; i<nums.length; i++) {
        if(!check[i]) {
            check[i] = true;
            threeNumber.push(nums[i]);
            getPrime(nums, threeNumber, i+1, depth+1);
            threeNumber.pop();
            check[i] = false;
        }
    }
}