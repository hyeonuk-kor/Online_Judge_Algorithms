class Stack {
    constructor() {
        this._arr = [];
    }
    push(item) {
        this._arr.push(item);
    }
    pop() {
        return this._arr.pop();
    }
    peek() {
        return this._arr[this._arr.length-1];
    }
    isEmpty() {
        return this._arr.length == 0;
    }
}
function solution(code) {
    var answer = [];
    var stack = new Stack();
    for(var i=0; i<code.length; i++) {
        console.log("Stack ")
        console.log(stack)
        console.log("\nAnswer "+answer)
        var str = code[i];
        if(!stack.isEmpty()) {
            var block_count = searchDot(str);
            var sp = searchDot(stack.peek());
            if(sp > block_count) {
                while(!stack.isEmpty() && searchDot(stack.peek())!==block_count) {
                    stack.pop();
                }
            }
        }
        if(str.indexOf("=")!==-1) {
            stack.push(str);
        } else {    // print
            var str_split = str.split(" ");
            var find = str_split[1];
            console.log("find="+find)
            var copiedStack = new Stack(); 
            copiedStack = cloneObject(stack);
            
            while(!copiedStack.isEmpty()) {
                if(copiedStack.peek().indexOf(find)!==-1) {
                    answer.push(copiedStack.peek().replace(/\./gi, ""));
                    break;
                } else {
                    copiedStack.pop();
                }
            }
            if(copiedStack.isEmpty()) {
                answer.push("error");
            }
        }
    }
    return answer;
}
function cloneObject(obj) {
    return Object.assign(
        Object.create(
            Object.getPrototypeOf(obj),
        ),
        JSON.parse(JSON.stringify(obj)),
    );
}
function searchDot(str) {
    var index = str.indexOf('.');
    var count = 0;
    while(index!==-1) {
        count++;
        index = str.indexOf('.', index+1);
    }
    return count;
}
//console.log("....s=3".replace(/\./gi, ""))
console.log(solution(["a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b", "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a"]));