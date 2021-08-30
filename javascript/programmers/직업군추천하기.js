function solution(table, languages, preference) {
    var map = new Map();
    for (var i = 0; i < languages.length; i++) 
        map.set(languages[i], preference[i]);
    var calc = [];
    var max = -1;
    var max_symbol = '';
    for (var i = 0; i < table.length; i++) {
        calc[i] = 0;
        var tokenizer = table[i].split(' ');
        var symbol = tokenizer[0];
        for(var j=5; j>=1; j--) {
            var key = tokenizer[5-j+1];
            calc[i] += j * (map.has(key)?map.get(key):0);
        }
        if(max<calc[i]) {
            max = calc[i];
            max_symbol = symbol;
        } else if(max==calc[i]) {
            if(symbol<max_symbol)
                max_symbol = symbol;
        }
    }
    return max_symbol;
}
console.log(solution(["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"], ["PYTHON", "C++", "SQL"], [7, 5, 5]))