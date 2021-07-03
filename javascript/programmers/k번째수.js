function solution(array, commands) {
    var answer = [];
    for(var i=0; i<commands.length; i++) {
        var list = array.slice(commands[i][0]-1, commands[i][1]);
        list.sort(function(a,b) {return a-b}); // 기본 sort는 알파벳 순서
        answer.push(list[commands[i][2]-1]);
    }
    return answer;
}