console.log(solution("23four5six7"))
function solution(s) {
    var number = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    for(var i=0; i<number.length; i++) {
        console.log(s.split(number[i]));
    }
    return parseInt(s);
}

function maxfind() {

}

