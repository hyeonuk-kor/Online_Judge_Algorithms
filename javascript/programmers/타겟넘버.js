console.log(solution([1,1,1,1,1],3))
function solution(numbers, target) {
    var answer = 0;
    getSum(0);
    function getSum(depth) {
        if(depth==numbers.length) {
            var sum = numbers.reduce(function(x,y) {return x+y});
            if(sum==target)
                answer++;
            return;
        }
        numbers[depth]*=-1;
        getSum(depth+1);
        numbers[depth]*=-1;
        getSum(depth+1);
    }
    return answer;
}