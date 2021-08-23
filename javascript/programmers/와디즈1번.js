function solution(passwords, s) {
    var answer = 0;
    var s_split = s.split('#');
    for(var i=0; i<s_split.length; i+=2) {
        for(var j=0; j<passwords.length; j++) {
            if(passwords[j][0]==s_split[i] && passwords[j][1]==s_split[i+1]) {
                answer++;
                break;
            }
        }
     }
    return answer;
}
console.log(solution([[101,1234],[102,54321],[201,202],[202,1]], "101#1234#102#654321#51#203#201#202#1#"))