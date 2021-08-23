function getPageData(dayTrade, pageSize, pageNumber) {
    // Your code goes here
    var map = new Map();
    var array = JSON.parse(dayTrade);
    for(var i=0; i<array.length; i++) {
        if(!map.get(array[i]['user'])) {
            map.set(array[i]['user'], array[i]['countOfStocks']);
        } else {
            map.set(array[i]['user'], map.get(array[i]['user'])+array[i]['countOfStocks']);
        }
    }
    for(var i of map.keys()) {
        console.log(i+" "+map.get(i));
    }
    var mapDec = new Map([...map.entries()].sort(function(a, b) {return b[1]-a[1]}));
    var result = [];
    for(var i=pageNumber; i<=
}
  
var dayTrade = 
  `[
    {"user": "Rob", "company": "Google", "countOfStocks": 5},
    {"user": "Bill", "company": "Goldman", "countOfStocks": 18},
    {"user": "Rob", "company": "JPMorgan", "countOfStocks": 10},
    {"user": "Dave", "company": "Boeing", "countOfStocks": 10}
]`;
  
console.log(getPageData(dayTrade, 1, 2)); // page size = 1, page number = 2