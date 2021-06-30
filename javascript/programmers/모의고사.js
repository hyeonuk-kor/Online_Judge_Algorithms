function solution(answers) {
    var answer = [];
    var answer_sheets = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ];
    var student_score = [];
    var max = 0;
    for(var i=0; i<answer_sheets.length; i++) {
        student_score[i] = 0;
        for(var j=0; j<answers.length; j++) {
            if(answer_sheets[i][j%(answer_sheets[i].length)]==answers[j]) {
                student_score[i]++;
            }
        }
        if(max<student_score[i])
            max = student_score[i];
    }
    //var max = student_score.reduce(function(x, y) {return (x>y)?x:y;});
    var score = [];
    var score_index = 0;
    for(var i=0; i<student_score.length; i++) {
        if(student_score[i]==max) {
            score[score_index++] = i+1;
        }
    }
    score.sort();
    for(var i=0; i<score.length; i++) {
        answer.push(score[i]);
    }
    return answer;
}