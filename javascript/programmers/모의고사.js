function solution(answers) {
    var answer = [];
    var people = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ];
    var p = [];
    var max = 0;
    for(var i=0; i<people.length; i++) {
        p[i] = 0;
        for(var j=0; j<answers.length; j++) {
            if(people[i][j%(people[i].length)]==answers[j]) {
                p[i]++;
            }
        }
        max = Math.max(max, p[i]);
    }
    var answer_count = [];
    var index = 0;
    for(var i=0; i<p.length; i++) {
        if(p[i]==max) {
            answer_count[index++] = i+1;
        }
    }
    answer_count.sort();
    for(var i=0; i<answer_count.length; i++) {
        answer.push(answer_count[i]);
    }
    return answer;
}